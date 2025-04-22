package com.unitbv.quizz_app.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "player_answers")
@Data
public class PlayerAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_answer_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;

    @ManyToOne
    @JoinColumn(name = "chosen_answer_id", nullable = false)
    private Answer chosenAnswer;
    
    @Column(name = "answered_at", nullable = false, updatable = false)
    private LocalDateTime answeredAt = LocalDateTime.now();
}