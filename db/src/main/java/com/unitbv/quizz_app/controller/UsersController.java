package com.unitbv.quizz_app.controller;

import com.unitbv.quizz_app.entity.Users;
import com.unitbv.quizz_app.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/by-name")
    public ResponseEntity<Users> getUserByUsername(@RequestParam String username) {
        Optional<Users> user = usersService.getUserByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
/*
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        Users user = usersService.createUser(username, email, password);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestParam String username, @RequestParam String email, @RequestParam String password) {
        Users updatedUser = usersService.updateUser(id, username, email, password);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

 */
}