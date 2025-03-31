package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Categories;
import com.unitbv.quizz_app.entity.Questions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByCategoryIn(List<Categories> categories);
    List<Questions> findByDifficultyId(Long difficulty);
    List<Questions> findByCategoryInAndDifficultyId(List<Categories> categories, Long difficulty);
    long countByCategory(Categories category);
    long countByDifficultyId(Long difficulty);
}
