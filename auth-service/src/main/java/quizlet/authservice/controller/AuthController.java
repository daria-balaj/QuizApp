package quizlet.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import quizlet.authservice.config.JwtUtil;
import quizlet.authservice.dto.*;
import quizlet.authservice.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private RestTemplate restTemplate;
//    private final String dbServiceUrl = "http://localhost:8080/api";
    private final String dbServiceUrl = "http://db-service:8080/api";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("username-available")
    public ResponseEntity<Boolean> checkUsername(@RequestParam("username") String username) {
        try {
            ResponseEntity<Boolean> response = restTemplate.getForEntity(
                    dbServiceUrl + "/users/is-available/" + username,
                    Boolean.class
            );
            return ResponseEntity.ok(response.getBody());
        } catch (Exception ex) {}

        return ResponseEntity.ok(false);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            //checking if username is in use
            String url = dbServiceUrl + "/users/find/" + request.getUsername();
            ResponseEntity<UserDetailsDTO> response = restTemplate.getForEntity(url, UserDetailsDTO.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return ResponseEntity.badRequest().body("User already exists");
            }

            //checking if email is in use
            url = dbServiceUrl + "/users/find/" + request.getEmail();
            response = restTemplate.getForEntity(url, UserDetailsDTO.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return ResponseEntity.badRequest().body("User already exists");
            }

        } catch (HttpClientErrorException.NotFound e) {
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setUsername(request.getUsername());
            registerRequest.setEmail(request.getEmail());
            registerRequest.setPassword(passwordEncoder.encode(request.getPassword()));

            ResponseEntity<RegisterResponse> creationResponse = restTemplate.postForEntity(
                    dbServiceUrl + "/users/create",
                    registerRequest,
                    RegisterResponse.class
            );

            if (creationResponse.getStatusCode() == HttpStatus.CREATED && creationResponse.getBody() != null) {
                UserDTO createdUser = creationResponse.getBody().getUser();
                String token = jwtUtil.generateToken(createdUser.getUsername());

                return ResponseEntity.ok(new AuthResponse(token));
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User could not be created");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("User could not be created");
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            String url = dbServiceUrl + "/users/find/" + request.getIdentifier();
            ResponseEntity<UserDetailsDTO> response = restTemplate.getForEntity(url, UserDetailsDTO.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                UserDetailsDTO userDetails = response.getBody();
                if (BCrypt.checkpw(request.getPassword(), userDetails.getHashedPassword())) {
                    String token = jwtUtil.generateToken(request.getIdentifier());
                    return ResponseEntity.ok(new AuthResponse(token));
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse(null));
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AuthResponse(null));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AuthResponse(null));
        }
    }

/*

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestParam String username, @RequestParam String email, @RequestParam String password) {
        Users updatedUser = usersService.updateUser(id, username, email, password);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

 */
}