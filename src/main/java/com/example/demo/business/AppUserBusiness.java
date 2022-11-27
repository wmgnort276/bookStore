package com.example.demo.business;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.ConfirmationToken;
import com.example.demo.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AppUserBusiness implements UserDetailsService {
    private static final String USER_NOT_FOUND = "User with %s not found!";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private final AppUserRepository appUserRepository;
    @Autowired
    private ConfirmationBusiness confirmationBusiness;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email))
        );
    }

    public String signUpUser(AppUser appUser) {
        boolean userExist = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("Email already taken");
        }
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));

        appUserRepository.save(appUser);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), appUser
        );
        confirmationBusiness.saveConfirmationToken(confirmationToken);
        return token;
    }

    public int enableUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
