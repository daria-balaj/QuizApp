package com.unitbv.quizz_app.dto;

import com.unitbv.quizz_app.entity.User;
import lombok.Data;

import java.util.Optional;

@Data
public class LoginResponse {
    private boolean success;
    private String message;
    private User user;

    public LoginResponse(boolean success, String message, Optional<User> user) {
        this.success = success;
        this.message = message;
        user.ifPresent(value -> this.user = value);
    }
}
