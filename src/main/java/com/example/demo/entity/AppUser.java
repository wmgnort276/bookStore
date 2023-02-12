package com.example.demo.entity;

import com.example.demo.common.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean userLocked = false;
    private Boolean userEnabled = false;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;


    public AppUser(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
