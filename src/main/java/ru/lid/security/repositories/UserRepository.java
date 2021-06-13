package ru.lid.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.lid.security.model.User;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> getUserByUsername(String username);
}
