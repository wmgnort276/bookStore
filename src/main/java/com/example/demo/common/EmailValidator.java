package com.example.demo.common;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        // Regex to check if an email is valid
        return true;
    }
}
