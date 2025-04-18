package com.unitbv.quizz_app.service;

import com.unitbv.quizz_app.entity.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswersService {
    List<Answer> getAllAnswers();
    Optional<Answer> getAnswersById(Long id);
    List<Answer> getAnswersByQuestionId(Long questionId);
    Long getCorrectAnswerId(Long questionId);
    Answer saveAnswer(Answer answer);
    Answer updateAnswer(Answer answer);
    void deleteAnswer(Long id);
}
