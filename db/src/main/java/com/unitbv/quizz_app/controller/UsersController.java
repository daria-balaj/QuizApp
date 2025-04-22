package com.unitbv.quizz_app.controller;

import com.unitbv.quizz_app.dto.*;
import com.unitbv.quizz_app.entity.User;
import com.unitbv.quizz_app.exceptions.UserAlreadyExistsException;
import com.unitbv.quizz_app.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/test")
    public RegisterResponse test() {
        return new RegisterResponse(true, "yay", null);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("find/{identifier}")
    public ResponseEntity<UserDetailsDTO> findByIdentifier(@PathVariable String identifier) {
        try {
            Optional<User> user = usersService.getByUsernameOrEmail(identifier);

            if (!user.isEmpty()) {
                return ResponseEntity.ok(new UserDetailsDTO(user.get().getId(), user.get().getEmail(), user.get().getUsername(), user.get().getHashedPassword()));
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserDetailsDTO(null, null, null, null));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new UserDetailsDTO(null, null, null, null));
        }
    }

    @GetMapping("is-available/{username}")
    public ResponseEntity<Boolean> getUserByUsername(@PathVariable String username) {
        Optional<User> user = usersService.getUserByUsername(username);
//        System.out.println(username + ' ' + user.get(). + ' ' + user.isEmpty());
        return ResponseEntity.ok(user.isEmpty());
    }

    @PostMapping("create")
    public ResponseEntity<RegisterResponse> createUser(@RequestBody RegisterRequest request) {
        try {
            User user = usersService.createUser(request.getUsername(), request.getEmail(), request.getPassword());

            UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getEmail());

            RegisterResponse response = new RegisterResponse(true, "User created successfully", userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
            RegisterResponse response = new RegisterResponse(false, "User already exists", null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            RegisterResponse response = new RegisterResponse(false, "Internal server error", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            Optional<User> user = usersService.getByUsernameOrEmail(request.getIdentifier());

            if (user.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new LoginResponse(false, "User not found", null));
            }

            return ResponseEntity.ok(new LoginResponse(true, "User found", user));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new LoginResponse(false, "Internal server error", null));
        }
    }
}