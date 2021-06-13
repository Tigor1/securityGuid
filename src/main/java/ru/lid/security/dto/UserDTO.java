package ru.lid.security.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.lid.security.model.User;
import ru.lid.security.security.Role;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private List<Role> roles;
}
