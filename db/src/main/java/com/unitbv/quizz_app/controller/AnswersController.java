package com.unitbv.quizz_app.controller;

import com.unitbv.quizz_app.entity.Answer;
import com.unitbv.quizz_app.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
@CrossOrigin(origins = "http://localhost:4200")
public class AnswersController {
    private final AnswersService answersService;

    @Autowired
    public AnswersController(AnswersService answersService) {
        this.answersService = answersService;
    }

    @GetMapping
    public List<Answer> getAllAnswers() {
        return answersService.getAllAnswers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        return answersService.getAnswersById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Answer>> getAnswersByQuestionId(@PathVariable Long questionId) {
        List<Answer> answers = answersService.getAnswersByQuestionId(questionId);
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/question/{questionId}/correct-answer")
    public ResponseEntity<Long> getCorrectAnswer(@PathVariable Long questionId) {
        Long id = answersService.getCorrectAnswerId(questionId);
        return ResponseEntity.ok(id);
    }
/*
    @GetMapping("/correct")
    public ResponseEntity<List<Answers>> getCorrectAnswers() {
        return ResponseEntity.ok(answersService.getCorrectAnswers());
    }

    @GetMapping("/incorrect")
    public ResponseEntity<List<Answers>> getIncorrectAnswers() {
        return ResponseEntity.ok(answersService.getIncorrectAnswers());
    }

    @PostMapping
    public ResponseEntity<Answers> createAnswer(@RequestBody Answers answer) {
        Answers savedAnswer = answersService.saveAnswer(answer);
        return new ResponseEntity<>(savedAnswer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answers> updateAnswer(@PathVariable Long id, @RequestBody Answers answer) {
        return answersService.getAnswersById(id)
                .map(existingAnswer -> {
                    answer.setId(id);
                    return ResponseEntity.ok(answersService.updateAnswer(answer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        return answersService.getAnswersById(id)
                .map(answer -> {
                    answersService.deleteAnswer(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(ResponseEntity.notFound().build());
    }

 */
}

