package com.example.demo.securityTest;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ApplicationPermission {
    BOOK_READ("book:read"),
    BOOK_MODIFY("book:modify");
    private final String permission;
    ApplicationPermission(String permission){
        this.permission = permission;
    }



}
