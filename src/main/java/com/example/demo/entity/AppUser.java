package com.example.demo.entity;

import com.example.demo.common.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser extends BaseEntity implements UserDetails {

    private String userName;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole appUserRole;
    private Boolean userLocked = false;
    private Boolean userEnabled = false;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    public AppUser(String userName, String email, String password, UserRole userRole) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.appUserRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.userLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.userEnabled;
    }
}
