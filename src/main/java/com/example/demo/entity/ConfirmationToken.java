package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="confirmation_token")
public class ConfirmationToken extends BaseEntity{
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createTime;
    @Column(nullable = false)
    private LocalDateTime expiresTime;
    private LocalDateTime confirmAt;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )

    private AppUser appUser;

    public ConfirmationToken(String token, LocalDateTime createTime, LocalDateTime expiresTime, AppUser appUser) {
        this.token = token;
        this.createTime = createTime;
        this.expiresTime = expiresTime;
        this.appUser = appUser;
    }


}
