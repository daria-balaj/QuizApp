package com.unitbv.quizz_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="match_participants")
@Data
public class MatchParticipants {

    @EmbeddedId
    private MatchParticipantId id;

    @ManyToOne
    @MapsId("matchId")
    @JoinColumn(name="match_id")
    private Match match;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id")
    private Users user;

    @Column(name="score", nullable = false)
    private Integer score = 0;

    @Embeddable
    @Data
    public static class MatchParticipantId implements java.io.Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name="match_id")
        private Long matchId;

        @Column(name="user_id")
        private Long userId;
    }
    
}
