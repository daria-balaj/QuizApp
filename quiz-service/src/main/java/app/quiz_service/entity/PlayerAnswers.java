package app.quiz_service.entity;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class PlayerAnswers {


    private Long id;
    private Matches match;
    private Questions question;
    private Answers chosenAnswer;
    private LocalDateTime answeredAt = LocalDateTime.now();
}