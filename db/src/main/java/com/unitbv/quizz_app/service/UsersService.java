package com.unitbv.quizz_app.service;

import com.unitbv.quizz_app.entity.Users;

import java.util.List;
import java.util.Optional;


public interface UsersService {
    Users createUser(String name, String email, String password);

    List<Users> getAllUsers();

    Optional<Users> getUserById(int id);

    Optional<Users> getUserByName(String name);

    Users updateUser(int id, String name, String email, String password);

    void deleteUser(int id);

  //  Users loginUser(String name);
}