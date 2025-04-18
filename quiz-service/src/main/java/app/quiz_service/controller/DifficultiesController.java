package app.quiz_service.controller;

import app.quiz_service.entity.Difficulties;
import app.quiz_service.service.DifficultiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/difficulties")
@CrossOrigin(origins = "http://localhost:4200")
public class DifficultiesController {

//    private final DifficultiesService difficultiesService;
//
//    public DifficultiesController(DifficultiesService difficultiesService) {
//        this.difficultiesService = difficultiesService;
//    }
//
//
//
//    @GetMapping
//    public ResponseEntity<List<Difficulties>> getAllDifficulties(
//            @RequestParam(required = false) Boolean sorted
//    ) {
//        List<Difficulties> difficulties = Boolean.TRUE.equals(sorted) ?
//                difficultiesService.getAllDifficultiesSorted() :
//                difficultiesService.getAllDifficulties();
//        return ResponseEntity.ok(difficulties);
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<Difficulties>> searchDifficulties(@RequestParam String searchTerm) {
//        List<Difficulties> difficulties = difficultiesService.searchDifficulties(searchTerm);
//        return ResponseEntity.ok(difficulties);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Difficulties> getDifficultyById(@PathVariable Long id) {
//        Optional<Difficulties> difficulty = difficultiesService.getDifficultyById(id);
//        return difficulty.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/level/{level}")
//    public ResponseEntity<Difficulties> getDifficultyByLevel(@PathVariable String level) {
//        Optional<Difficulties> difficulty = difficultiesService.getDifficultyByLevel(level);
//        return difficulty.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    /*
    @PostMapping
    public ResponseEntity<Difficulties> createDifficulty(@RequestParam String level) {
        if(difficultiesService.difficultyExists(level))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Difficulties difficulty = difficultiesService.createDifficulty(level);
        return ResponseEntity.status(HttpStatus.CREATED).body(difficulty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Difficulties> updateDifficulty(
            @PathVariable Long id,
            @RequestParam String level
    ) {
        if(difficultiesService.difficultyExists(level))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Difficulties updatedDifficulty = difficultiesService.updateDifficulty(id, level);
        return updatedDifficulty != null ?
                ResponseEntity.ok(updatedDifficulty) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDifficulty(@PathVariable Long id) {
        Optional<Difficulties> difficulty = difficultiesService.getDifficultyById(id);
        if (difficulty.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        difficultiesService.deleteDifficulty(id);
        return ResponseEntity.noContent().build();
    }
*/
}
