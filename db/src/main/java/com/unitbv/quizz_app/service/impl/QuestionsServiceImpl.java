package com.unitbv.quizz_app.service.impl;

import com.unitbv.quizz_app.entity.Categories;
import com.unitbv.quizz_app.entity.Questions;
import com.unitbv.quizz_app.repository.CategoriesRepository;
import com.unitbv.quizz_app.repository.QuestionsRepository;
import com.unitbv.quizz_app.service.QuestionsService;
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

    public QuestionsServiceImpl(
            QuestionsRepository questionsRepository,
            CategoriesRepository categoriesRepository
    ) {
        this.questionsRepository = questionsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    @Transactional
    public Questions createQuestion(String text, Long categoryId, Long difficultyId) {
        Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);

        if (categoryOpt.isEmpty())
            throw new IllegalArgumentException("Category not found");

        Questions question = new Questions();
        question.setText(text);
        question.setCategory(categoryOpt.get());
        question.setDifficultyId(difficultyId);
        return questionsRepository.save(question);
    }

    @Override
    @Cacheable(value = "questions", key = "#id")
    public Optional<Questions> getQuestionById(Long id) {
        return questionsRepository.findById(id);
    }

    @Override
    @Cacheable(value = "questions", key = "'all'")
    public List<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }

    @Override
    @Transactional
    public Questions updateQuestion(Long id, String text, Long categoryId, Long difficultyId) {
        Optional<Questions> questionOpt = questionsRepository.findById(id);
        if (questionOpt.isEmpty())
            throw new IllegalArgumentException("Question does not exist");

        Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
        if (categoryOpt.isEmpty())
            throw new IllegalArgumentException("Category not found");

        Questions question = questionOpt.get();
        question.setText(text);
        question.setCategory(categoryOpt.get());
        question.setDifficultyId(difficultyId);

        return questionsRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionsRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "questions", key = "'categories' + #categoryIds")
    public List<Questions> getQuestionsByCategories(List<Long> categoryIds) {
        List<Categories> categories = categoriesRepository.findAllById(categoryIds);
        if (categories.isEmpty()) {
            return Collections.emptyList();
        }
        return questionsRepository.findByCategoryIn(categories);
    }

    @Override
    @Cacheable(value = "questions", key = "'difficulty' + #difficultyId")
    public List<Questions> getQuestionsByDifficulty(Long difficultyId) {
        return questionsRepository.findByDifficultyId(difficultyId);
    }

    @Override
    @Cacheable(value = "questions", key = "'categories' + #categoryIds + 'difficulty' + #difficultyId")
    public List<Questions> getQuestionsByCategoriesAndDifficulty(List<Long> categoryIds, Long difficultyId) {
        List<Categories> categories = categoriesRepository.findAllById(categoryIds);
        if (categories.isEmpty()) {
            return Collections.emptyList();
        }
        return questionsRepository.findByCategoryInAndDifficultyId(categories, difficultyId);
    }

    @Override
    @Cacheable(value = "questions", key = "'category' + #categoryId")
    public long countQuestionsByCategory(Long categoryId) {
        Optional<Categories> categoryOpt = categoriesRepository.findById(categoryId);
        return categoryOpt.map(questionsRepository::countByCategory).orElse(0L);
    }

    @Override
    @Cacheable(value = "questions", key = "'difficulty' + #difficultyId")
    public long countQuestionsByDifficulty(Long difficultyId) {
        return questionsRepository.countByDifficultyId(difficultyId);
    }
}
