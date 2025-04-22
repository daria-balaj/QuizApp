package com.unitbv.quizz_app.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private boolean success;
    private String message;
    private UserDTO user;
}
