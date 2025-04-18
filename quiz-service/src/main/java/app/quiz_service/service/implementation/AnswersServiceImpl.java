package app.quiz_service.service.implementation;

import app.quiz_service.service.AnswersService;
import app.quiz_service.entity.Answers;
//import app.quiz_service.repository.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswersServiceImpl implements AnswersService {

//    private final AnswersRepository answersRepository;

//    @Autowired
//    public AnswersServiceImpl(AnswersRepository answersRepository) {
//        this.answersRepository = answersRepository;
//    }
//
//    @Override
//    @Cacheable(value = "answers", key = "'all'")
//    public List<Answers> getAllAnswers() {
//        return answersRepository.findAll();
//    }
//
//    @Override
//    @Cacheable(value = "answers", key = "#id")
//    public Optional<Answers> getAnswersById(Long id) {
//        return answersRepository.findById(id);
//    }
//
//    @Override
//    @Cacheable(value = "answers", key = "#questionId")
//    public List<Answers> getAnswersByQuestionId(Long questionId) {
//        return answersRepository.findByQuestionId(questionId);
//    }
//
//    @Override
//    @Cacheable(value = "answers", key = "'all'")
//    public List<Answers> getCorrectAnswers() {
//        return answersRepository.findByIsCorrect(true);
//    }
//
//    @Override
//    @Cacheable(value = "answers", key = "'all'")
//    public List<Answers> getIncorrectAnswers() {
//        return answersRepository.findByIsCorrect(false);
//    }
//
//    @Override
//    public Answers saveAnswer(Answers answer) {
//        return answersRepository.save(answer);
//    }
//
//    @Override
//    public Answers updateAnswer(Answers answer) {
//        return answersRepository.save(answer);
//    }
//
//    @Override
//    public void deleteAnswer(Long id) {
//        answersRepository.deleteById(id);
//    }

}
