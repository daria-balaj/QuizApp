package app.quiz_service.entity;

import java.time.LocalDateTime;

public class Matches {
    
    private Long id;

    private Category category;

    private Difficulties difficulty;

    private MatchStatus status = MatchStatus.ACTIVE;
    
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime endedAt;
    
    public enum MatchStatus {
        ACTIVE, COMPLETED, CANCELED;
    }
}