package app.quiz_service.dto;

import lombok.Data;

import java.time.Duration;

@Data
public class ResultDTO {

    private int correctAnswers;

    private int score;

    private String time;
}
