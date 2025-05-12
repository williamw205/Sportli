package com.sportli.backend.service;

import java.util.Optional;
import com.sportli.backend.repository.UserRepository;
import com.sportli.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createOrUpdateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());

        if (existingUser.isPresent()) {

        }

    }

}
