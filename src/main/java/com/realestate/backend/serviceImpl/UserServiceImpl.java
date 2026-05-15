package com.realestate.backend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.backend.entity.User;
import com.realestate.backend.repository.UserRepository;
import com.realestate.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    private static final String PREFIX = "ADMIN123_";

    @Override
    public boolean login(String email, String password) {

        User user = repo.findByEmail(email);

        return user != null && user.getPassword().equals(password);
    }

    @Override
    public boolean changePassword(String input) {

        if (!input.startsWith(PREFIX)) return false;

        String newPassword = input.substring(PREFIX.length());

        User user = repo.findAll().stream().findFirst().orElse(null);

        if (user != null) {
            user.setPassword(newPassword);
            repo.save(user);
            return true;
        }

        return false;
    }
}