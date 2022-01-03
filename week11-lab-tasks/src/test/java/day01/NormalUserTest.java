package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalUserTest {
    NormalUser normalUser = new NormalUser("email", "password");

    @Test
    void getUserEmail() {
        assertEquals("email", normalUser.getUserEmail());
    }

    @Test
    void getPassword() {
        assertEquals("password", normalUser.getPassword());
    }
}