package com.unitbv.quizz_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="answers")
@Data
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")  
    private Long id;

    @ManyToOne
    @JoinColumn(name= "question_id", nullable = false)
    private Questions question;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name="is_correct", nullable = false)
    private boolean is_correct;
}