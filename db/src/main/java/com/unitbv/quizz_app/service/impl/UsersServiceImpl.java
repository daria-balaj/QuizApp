package com.unitbv.quizz_app.service.impl;

import com.unitbv.quizz_app.entity.Users;
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
    public Users createUser(String username, String email, String password) {
        Users user = new Users();
        user.setUsername(username);  
        user.setCreatedAt(LocalDateTime.now());  
        user.setEmail(email);
        user.setHashedPassword(password);  
        return usersRepository.save(user);
    }

    @Override
    @Cacheable(value="users", key="'all'")
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    @Override
    @Cacheable(value="users", key="#id")
    public Optional<Users> getUserById(Long id) {  
        return usersRepository.findById(id);
    }

    @Override
    @Cacheable(value="users", key="#username")
    public Optional<Users> getUserByUsername(String username) {  
        return usersRepository.findByUsername(username);  
    }

    @Override
    public Users updateUser(Long id, String username, String email, String password) {  
        Optional<Users> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
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