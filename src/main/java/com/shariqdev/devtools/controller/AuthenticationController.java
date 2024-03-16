package com.shariqdev.devtools.controller;

import com.shariqdev.devtools.model.User;
import com.shariqdev.devtools.repository.UserRepository;
import com.shariqdev.devtools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    UserRepository repository;

    @PostMapping("/user")
    User newEmployee(@RequestBody User user) {
        return repository.save(user);
    }

}
