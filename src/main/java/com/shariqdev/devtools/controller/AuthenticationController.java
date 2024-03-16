package com.shariqdev.devtools.controller;

import com.shariqdev.devtools.model.User;
import com.shariqdev.devtools.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    UserRepository repository;

    @PostMapping("/user")
    User newEmployee(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/user/{username}")
    User getUser(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

}
