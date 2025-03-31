package com.unitbv.quizz_app.controller;

import com.unitbv.quizz_app.entity.Questions;
import com.unitbv.quizz_app.service.QuestionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionsController {

    private final QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }



    @GetMapping
    public ResponseEntity<List<Questions>> getAllQuestions(
            @RequestParam(required = false) List<Long> categoryId,
            @RequestParam(required = false) Long difficultyId
    ) {
        List<Questions> questions;

        if (categoryId != null && !categoryId.isEmpty() && difficultyId != null) {
            questions = questionsService.getQuestionsByCategoriesAndDifficulty(categoryId, difficultyId);
        } else if (categoryId != null && !categoryId.isEmpty()) {
            questions = questionsService.getQuestionsByCategories(categoryId);
        } else if (difficultyId != null) {
            questions = questionsService.getQuestionsByDifficulty(difficultyId);
        } else {
            questions = questionsService.getAllQuestions();
        }

        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questions> getQuestionById(@PathVariable Long id) {
        Optional<Questions> question = questionsService.getQuestionById(id);
        return question.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/count/category/{categoryId}")
    public ResponseEntity<Long> countQuestionsByCategory(@PathVariable Long categoryId) {
        long count = questionsService.countQuestionsByCategory(categoryId);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/count/difficulty/{difficultyId}")
    public ResponseEntity<Long> countQuestionsByDifficulty(@PathVariable Long difficultyId) {
        long count = questionsService.countQuestionsByDifficulty(difficultyId);
        return ResponseEntity.ok(count);
    }

    @PostMapping
    public ResponseEntity<Questions> createQuestion(
            @RequestParam String text,
            @RequestParam Long categoryId,
            @RequestParam Long difficultyId
    ) {
        try {
            Questions question = questionsService.createQuestion(text, categoryId, difficultyId);
            return ResponseEntity.status(HttpStatus.CREATED).body(question);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
/*
    @PutMapping("/{id}")
    public ResponseEntity<Questions> updateQuestion(
            @PathVariable Long id,
            @RequestParam  String text,
            @RequestParam Long categoryId,
            @RequestParam Long difficultyId
    ) {
        try{
            Questions updatedQuestion = questionsService.updateQuestion(id, text, categoryId, difficultyId);
            return ResponseEntity.ok(updatedQuestion);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        Optional<Questions>  question = questionsService.getQuestionById(id);
        if(question.isEmpty())
            return ResponseEntity.notFound().build();
        questionsService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
*/
}
