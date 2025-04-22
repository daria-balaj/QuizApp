package com.unitbv.quizz_app.controller;

import com.unitbv.quizz_app.entity.Questions;
import com.unitbv.quizz_app.service.QuestionsService;
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
            @RequestParam(name= "categoryId") List<Long> categoryIds,
            @RequestParam(name = "difficulty") int difficulty,
            @RequestParam(name = "count") int count
    ) {
        List<Questions> questions;

        if (categoryIds != null && !categoryIds.isEmpty() &&
            difficulty >= 1 && difficulty <= 3 &&
            count >= 1) {
            questions = questionsService.getQuestionSet(categoryIds, difficulty, count);
        } else if (categoryIds != null && !categoryIds.isEmpty()) {
            questions = questionsService.getQuestionsByCategories(categoryIds);
        } else if (difficulty >= 1 && difficulty <= 3) {
            questions = questionsService.getQuestionsByDifficulty(difficulty);
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


    @GetMapping("difficulty/{id}")
    public Integer getQuestionDifficultyById(@PathVariable Long id) {
        return questionsService.getQuestionDifficulty(id);
    }

    @PostMapping
    public ResponseEntity<Questions> createQuestion(
            @RequestParam String text,
            @RequestParam Long categoryId,
            @RequestParam int difficulty
    ) {
        try {
            Questions question = questionsService.createQuestion(text, categoryId, difficulty);
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
