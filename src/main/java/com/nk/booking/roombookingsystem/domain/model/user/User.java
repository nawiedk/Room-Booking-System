package com.nk.booking.roombookingsystem.domain.model.user;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final EmailAddress email;
    private final Role role;

    public User(UUID id, String name, EmailAddress email, Role role) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
        this.role = Objects.requireNonNull(role);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }
}
