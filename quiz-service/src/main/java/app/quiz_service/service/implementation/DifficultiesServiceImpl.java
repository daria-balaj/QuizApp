package app.quiz_service.service.implementation;

import app.quiz_service.service.DifficultiesService;
import app.quiz_service.entity.Difficulties;
import app.quiz_service.repository.DifficultiesRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DifficultiesServiceImpl implements DifficultiesService {

    private final DifficultiesRepository difficultiesRepository;

    public DifficultiesServiceImpl(DifficultiesRepository difficultiesRepository) {
        this.difficultiesRepository = difficultiesRepository;
    }

    @Override
    @Transactional
    public Difficulties createDifficulty(String level) {
        Difficulties difficulty = new Difficulties();
        difficulty.setLevel(level);
        return difficultiesRepository.save(difficulty);
    }

    @Override
    @Cacheable(value = "difficulties", key = "'all'")
    public List<Difficulties> getAllDifficulties() {
        return difficultiesRepository.findAll();
    }

    @Override
    @Cacheable(value = "difficulties", key = "'sorted'")
    public List<Difficulties> getAllDifficultiesSorted() {
        return difficultiesRepository.findAllByOrderByLevelAsc();
    }

    @Override
    @Cacheable(value = "difficulties", key = "#searchTerm")
    public List<Difficulties> searchDifficulties(String searchTerm) {
        return difficultiesRepository.findByLevelContainingIgnoreCase(searchTerm);
    }

    @Override
    @Cacheable(value="difficulties", key="#id")
    public Optional<Difficulties> getDifficultyById(Long id) {
        return difficultiesRepository.findById(id);
    }

    @Override
    @Cacheable(value="difficulties", key="#level")
    public Optional<Difficulties> getDifficultyByLevel(String level) {
        return difficultiesRepository.findByLevelIgnoreCase(level);
    }

    @Override
    @Cacheable(value="difficulties", key="#level")
    public boolean difficultyExists(String level) {
        return difficultiesRepository.existsByLevelIgnoreCase(level);
    }

    @Override
    @Transactional
    public Difficulties updateDifficulty(Long id, String level) {
        Optional<Difficulties> optionalDifficulty = difficultiesRepository.findById(id);
        if (optionalDifficulty.isPresent()) {
            Difficulties difficulty = optionalDifficulty.get();
            difficulty.setLevel(level);
            return difficultiesRepository.save(difficulty);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteDifficulty(Long id) {
        difficultiesRepository.deleteById(id);
    }

}
