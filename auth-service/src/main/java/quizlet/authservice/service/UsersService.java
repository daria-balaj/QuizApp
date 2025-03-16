package quizlet.authservice.service.impl;

import quizlet.authservice.entity.User;
import quizlet.authservice.repository.UsersRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User createUser(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setCreatedAt(LocalDateTime.now());
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