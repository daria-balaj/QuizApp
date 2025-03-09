package com.unitbv.quizz_app.service.impl;

import com.unitbv.quizz_app.entity.Categories;
import com.unitbv.quizz_app.entity.Difficulties;
import com.unitbv.quizz_app.entity.Questions;
import com.unitbv.quizz_app.repository.CategoriesRepository;
import com.unitbv.quizz_app.repository.DifficultiesRepository;
import com.unitbv.quizz_app.repository.QuestionsRepository;
import com.unitbv.quizz_app.service.QuestionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsRepository questionsRepository;
    private final CategoriesRepository categoriesRepository;
    private final DifficultiesRepository difficultiesRepository;

    public QuestionsServiceImpl (
            QuestionsRepository questionsRepository,
            CategoriesRepository categoriesRepository,
            DifficultiesRepository difficultiesRepository
    ) {
        this.questionsRepository = questionsRepository;
        this.categoriesRepository = categoriesRepository;
        this.difficultiesRepository = difficultiesRepository;
    }

    @Override
    @Transactional
    public Questions createQuestion(String text, Long categoryId, Long difficultyId) {
        Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
        Optional<Difficulties> difficultyOpt = difficultiesRepository.findById(difficultyId);

        if(categoryOpt.isEmpty() || difficultyOpt.isEmpty())
            throw new IllegalArgumentException("Category or Difficulties are empty");

        Questions question = new Questions();
        question.setText(text);
        question.setCategory(categoryOpt.get());
        question.setDifficulty(difficultyOpt.get());
        return questionsRepository.save(question);
    }

    @Override
    @Cacheable(value="questions", key="#id")
    public Optional<Questions> getQuestionById(Long id) {
        return questionsRepository.findById(id);
    }

    @Override
    @Cacheable(value="questions", key="'all'")
    public List<Questions> getAllQuestions(){
        return questionsRepository.findAll();
    }

    @Override
    @Cacheable(value="questions", key="'page' + #pageable.pageNumber")
    public Page<Questions> getQuestionsPage(Pageable pageable) {
        return questionsRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Questions updateQuestion(Long id, String text, Long categoryId, Long difficultyId) {
        Optional<Questions> questionOpt = questionsRepository.findById(id);
        if(questionOpt.isEmpty())
            throw new IllegalArgumentException("Question does not exist");

        Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
        Optional<Difficulties> difficultyOpt = difficultiesRepository.findById(difficultyId);
        if(categoryOpt.isEmpty() || difficultyOpt.isEmpty())
            throw new IllegalArgumentException("Category or Difficulties not found");

        Questions question = questionOpt.get();
        question.setText(text);
        question.setCategory(categoryOpt.get());
        question.setDifficulty(difficultyOpt.get());

        return questionsRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionsRepository.deleteById(id);
    }

    @Override
    @Cacheable(value="questions", key="'category' + #categoryId")
    public List<Questions> getQuestionsByCategory(Long categoryId) {
        Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
        return categoryOpt.map(questionsRepository::findByCategory).orElse(Collections.emptyList());
    }

    @Override
    @Cacheable(value="questions", key="'difficulty' + #difficultyId")
    public List<Questions> getQuestionsByDifficulty(Long difficultyId) {
        Optional<Difficulties> difficultyOpt = difficultiesRepository.findById(difficultyId);
        return difficultyOpt.map(questionsRepository::findByDifficulty).orElse(Collections.emptyList());
    }

    @Override
    @Cacheable(value="questions", key="'category' + #categoryId + 'difficulty' + #difficultyId")
    public List<Questions> getQuestionsByCategoryAndDifficulty(Long categoryId, Long difficultyId) {
        Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
        Optional<Difficulties> difficultyOpt = difficultiesRepository.findById(difficultyId);
        if(categoryOpt.isEmpty() || difficultyOpt.isEmpty())
            return Collections.emptyList();
        return questionsRepository.findByCategoryAndDifficulty(categoryOpt.get(), difficultyOpt.get());
    }

    @Override
    @Cacheable(value="questions", key="'search' + #searchTerm")
    public List<Questions> searchQuestions(String searchTerm) {
        return questionsRepository.findByTextContainingIgnoreCase(searchTerm);
    }

    @Override
    @Cacheable(value="questions", key="'category' + #categoryId")
    public long countQuestionsByCategory(Long categoryId){
        Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
        return categoryOpt.map(questionsRepository::countByCategory).orElse(0L);
    }

    @Override
    @Cacheable(value="questions", key="'difficulty' + #difficultyId")
    public long countQuestionsByDifficulty(Long difficultyId){
        Optional<Difficulties> difficultyOpt = difficultiesRepository.findById(difficultyId);
        return difficultyOpt.map(questionsRepository::countByDifficulty).orElse(0L);
    }

    @Override
    @Cacheable(value="questions", key="'category' + #categoryId + 'difficulty' + #difficultyId")
    public List<Questions> getRandomQuestions(Long categoryId, Long difficultyId, int count) {
        Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
        Optional<Difficulties> difficultyOpt = difficultiesRepository.findById(difficultyId);

        if(categoryOpt.isPresent() || difficultyOpt.isPresent())
            return questionsRepository.findRandomQuestions(categoryOpt.get(), difficultyOpt.get(), count);
        return Collections.emptyList();
    }
}
