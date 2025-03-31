package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Answers;
import com.unitbv.quizz_app.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AnswersRepository extends JpaRepository<Answers, Long> {
    List<Answers> findByQuestionId(Long questionId);
}
