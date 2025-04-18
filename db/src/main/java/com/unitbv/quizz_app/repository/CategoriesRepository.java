package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
    List<Category> findByNameContainingIgnoreCase(String searchTerm);
    List<Category> findAllByOrderByNameAsc();
    @Query("SELECT DISTINCT c FROM Category c JOIN Questions q ON q.category=c")
    List<Category> findCategoriesWithQuestions();
}
