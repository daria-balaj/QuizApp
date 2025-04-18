package app.quiz_service.controller;

import app.quiz_service.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    private String dbServiceUrl = "http://localhost:8080/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping()
    public List<Question> getQuestionSet(
            @RequestParam(name = "categoryId", required = false) List<Long> categoryIds,
            @RequestParam(name = "difficulty", required = false, defaultValue = "1") int difficulty,
            @RequestParam(name = "questionCount", required = false, defaultValue = "10") int questionCount) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(dbServiceUrl + "api/questions");

        if (categoryIds != null && !categoryIds.isEmpty()) {
            for (Long categoryId : categoryIds) {
                builder.queryParam("categoryId", categoryId);
            }
        }

        builder.queryParam("difficulty", difficulty);

        String url = builder.toUriString();

        ResponseEntity<Question[]> response = restTemplate.getForEntity(url, Question[].class);

        if (response.getBody() == null || response.getBody().length == 0) {
            return Collections.emptyList();
        }

        List<Question> allQuestions = new ArrayList<>(Arrays.asList(response.getBody()));

        Collections.shuffle(allQuestions);

        return allQuestions.stream()
                .limit(questionCount)
                .collect(Collectors.toList());
    }

    @GetMapping("correct-answer/{questionId}")
    public Long getCorrectAnswer(@PathVariable Long questionId) {
        ResponseEntity<Long> response = restTemplate.getForEntity(dbServiceUrl + "api/answers/question/" + questionId + "/correct-answer", Long.class);
        return response.getBody();
    }

    @GetMapping("check-answer/{questionId}/{answerId}")
    public Long checkAnswer(@PathVariable Long questionId, @PathVariable Long answerId) {
        ResponseEntity<Long> response = restTemplate.getForEntity(dbServiceUrl + "api/answers/question/" + questionId + "/correct-answer", Long.class);
        //TODO: add user answer to stats
        return response.getBody();
    }


}
