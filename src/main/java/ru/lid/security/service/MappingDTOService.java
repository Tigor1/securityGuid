package ru.lid.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.lid.security.dto.UserDTO;
import ru.lid.security.model.User;

@Component
@RequiredArgsConstructor
public class MappingDTOService {
    private final PasswordEncoder passwordEncoder;

    public User getUserFromDTO(UserDTO userDTO) {
        return new User(
                userDTO.getUsername(),
                passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getAge(),
                userDTO.getRoles()
        );
    }
}
