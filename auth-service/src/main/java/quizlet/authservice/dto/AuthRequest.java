package quizlet.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequest {
    private String identifier;
    private String password;
}

