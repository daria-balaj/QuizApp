package com.unitbv.quizz_app.service;

import com.unitbv.quizz_app.entity.Answers;
import com.unitbv.quizz_app.entity.Questions;

import java.util.List;
import java.util.Optional;

public interface AnswersService {
    List<Answers> getAllAnswers();
    Optional<Answers> getAnswersById(Long id);
    List<Answers> getAnswersByQuestionId(Long questionId);
    List<Answers> getCorrectAnswers();
    List<Answers> getIncorrectAnswers();
    Answers saveAnswer(Answers answer);
    Answers updateAnswer(Answers answer);
    void deleteAnswer(Long id);
}
