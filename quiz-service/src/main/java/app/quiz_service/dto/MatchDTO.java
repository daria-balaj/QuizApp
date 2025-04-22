package app.quiz_service.dto;

import app.quiz_service.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    private UUID id;
    private List<Question> questions;
}
