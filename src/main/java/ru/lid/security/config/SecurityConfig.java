package ru.lid.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.lid.security.security.CustomAuthenticationProvider;
import ru.lid.security.security.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
//        securedEnabled = true,
//        jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated()
//                .and().httpBasic();
        http.httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/api/v1/users").permitAll()
                .anyRequest()
                //authorize any request
                .authenticated();
        //access any endpoints without credentials
//                .permitAll();
    }


    //кофигурировать UserDetailService и PasswordEncoder можно через бины или через переопределенный метод
    //void configure(AuthenticationManagerBuilder auth)
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService());
////                .passwordEncoder(passwordEncoder());
//        auth.authenticationProvider(authenticationProvider);
//    }
}
