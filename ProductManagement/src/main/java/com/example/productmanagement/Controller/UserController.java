package com.example.productmanagement.Controller;

import com.example.productmanagement.Entities.User;
import com.example.productmanagement.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    // Injection de dépendance pour UserRepository
    @Autowired
    private UserRepository userRepository;

    // Affiche le formulaire d'inscription
    @GetMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userRepository.save(user);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Traitement de l'inscription
    @PostMapping("/process_register")
    public ResponseEntity<String> processRegister(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return ResponseEntity.ok("register_success");
    }

    // Affiche la liste des utilisateurs
    @GetMapping("/list")
    public ResponseEntity<List<User>> listUsers() {
        List<User> listUsers = userRepository.findAll();
        return ResponseEntity.ok(listUsers);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
