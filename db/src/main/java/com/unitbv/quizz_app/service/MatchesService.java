package com.unitbv.quizz_app.service;

import com.unitbv.quizz_app.entity.Match;

import java.util.Optional;
import java.util.UUID;

public interface MatchesService {

    public Optional<Match> getMatchById(UUID id);
    public Match createMatch();
    public Match updateMatch(Match match);
}
