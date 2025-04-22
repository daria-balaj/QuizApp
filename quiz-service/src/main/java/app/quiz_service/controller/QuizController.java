package app.quiz_service.controller;

import app.quiz_service.dto.MatchDTO;
import app.quiz_service.dto.ResultDTO;
import app.quiz_service.entity.Match;
import app.quiz_service.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

//    private String dbServiceUrl = "http://localhost:8080/api";
    private final String dbServiceUrl = "http://db-service:8080/api";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping()
    public List<Question> getQuestionSet(
            @RequestParam(name = "categoryId", required = false) List<Long> categoryIds,
            @RequestParam(name = "difficulty", required = false, defaultValue = "1") int difficulty,
            @RequestParam(name = "questionCount", required = false, defaultValue = "10") int questionCount) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(dbServiceUrl + "/questions");

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
        ResponseEntity<Long> response = restTemplate.getForEntity(dbServiceUrl + "/answers/question/" + questionId + "/correct-answer", Long.class);
        return response.getBody();
    }
    
    @PostMapping("submit-answer/{matchId}/{questionId}")
    public Long checkAnswer(
            @PathVariable UUID matchId,
            @PathVariable Long questionId,
            @RequestParam(required = false) boolean isLastQuestion,
            @RequestBody(required = false) Long answerId
    ) {
        Long correctAnswerId = restTemplate
                .getForEntity(dbServiceUrl + "/answers/question/" + questionId + "/correct-answer", Long.class)
                .getBody();

        try {
            ResponseEntity<Match> matchResponse = restTemplate.getForEntity(dbServiceUrl + "/matches/" + matchId, Match.class);
            Match match = matchResponse.getBody();

            if (answerId != null && Objects.equals(answerId, correctAnswerId)) {
                System.out.print("match " + match);
                Integer difficulty_level = restTemplate.getForObject(dbServiceUrl + "/questions/difficulty/" + questionId, Integer.class);
                int points = difficulty_level * 25;
                match.setCorrectAnswerCount(match.getCorrectAnswerCount() + 1);
                if (isLastQuestion) match.setCompletedAt(LocalDateTime.now());
                match.setScore(match.getScore() + points);
                System.out.println("Updating match with score: " + match.getScore() + ", correctAnswers: " + match.getCorrectAnswerCount());
                restTemplate.put(dbServiceUrl + "/matches/" + match.getId(), match, Match.class);
            }

        } catch (HttpClientErrorException.NotFound | NullPointerException e) {
            e.printStackTrace();
            return correctAnswerId;
        }

        return correctAnswerId;
    }



    @PostMapping("start")
    public ResponseEntity<MatchDTO> startQuiz(@RequestParam(name = "categoryId", required = false) List<Long> categoryIds,
                              @RequestParam(name = "difficulty", required = false, defaultValue = "1") int difficulty,
                              @RequestParam(name = "questionCount", required = false, defaultValue = "10") int questionCount) {

        try {
            UUID matchId = restTemplate.postForObject(dbServiceUrl + "/matches", null, UUID.class);

            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(dbServiceUrl + "/questions");

            if (categoryIds != null && !categoryIds.isEmpty()) {
                for (Long categoryId : categoryIds) {
                    builder.queryParam("categoryId", categoryId);
                }
            }

            builder.queryParam("difficulty", difficulty);

            builder.queryParam("count", questionCount);

            String url = builder.toUriString();

            ResponseEntity<Question[]> response = restTemplate.getForEntity(url, Question[].class);

            if (response.getBody() == null || response.getBody().length == 0) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            if (matchId != null && response.getBody().length > 0) {
                return ResponseEntity.ok(new MatchDTO(matchId, new ArrayList<>(Arrays.asList(response.getBody()))));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("results/{id}")
    public ResponseEntity<ResultDTO> getQuizResults(@PathVariable UUID id) {
        ResultDTO results = new ResultDTO();
        try {
            Match match = restTemplate.getForEntity(dbServiceUrl + "/matches/" + id, Match.class).getBody();
            System.out.println(match);
            assert match != null;
            results.setCorrectAnswers(match.getCorrectAnswerCount());
            results.setScore(match.getScore());

            Duration duration = Duration.between(match.getStartedAt(), match.getCompletedAt());
            long minutes = duration.toMinutes();
            long seconds = duration.minusMinutes(minutes).getSeconds();
            String formattedTime = String.format("%02d:%02d", minutes, seconds);

            results.setTime(formattedTime);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(results);
    }


}
