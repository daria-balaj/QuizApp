package app.quiz_service.entity;

import lombok.Data;

import java.io.Serial;


public class MatchParticipants {

    private MatchParticipantId id;

    private Matches match;

    private Integer score = 0;

    public static class MatchParticipantId implements java.io.Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private Long matchId;

        private Long userId;
    }
    
}
