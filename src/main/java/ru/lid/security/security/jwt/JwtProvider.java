package ru.lid.security.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.lid.security.model.User;
import ru.lid.security.security.Role;

import java.time.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtProvider {
    @Value("${jwt.expireJWT}")
    private Duration accessDuration;
    @Value("${jwt.secret}")
    private String secret;


    public String generateAccessToken() {

        var nowMillis = System.currentTimeMillis();
        var nowDate = new Date(nowMillis);



        Map<String, String> claims = new HashMap<>();
        claims.put("roles", "ADMIN");

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("lid")
                .setIssuedAt(nowDate)
                .setExpiration(getExpiration(accessDuration))
                .setSubject("username")
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private Date getExpiration(Duration duration) {
        var expiration = LocalDateTime.now(ZoneOffset.UTC);
        expiration = expiration.plus(duration);
        return new Date(expiration.atZone(ZoneOffset.UTC).toInstant().toEpochMilli());
    }
}
