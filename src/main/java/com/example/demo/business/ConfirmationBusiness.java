package com.example.demo.business;

import com.example.demo.entity.ConfirmationToken;
import com.example.demo.repository.ConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ConfirmationBusiness extends BaseBusiness{
    @Autowired
    private ConfirmationRepository confirmationRepository;
    public void saveConfirmationToken(ConfirmationToken confirmationToken){
        confirmationRepository.save(confirmationToken);
    }

    public Optional<ConfirmationToken> getToken(String token){
        return confirmationRepository.findByToken(token);
    }
    public int updateConfirmAt(String token){
        return confirmationRepository.updateConfirmAt(token, LocalDateTime.now());
    }

}
