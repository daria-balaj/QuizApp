package app.quiz_service.entity;

import lombok.Data;

@Data
public class Answers {
    private Long id;

    private Question question;

    private String text;
    private boolean is_correct;
}