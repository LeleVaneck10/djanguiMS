package com.lele.njangui.service;

import com.lele.njangui.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    User loginUser(String username, String password);

    User getUserById(Long userId);

    List<User> getAllUsers();

    String generateAuthToken(String username);


    // Additional methods for user-related business logic
}



