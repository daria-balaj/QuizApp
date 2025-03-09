package com.unitbv.quizz_app.service;

import com.unitbv.quizz_app.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    
    Users createUser(String username, String email, String password);

    List<Users> getAllUsers();


    Optional<Users> getUserById(Long id);

    Optional<Users> getUserByUsername(String username);

    Users updateUser(Long id, String username, String email, String password);

    void deleteUser(Long id);

    // Users loginUser(String name);  
}