package ru.lid.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.lid.security.dto.UserDTO;
import ru.lid.security.security.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(schema = "principal", name = "account")
public class User implements UserDetails {
    @Id
//    @SequenceGenerator(schema = "principal", name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String username;
    private String password;
    private String email;
    private Date created;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "is_non_expired")
    private boolean isAccountNonExpired;

    @Column(name = "is_non_lock")
    private boolean isAccountNonLock;

    @Column(name = "is_credentials_expired")
    private boolean isCredentialsNonExpired;

    @Column(name = "is_enable")
    private boolean isEnable;
    private int age;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.ORDINAL)
    @CollectionTable(schema = "principal", name = "role", joinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User(String username, String password, String email, int age, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.isAccountNonExpired = true;
        this.isAccountNonLock = true;
        this.isCredentialsNonExpired = true;
        this.isEnable = true;
        this.created = new Date();
        this.lastLoginTime = new Date();
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
