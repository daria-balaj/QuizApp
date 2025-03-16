package app.quiz_service.service;

import app.quiz_service.entity.Questions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuestionsService {
    //CRUD operations
    Questions createQuestion(String text, Long categoryId, Long difficultyId);
    Optional<Questions> getQuestionById(Long id);
    List<Questions> getAllQuestions();
    Page<Questions> getQuestionsPage(Pageable pageable);
    Questions updateQuestion(Long id, String text, Long categoryId, Long difficultyId);
    void deleteQuestion(Long id);

    //Filtering operations
    List<Questions> getQuestionsByCategory(Long categoryId);
    List<Questions> getQuestionsByDifficulty(Long difficultyId);
    List<Questions> getQuestionsByCategoryAndDifficulty(Long categoryId, Long difficultyId);
    List<Questions> searchQuestions(String searchTerm);

    // Statistics operations
    long countQuestionsByCategory(Long categoryId);
    long countQuestionsByDifficulty(Long difficultyId);

    // Quiz generation
    List<Questions> getRandomQuestions(Long categoryId, Long difficultyId, int count);

}
