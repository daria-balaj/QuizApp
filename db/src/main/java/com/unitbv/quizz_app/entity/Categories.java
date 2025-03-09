package com.unitbv.quizz_app.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="categories")
@Data
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;

    
    
}
