package quizlet.authservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsDTO {
    private Long id;
    private String username;
    private String email;
    private String hashedPassword;
}
