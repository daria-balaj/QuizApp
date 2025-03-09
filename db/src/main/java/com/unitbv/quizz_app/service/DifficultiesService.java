package com.unitbv.quizz_app.service;

import com.unitbv.quizz_app.entity.Difficulties;
import java.util.List;
import java.util.Optional;

public interface DifficultiesService {
    Difficulties createDifficulty(String level);
    List<Difficulties> getAllDifficulties();
    List<Difficulties> getAllDifficultiesSorted();
    List<Difficulties> searchDifficulties(String searchTerm);
    Optional<Difficulties> getDifficultyById(Long id);
    Optional<Difficulties> getDifficultyByLevel(String level);
    boolean difficultyExists(String level);
    Difficulties updateDifficulty(Long id, String level);
    void deleteDifficulty(Long id);
}
