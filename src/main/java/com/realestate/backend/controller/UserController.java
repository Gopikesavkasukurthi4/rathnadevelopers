package com.realestate.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.realestate.backend.dto.*;
import com.realestate.backend.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginDTO dto) {

        boolean success = service.login(dto.getEmail(), dto.getPassword());

        Map<String, Object> response = new HashMap<>();

        if (success) {
            response.put("token", "admin-token");
            response.put("name", "Admin");
            response.put("email", dto.getEmail());
        } else {
            response.put("error", "Invalid credentials");
        }

        return response;
    }

    @PutMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordDTO dto) {
        return service.changePassword(dto.getInput()) ? "UPDATED" : "INVALID";
    }
}