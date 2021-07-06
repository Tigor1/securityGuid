package ru.lid.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.lid.security.security.jwt.JwtProvider;

@SpringBootTest
class SecurityApplicationTests {
    @Autowired
    public JwtProvider jwtProvider;

    @Test
    void contextLoads() {
    }

    @Test
    public void testJwt() {
        System.out.println(jwtProvider.generateAccessToken());
    }
}
