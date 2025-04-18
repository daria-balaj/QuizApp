package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnswersRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);
    Answer findByQuestionIdAndIsCorrectTrue(Long questionId);
}
