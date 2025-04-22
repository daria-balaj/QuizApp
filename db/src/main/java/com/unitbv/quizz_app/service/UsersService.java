package com.unitbv.quizz_app.service;

import com.unitbv.quizz_app.entity.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    
    User createUser(String username, String email, String password);

    List<User> getAllUsers();


    Optional<User> getUserById(Long id);

    Optional<User> getByUsernameOrEmail(String identifier);

    Optional<User> getUserByUsername(String username);

    User updateUser(Long id, String username, String email, String password);

    void deleteUser(Long id);

    // Users loginUser(String name);  
}