package com.unitbv.quizz_app.service.impl;

import com.unitbv.quizz_app.entity.Users;
import com.unitbv.quizz_app.repository.UsersRepository;
import com.unitbv.quizz_app.service.UsersService;
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
    public Users createUser(String name, String email, String password) {
        Users user = new Users();
        user.setName(name);
        user.setCreated(LocalDateTime.now());
        user.setEmail(email);
        user.setPassword(password);
        return usersRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(int id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<Users> getUserByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public Users updateUser(int id, String name, String email, String password) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            return usersRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(int id) {
        usersRepository.deleteById(id);
    }
}
