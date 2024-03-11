package com.app.model;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class User {
    private final String password;
    private final String role;

    public boolean isAdmin() {
        return role.equalsIgnoreCase("administrator");
    }
}
