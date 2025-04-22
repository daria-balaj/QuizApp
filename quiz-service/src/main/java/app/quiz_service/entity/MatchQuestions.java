package app.quiz_service.entity;

import java.io.Serial;


public class MatchQuestions {

    private MatchQuestionId id;
    private Match match;
    private Question question;
    private int questionOrder;

    public static class MatchQuestionId implements java.io.Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private Long matchId;

        private Long questionId;

    }
    
}
