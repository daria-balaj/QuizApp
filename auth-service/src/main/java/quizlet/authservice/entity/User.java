package quizlet.authservice.entity;
import java.time.LocalDateTime;

public class User {
    private Long id;
    private String username;
    private String email;
    private String hashedPassword;
    private LocalDateTime createdAt = LocalDateTime.now();
}