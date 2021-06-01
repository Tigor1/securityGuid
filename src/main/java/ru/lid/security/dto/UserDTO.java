package ru.lid.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.lid.security.model.User;

@Data
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public User toUser() {
        return new User(this.id, this.firstName, this.lastName, this.email, this.age);
    }
}
