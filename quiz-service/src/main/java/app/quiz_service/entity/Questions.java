package app.quiz_service.entity;

import lombok.Data;
@Data
public class Questions {

    private Long id;
    private String text;
    private Categories category;
    private Difficulties difficulty;
}