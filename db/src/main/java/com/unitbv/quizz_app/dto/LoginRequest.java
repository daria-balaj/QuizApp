package com.unitbv.quizz_app.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String identifier; // can be username or email
    private String password;
}

