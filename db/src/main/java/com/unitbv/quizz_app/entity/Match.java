package com.unitbv.quizz_app.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "matches")
@Data
public class Match {
    
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;


    @Column(name = "correct_answers")
    private int correctAnswerCount;

    @Column(name = "score")
    private int score;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

}