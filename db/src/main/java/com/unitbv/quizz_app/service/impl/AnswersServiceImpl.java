package com.unitbv.quizz_app.service.impl;

import com.unitbv.quizz_app.entity.Answer;
import com.unitbv.quizz_app.repository.AnswersRepository;
import com.unitbv.quizz_app.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;

@Service
public class AnswersServiceImpl implements AnswersService {

    private final AnswersRepository answersRepository;

    @Autowired
    public AnswersServiceImpl(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    @Override
    @Cacheable(value = "answers", key = "'all'")
    public List<Answer> getAllAnswers() {
        return answersRepository.findAll();
    }

    @Override
    @Cacheable(value = "answers", key = "#id")
    public Optional<Answer> getAnswersById(Long id) {
        return answersRepository.findById(id);
    }

    @Override
    @Cacheable(value = "answers", key = "#questionId")
    public List<Answer> getAnswersByQuestionId(Long questionId) {
        return answersRepository.findByQuestionId(questionId);
    }

    @Override
    public Long getCorrectAnswerId(Long questionId) {
        Answer answer = answersRepository.findByQuestionIdAndIsCorrectTrue(questionId);
        return answer.getId();
    }

    @Override
    public Answer saveAnswer(Answer answer) {
        return answersRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        return answersRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Long id) {
        answersRepository.deleteById(id);
    }
}
