package app.quiz_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    
    private UUID id;

    private int correctAnswerCount;

    private int score;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

}