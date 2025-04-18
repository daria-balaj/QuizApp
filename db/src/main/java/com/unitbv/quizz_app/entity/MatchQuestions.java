package com.unitbv.quizz_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="match_questions")
@Data
public class MatchQuestions {

    @EmbeddedId
    private MatchQuestionId id;


    @ManyToOne
    @MapsId("matchId")
    @JoinColumn(name="match_id")
    private Match match;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name="question_id")
    private Questions question;

    @Column(name="question_order", nullable = false)
    private int questionOrder;

    @Embeddable
    @Data
    public static class MatchQuestionId implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name="match_id")
        private Long matchId;

        @Column(name="question_id")
        private Long questionId;

    }
    
}
