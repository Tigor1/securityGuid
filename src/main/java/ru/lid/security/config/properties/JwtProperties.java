//package ru.lid.security.config.properties;
//
//import lombok.Data;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.convert.DurationUnit;
//import org.springframework.validation.annotation.Validated;
//import java.time.Duration;
//import java.time.temporal.ChronoUnit;
//
//@Data
//@ConfigurationProperties(prefix = "jwt", ignoreInvalidFields = true)
//@Validated
//public class JwtProperties {
//    @NotNull
//    private String issuer;
//
//    @DurationUnit(ChronoUnit.MINUTES)
//    private Duration expireJWT;
//
//    @DurationUnit(ChronoUnit.MINUTES)
//    private Duration expireRT;
//
////    private String privateKey;
////
////    private String publicKey;
//}
