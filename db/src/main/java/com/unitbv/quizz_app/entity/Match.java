package com.unitbv.quizz_app.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@Data
public class Match {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @Column(name="difficulty_id", nullable = false)
    private Long difficultyId;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private MatchStatus status = MatchStatus.ACTIVE;
    
    @Column(name="created_at", nullable=false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "ended_at")
    private LocalDateTime endedAt;
    
    public enum MatchStatus {
        ACTIVE, COMPLETED, CANCELED;
    }
}