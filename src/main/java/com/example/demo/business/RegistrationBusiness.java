package com.example.demo.business;

import com.example.demo.model.request.RegistrationRequest;
import org.springframework.stereotype.Component;

@Component
public class RegistrationBusiness {

    public String register(RegistrationRequest request) {
        return "Work";
    }
}
