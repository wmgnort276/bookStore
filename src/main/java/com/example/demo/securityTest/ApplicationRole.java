package com.example.demo.securityTest;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashSet;
import java.util.Set;

import static com.example.demo.securityTest.ApplicationPermission.*;

@Getter
public enum ApplicationRole {
    USER(Sets.newHashSet(BOOK_READ)),
    ADMIN(Sets.newHashSet(BOOK_READ, BOOK_MODIFY));

    private final Set<ApplicationPermission> permissions;

    ApplicationRole(Set<ApplicationPermission> permissions) {
        this.permissions = permissions;
    }
}
