package com.unitbv.quizz_app.controller;

import com.unitbv.quizz_app.entity.Match;
import com.unitbv.quizz_app.service.MatchesService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "http://localhost:4200")
public class MatchesController {

    private final MatchesService matchesService;

    public MatchesController(MatchesService service) {
        this.matchesService = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable UUID id) {
        Optional<Match> match = matchesService.getMatchById(id);
        if (match.isPresent()) {
            return ResponseEntity.ok(match.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UUID> startMatch() {
        Match match = matchesService.createMatch();
        return ResponseEntity.ok(match.getId());
    }

    @PutMapping("{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable UUID id, @RequestBody Match updatedMatch) {
        Optional<Match> matchOptional = matchesService.getMatchById(id);
        if (matchOptional.isPresent()) {
            Match match = matchOptional.get();
            System.out.println("match " + match);
            match.setScore(updatedMatch.getScore());
            match.setCorrectAnswerCount(updatedMatch.getCorrectAnswerCount());
            match.setCompletedAt(updatedMatch.getCompletedAt());

            return ResponseEntity.ok(matchesService.updateMatch(match));
        }
        return ResponseEntity.notFound().build();
    }

}
