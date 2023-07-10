package com.lele.njangui.service;

import com.lele.njangui.configuration.JwtUtil;
import com.lele.njangui.model.User;
import com.lele.njangui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    @Override
    public User registerUser(User user) {
        // Validate user data
        // Perform any necessary transformations or checks

        // Hash the user's password
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // Save the user to the repository
        return userRepository.save(user);
    }


    @Override
    public User loginUser(String username, String password) {
        // Find the user by username in the repository
        User user = userRepository.findByUsername(username);

        // Check if the user exists and the provided password matches the stored hashed password
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user; // Authentication successful
        } else {
            return null; // Authentication failed
        }
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String generateAuthToken(String username) {
        return jwtUtil.generateToken(username);
    }

    // Implement additional methods for user-related business logic
}

