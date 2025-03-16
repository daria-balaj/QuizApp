package app.quiz_service.service;

import app.quiz_service.entity.Categories;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {
    Categories createCategory(String name);
    List<Categories> getAllCategories();
    List<Categories> getAllCategoriesSorted();
    List<Categories> searchCategories(String searchTerm);
    List<Categories> getCategoriesWithQuestions();
    Optional<Categories> getCategoryById(Long id);
    Optional<Categories> getCategoryByName(String name);
    boolean categoryExists(String name);
    Categories updateCategory(Long id, String name);
    void deleteCategory(Long id);
}