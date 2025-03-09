package com.unitbv.quizz_app.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="difficulties")
@Data
public class Difficulties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "difficulty_id")
    private Long id;

    @Column(name = "level", unique = true, nullable = false, length=50)
    private String level;
    
}
