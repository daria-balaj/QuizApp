package com.unitbv.quizz_app.repository;

import com.unitbv.quizz_app.entity.Difficulties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DifficultiesRepository extends JpaRepository<Difficulties, Long> {
    Optional<Difficulties> findByLevelIgnoreCase(String level);
    Boolean existsByLevelIgnoreCase(String level);
    List<Difficulties> findByLevelContainingIgnoreCase(String searchTerm);
    List<Difficulties> findAllByOrderByLevelAsc();
}
