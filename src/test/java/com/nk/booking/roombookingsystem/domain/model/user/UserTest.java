package com.nk.booking.roombookingsystem.domain.model.user;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void userShouldBeCreatedWithValidData() {
        UUID id = UUID.randomUUID();
        EmailAddress email = new EmailAddress("user@example.com");
        User user = new User(id, "Max Mustermann", email, Role.EMPLOYEE);

        assertEquals(id, user.getId());
        assertEquals("Max Mustermann", user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(Role.EMPLOYEE, user.getRole());
    }

    @Test
    void userShouldIdentifyAsAdmin() {
        User admin = new User(
                UUID.randomUUID(),
                "Alice Admin",
                new EmailAddress("admin@example.com"),
                Role.ADMIN
        );

        assertTrue(admin.isAdmin());
    }

    @Test
    void userShouldNotBeAdminIfRoleIsEmployee() {
        User employee = new User(
                UUID.randomUUID(),
                "Erik Employee",
                new EmailAddress("erik@example.com"),
                Role.EMPLOYEE
        );

        assertFalse(employee.isAdmin());
    }

    @Test
    void creatingUserWithNullValuesShouldThrow() {
        EmailAddress email = new EmailAddress("null@example.com");

        assertThrows(NullPointerException.class, () ->
                new User(null, "Name", email, Role.ADMIN));

        assertThrows(NullPointerException.class, () ->
                new User(UUID.randomUUID(), null, email, Role.ADMIN));

        assertThrows(NullPointerException.class, () ->
                new User(UUID.randomUUID(), "Name", null, Role.ADMIN));

        assertThrows(NullPointerException.class, () ->
                new User(UUID.randomUUID(), "Name", email, null));
    }
}