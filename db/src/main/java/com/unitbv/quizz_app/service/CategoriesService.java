package com.unitbv.quizz_app.service;

import com.unitbv.quizz_app.entity.Category;
import java.util.List;
import java.util.Optional;

public interface CategoriesService {
    Category createCategory(String name);
    List<Category> getAllCategories();
    List<Category> getAllCategoriesSorted();
    List<Category> searchCategories(String searchTerm);
    List<Category> getCategoriesWithQuestions();
    Optional<Category> getCategoryById(Long id);
    Optional<Category> getCategoryByName(String name);
    boolean categoryExists(String name);
    Category updateCategory(Long id, String name);
    void deleteCategory(Long id);
}