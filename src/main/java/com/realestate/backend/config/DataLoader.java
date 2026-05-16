package com.realestate.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.realestate.backend.entity.User;
import com.realestate.backend.repository.UserRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository repo) {
        return args -> {

            User user = repo.findByEmail("admin@gmail.com");

            if(user != null){
                user.setPassword("1234");
                repo.save(user);
            }
        };
    }
}