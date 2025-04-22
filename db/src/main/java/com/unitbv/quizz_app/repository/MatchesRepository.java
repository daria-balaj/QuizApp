package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MatchesRepository extends JpaRepository<Match, UUID> {

}
