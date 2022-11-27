package com.example.demo.controller;

import com.example.demo.business.RegistrationBusiness;
import com.example.demo.model.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    @Autowired
    private RegistrationBusiness registrationBusiness;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationBusiness.register(request);
    }
    @GetMapping(value = "/confirm")
    public String confirmToken(@RequestParam("token") String token){
        return registrationBusiness.confirmToken(token);
    }

}
