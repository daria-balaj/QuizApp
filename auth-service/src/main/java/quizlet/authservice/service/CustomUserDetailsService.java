package quizlet.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import quizlet.authservice.dto.RegisterResponse;
import quizlet.authservice.dto.UserDTO;
import quizlet.authservice.dto.UserDetailsDTO;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final String dbServiceUrl = "http://localhost:8080/api";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        String url = dbServiceUrl + "/users/find/" + identifier;

        ResponseEntity<UserDetailsDTO> response = restTemplate.getForEntity(url, UserDetailsDTO.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return new User(
                    response.getBody().getUsername(), response.getBody().getHashedPassword(), new ArrayList<>()
            );
        }
        else throw new UsernameNotFoundException("User not found");

    }
}
