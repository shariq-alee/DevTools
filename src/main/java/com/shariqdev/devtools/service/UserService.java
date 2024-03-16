package com.shariqdev.devtools.service;

import com.shariqdev.devtools.model.User;
import com.shariqdev.devtools.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
