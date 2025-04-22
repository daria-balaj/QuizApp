package com.unitbv.quizz_app.service.impl;

import com.unitbv.quizz_app.entity.Match;
import com.unitbv.quizz_app.repository.MatchesRepository;
import com.unitbv.quizz_app.service.MatchesService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class MatchesServiceImpl implements MatchesService {

    private final MatchesRepository matchesRepository;

    public MatchesServiceImpl(MatchesRepository matchesRepository) {
        this.matchesRepository = matchesRepository;
    }

    @Override
    public Optional<Match> getMatchById(UUID id) {
        return matchesRepository.findById(id);
    }

    @Override
    public Match createMatch() {
        Match match = new Match();
        match.setScore(0);
        match.setCorrectAnswerCount(0);
        match.setStartedAt(LocalDateTime.now());
        match.setCompletedAt(null);
        return matchesRepository.save(match);
    }

    @Override
    public Match updateMatch(Match match) {
        return matchesRepository.save(match);
    }
}
