package com.realestate.backend.service;

public interface UserService {

    boolean login(String email, String password);

    boolean changePassword(String input);
}