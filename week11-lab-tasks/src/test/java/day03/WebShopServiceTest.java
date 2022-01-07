package day03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WebShopServiceTest {
    WebShopService service = new WebShopService("service", 200);

    @Test
    void getName() {
        assertEquals("service", service.getName());
    }

    @Test
    void getPrice() {
        assertEquals(200, service.getPrice());
    }

    @Test
    void getExpirationDate() {
        assertEquals(LocalDate.now().plusMonths(12), service.getExpirationDate());
    }

    @Test
    void buy() {
        WebShopService bought = (WebShopService) service.buy();
        assertNotSame(service, bought);
        assertEquals(service.getName(), bought.getName());
        assertEquals(service.getPrice(), bought.getPrice());
        assertEquals(LocalDate.now().plusMonths(12), bought.getExpirationDate());
    }
}