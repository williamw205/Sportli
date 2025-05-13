package com.sportli.backend.controller;

import com.sportli.backend.service.UserService;
import com.sportli.backend.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users") // Defines base url for this controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User savingUser(@RequestBody User user) { // Request body helps to take JSON and convert it into a User
                                                     // object
        return userService.createOrUpdateUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) { // PathVariable is used to extract varaibles from the URL path of the
                                                 // request
        return userService.getUserById(id);
    }

}
