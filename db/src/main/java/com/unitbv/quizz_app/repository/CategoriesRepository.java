package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Optional<Categories> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
    List<Categories> findByNameContainingIgnoreCase(String searchTerm);
    List<Categories> findAllByOrderByNameAsc();
    @Query("SELECT DISTINCT c FROM Categories c JOIN Questions q ON q.category=c")
    List<Categories> findCategoriesWithQuestions();
}
