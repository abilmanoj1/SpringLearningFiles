package com.dexlock.MySQLDemo.controller;

import com.dexlock.MySQLDemo.entity.User;
import com.dexlock.MySQLDemo.exception.ResourceNotFoundException;
import com.dexlock.MySQLDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable (value = "id") long userId){
        return this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User data not found"));
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user){
        return this.userRepository.save(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable(value = "id") long userId){
        User existing = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
        if (user.getFirstName()!= null) {
            existing.setFirstName(user.getFirstName());
        } else {
            existing.setFirstName(existing.getFirstName());
        }

        if (user.getLastName()!=null) {
            existing.setLastName(user.getLastName());
        } else {
            existing.setLastName(existing.getLastName());
        }

        if (user.getEmail()!=null) {
            existing.setEmail(user.getEmail());
        } else {
           existing.setEmail(existing.getEmail());
        }

        return this.userRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long userId){
        User existing = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found"));
        this.userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
    }
}
