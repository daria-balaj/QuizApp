package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Categories;
import com.unitbv.quizz_app.entity.Difficulties;
import com.unitbv.quizz_app.entity.Questions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByCategory(Categories category);
    List<Questions> findByDifficulty(Difficulties difficulty);
    List<Questions> findByCategoryAndDifficulty(Categories category, Difficulties difficulty);
    List<Questions> findByTextContainingIgnoreCase(String searchTerm);
    Page<Questions> findAll(Pageable pageable);
    Page<Questions> findByCategory(Categories category, Pageable pageable);
    Page<Questions> findByDifficulty(Difficulties difficulty, Pageable pageable);
    Page<Questions> findByCategoryAndDifficulty(Categories category, Difficulties difficulty, Pageable pageable);
    @Query(value = "SELECT q FROM Questions q WHERE q.category = :category AND q.difficulty = :difficulty ORDER BY FUNCTION('RANDOM') LIMIT :limit")
    List<Questions> findRandomQuestions(@Param("category") Categories category,
                                        @Param("difficulty") Difficulties difficulty,
                                        @Param("limit") int limit);
    long countByCategory(Categories category);
    long countByDifficulty(Difficulties difficulty);
}
