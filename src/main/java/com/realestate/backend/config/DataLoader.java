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

            User existing = repo.findByEmail("admin@gmail.com");

            if (existing == null) {

                User user = new User();
                user.setEmail("admin@gmail.com");
                user.setPassword("1234");

                repo.save(user);

                System.out.println("ADMIN CREATED");
            } else {

                existing.setPassword("1234");
                repo.save(existing);

                System.out.println("PASSWORD RESET");
            }
        };
    }
}