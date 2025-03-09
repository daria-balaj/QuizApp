package com.unitbv.quizz_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "questions")
@Data
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "difficulty_id", nullable = false)
    private Difficulties difficulty;
}