package quizlet.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import quizlet.authservice.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private boolean success;
    private String message;
    private UserDTO user;
}
