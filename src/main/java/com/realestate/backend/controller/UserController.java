package com.realestate.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.realestate.backend.dto.*;
import com.realestate.backend.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        return service.login(dto.getEmail(), dto.getPassword()) ? "SUCCESS" : "FAIL";
    }

    @PutMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordDTO dto) {
        return service.changePassword(dto.getInput()) ? "UPDATED" : "INVALID";
    }
}