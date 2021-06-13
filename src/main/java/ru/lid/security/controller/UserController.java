package ru.lid.security.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.lid.security.dto.UserDTO;
import ru.lid.security.model.User;
import ru.lid.security.repositories.UserRepository;
import ru.lid.security.service.MappingDTOService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final MappingDTOService mappingDTOService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void addUser(@RequestBody UserDTO userDTO) {
        userRepository.save(mappingDTOService.getUserFromDTO(userDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
