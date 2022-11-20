package com.example.demo.controller;

import com.example.demo.business.RegistrationBusiness;
import com.example.demo.model.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private RegistrationBusiness registrationBusiness;
    @GetMapping
    private String register(@RequestBody RegistrationRequest request){
        return registrationBusiness.register(request);
    }
}
