package app.quiz_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionsController {

//    private final QuestionsService questionsService;
//
//    public QuestionsController(QuestionsService questionsService) {
//        this.questionsService = questionsService;
//    }
//
//
//
//    @GetMapping
//    public ResponseEntity<List<Questions>> getAllQuestions(
//            @RequestParam(required = false) Long categoryId,
//            @RequestParam(required = false) Long difficultyId,
//            @RequestParam(required = false) String searchTerm
//            ) {
//        List<Questions> questions;
//
//        if(categoryId != null && difficultyId != null) {
//            questions = questionsService.getQuestionsByCategoryAndDifficulty(categoryId, difficultyId);
//        } else if (categoryId != null) {
//            questions = questionsService.getQuestionsByCategory(categoryId);
//        } else if (difficultyId != null) {
//            questions = questionsService.getQuestionsByDifficulty(difficultyId);
//        } else {
//            questions = questionsService.getAllQuestions();
//        }
//
//        return ResponseEntity.ok(questions);
//
//    }
//
//    @GetMapping("/page")
//    public ResponseEntity<Page<Questions>> getQuestionsPage(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id") String sort
//    ) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
//        Page<Questions> questionsPage = questionsService.getQuestionsPage(pageable);
//        return ResponseEntity.ok(questionsPage);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Questions> getQuestionById(@PathVariable Long id) {
//        Optional<Questions> question = questionsService.getQuestionById(id);
//        return question.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/random")
//    public ResponseEntity<List<Questions>> getRandomQuestions (
//            @RequestParam Long categoryId,
//            @RequestParam Long difficultyId,
//            @RequestParam(defaultValue = "10") int count
//    ) {
//        List<Questions> questions = questionsService.getRandomQuestions(categoryId, difficultyId, count);
//
//        if(questions.isEmpty())
//            return ResponseEntity.noContent().build();
//
//        return ResponseEntity.ok(questions);
//    }
//
//    @GetMapping("/count/category/{categoryId}")
//    public ResponseEntity<Long> countQuestionsByCategory(@PathVariable Long categoryId) {
//        long count = questionsService.countQuestionsByCategory(categoryId);
//        return ResponseEntity.ok(count);
//    }
//
//    @GetMapping("/count/difficulty/{difficultyId}")
//    public ResponseEntity<Long> countQuestionsByDifficulty(@PathVariable Long difficultyId) {
//        long count = questionsService.countQuestionsByDifficulty(difficultyId);
//        return ResponseEntity.ok(count);
//    }
//
//    @PostMapping
//    public ResponseEntity<Questions> createQuestion(
//            @RequestParam String text,
//            @RequestParam Long categoryId,
//            @RequestParam Long difficultyId
//    ) {
//        try {
//            Questions question = questionsService.createQuestion(text, categoryId, difficultyId);
//            return ResponseEntity.status(HttpStatus.CREATED).body(question);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
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
