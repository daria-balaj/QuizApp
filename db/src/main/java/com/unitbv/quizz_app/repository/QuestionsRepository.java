package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Category;
import com.unitbv.quizz_app.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByCategoryIn(List<Category> categories);
    List<Questions> findByDifficulty(int difficulty);
    List<Questions> findByCategoryInAndDifficulty(List<Category> categories, int difficulty);
    long countByCategory(Category category);
    long countByDifficulty(int difficulty);
}
