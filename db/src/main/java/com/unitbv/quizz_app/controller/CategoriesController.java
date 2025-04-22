package com.unitbv.quizz_app.controller;

import com.unitbv.quizz_app.entity.Category;
import com.unitbv.quizz_app.service.CategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(
            @RequestParam(required = false) Boolean sorted,
            @RequestParam(required = false) Boolean withQuestions
    ) {
        long start = System.currentTimeMillis();

        List<Category> categories;
        if(Boolean.TRUE.equals(withQuestions)) {
            categories = categoriesService.getCategoriesWithQuestions();
        } else if(Boolean.TRUE.equals(sorted)) {
            categories = categoriesService.getAllCategoriesSorted();
        } else {
            categories = categoriesService.getAllCategories();
        }

        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Category>> searchCategories(@RequestParam String term) {
        List<Category> categories = categoriesService.searchCategories(term);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoriesService.getCategoryById(id);
        return category.map(ResponseEntity :: ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-name/name")
    public ResponseEntity<Category> getCategoryByName(@RequestParam String name) {
        Optional<Category> category = categoriesService.getCategoryByName(name);
        return category.map(ResponseEntity :: ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
/*
    @PostMapping
    public ResponseEntity<Categories> createCategory(@RequestParam String name) {
        if(categoriesService.categoryExists(name))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Categories category = categoriesService.createCategory(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestParam String name) {
        Optional<Categories> existingCategory = categoriesService.getCategoryByName(name);
        if(existingCategory.isPresent() && !existingCategory.get().getId().equals(id))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        Categories updatedCategory = categoriesService.updateCategory(id, name);
        return updatedCategory != null ?
                ResponseEntity.ok(updatedCategory) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categories> deleteCategory(@PathVariable Long id) {
        Optional<Categories> category = categoriesService.getCategoryById(id);
        if(category.isEmpty())
                return ResponseEntity.notFound().build();
        categoriesService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

*/
}
