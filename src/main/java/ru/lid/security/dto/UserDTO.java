package ru.lid.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.lid.security.model.User;
import ru.lid.security.security.Role;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private List<Role> roles;

    public User toUser() {
        return new User(this.id, this.username, this.password, this.firstName, this.lastName, this.email, this.age, this.roles);
    }
}
