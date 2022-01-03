package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminUserTest {
    AdminUser adminUser = new AdminUser("email", "password");

    @Test
    void getUserEmail() {
        assertEquals("email", adminUser.getUserEmail());
    }

    @Test
    void getPassword() {
        assertEquals("********", adminUser.getPassword());
    }
}