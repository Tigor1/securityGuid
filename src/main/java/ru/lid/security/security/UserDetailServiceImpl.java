package ru.lid.security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.lid.security.dto.UserDTO;
import ru.lid.security.model.User;
import ru.lid.security.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.getUserByUsername(s).orElseThrow(
                ()->new UsernameNotFoundException("User with username" + s +  " doesn't found!")
        );
        System.out.println("user: " + user);
        return user;
    }
}
