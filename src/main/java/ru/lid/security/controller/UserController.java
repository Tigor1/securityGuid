package ru.lid.security.controller;

import org.springframework.web.bind.annotation.*;
import ru.lid.security.dto.UserDTO;
import ru.lid.security.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1,"User1", "Userovich1", "user1@mail.com", 29),
            new User(2,"User2", "Userovich2", "user2@mail.com", 15),
            new User(3,"User3", "Userovich3", "user3@mail.com", 26),
            new User(4,"User4", "Userovich4", "user4@mail.com", 22),
            new User(5,"User5", "Userovich5", "user5@mail.com", 37)
    ));


    @GetMapping("/user")
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        users.add(userDTO.toUser());
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        users.removeIf(user->user.getId() == id);
    }
}
