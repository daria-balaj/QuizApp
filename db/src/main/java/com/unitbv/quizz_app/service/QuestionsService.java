package com.unitbv.quizz_app.service;

import com.unitbv.quizz_app.entity.Questions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuestionsService {
    //CRUD operations
    Questions createQuestion(String text, Long categoryId, Long difficultyId);
    Optional<Questions> getQuestionById(Long id);
    List<Questions> getAllQuestions();
    Questions updateQuestion(Long id, String text, Long categoryId, Long difficultyId);
    void deleteQuestion(Long id);

    //Filtering operations
    List<Questions> getQuestionsByCategories(List<Long> categoryIds);
    List<Questions> getQuestionsByDifficulty(Long difficultyId);
    List<Questions> getQuestionsByCategoriesAndDifficulty(List<Long> categoryIds, Long difficultyId);

    // Statistics operations
    long countQuestionsByCategory(Long categoryId);
    long countQuestionsByDifficulty(Long difficultyId);
}
