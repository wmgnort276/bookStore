package com.example.demo.model.request;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RegistrationRequest {
    private String userName;
//    private final String lastName;
    private String email;
    private  String password;
}
