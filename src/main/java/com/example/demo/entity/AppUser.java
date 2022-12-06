package com.example.demo.entity;

import com.example.demo.common.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    private String userName;
    private String password;
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
