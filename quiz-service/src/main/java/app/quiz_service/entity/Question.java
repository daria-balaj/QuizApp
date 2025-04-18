package app.quiz_service.entity;

import lombok.Data;
@Data
public class Question {

    private Long id;
    private String text;
    private Category category;
    private int difficulty;
}