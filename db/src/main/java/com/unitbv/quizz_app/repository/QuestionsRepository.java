package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Category;
import com.unitbv.quizz_app.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    @Query(value = """
    SELECT * FROM questions 
    WHERE category_id IN (:categoryIds) 
    AND difficulty = :difficulty 
    ORDER BY RANDOM() 
    LIMIT :limit
""", nativeQuery = true)
    List<Questions> findRandomQuestions(
            @Param("categoryIds") List<Long> categoryIds,
            @Param("difficulty") Integer difficulty,
            @Param("limit") Integer limit
    );
    List<Questions> findByCategoryIn(List<Category> categories);
    List<Questions> findByDifficulty(int difficulty);
    List<Questions> findByCategoryInAndDifficulty(List<Category> categories, int difficulty);
    @Query("""
    select q.difficulty from Questions q where q.id = :id
    """)
    int getDifficultyById(Long id);
    long countByCategory(Category category);
    long countByDifficulty(int difficulty);
}
