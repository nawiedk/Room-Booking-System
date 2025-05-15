package com.nk.booking.roombookingsystem.domain.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailAddressTest {

    @Test
    void validEmailShouldBeAccepted() {
        EmailAddress email = new EmailAddress("test.user@example.com");
        assertEquals("test.user@example.com", email.getValue());
    }

    @Test
    void emailShouldBeLowercased() {
        EmailAddress email = new EmailAddress("TEST@EXAMPLE.COM");
        assertEquals("test@example.com", email.getValue());
    }

    @Test
    void invalidEmailShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new EmailAddress("invalid-email"));
    }

    @Test
    void equalEmailsShouldBeEqual() {
        EmailAddress a = new EmailAddress("user@example.com");
        EmailAddress b = new EmailAddress("user@example.com");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void differentEmailsShouldNotBeEqual() {
        EmailAddress a = new EmailAddress("user1@example.com");
        EmailAddress b = new EmailAddress("user2@example.com");
        assertNotEquals(a, b);
    }
}
