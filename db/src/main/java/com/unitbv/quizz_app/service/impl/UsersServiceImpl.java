package com.unitbv.quizz_app.service.impl;

import com.unitbv.quizz_app.entity.User;
import com.unitbv.quizz_app.exceptions.UserAlreadyExistsException;
import com.unitbv.quizz_app.repository.UsersRepository;
import com.unitbv.quizz_app.service.UsersService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User createUser(String username, String email, String password) {
        if (usersRepository.existsByUsername(username)) {
            throw new UserAlreadyExistsException("Username is taken");
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setHashedPassword(password);  
        return usersRepository.save(user);
    }

    @Override
    @Cacheable(value="users", key="'all'")
    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }

    @Override
    @Cacheable(value="users", key="#id")
    public Optional<User> getUserById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    @Cacheable(value="users", key="#username")
    public Optional<User> getUserByUsername(String username) {
        return usersRepository.findByUsername(username);  
    }

    @Override
    public Optional<User> getByUsernameOrEmail(String identifier) {
        Optional<User> user = usersRepository.findByUsername(identifier);
        if (user.isEmpty()) {
            user = usersRepository.findByEmail(identifier);
        }
        return user;
    }

    @Override
    public User updateUser(Long id, String username, String email, String password) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(username);  
            user.setEmail(email);
            user.setHashedPassword(password);  
            return usersRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) { 
        usersRepository.deleteById(id);
    }
}