package ru.lid.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.lid.security.dto.UserDTO;
import ru.lid.security.model.User;
import ru.lid.security.security.Role;
import ru.lid.security.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO.toUser());
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
