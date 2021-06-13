package ru.lid.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.lid.security.model.User;
import ru.lid.security.security.Role;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder encoder;
    private List<User> users;


    @PostConstruct
    public void init() {
        this.users = Arrays.asList(
                new User(1,"username1", encoder.encode("password1"),"User1", "Userovich1", "user1@mail.com", 29, Arrays.asList(Role.ADMIN)),
                new User(2,"username2", encoder.encode("password2"),"User2", "Userovich2", "user2@mail.com", 15, Arrays.asList(Role.USER)),
                new User(3,"username3", encoder.encode("password3"),"User3", "Userovich3", "user3@mail.com", 26, Arrays.asList(Role.USER)),
                new User(4,"username4", encoder.encode("password4"),"User4", "Userovich4", "user4@mail.com", 22, Arrays.asList(Role.GUEST)),
                new User(5,"username5", encoder.encode("password5"),"User5", "Userovich5", "user5@mail.com", 37, Arrays.asList(Role.GUEST))
        );
    }

    public List<User> getUsers() {
        return users;
    }

    public User getById(Long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUserById(Long id) {
        users.removeIf(user -> user.getId() == id);
    }
}
