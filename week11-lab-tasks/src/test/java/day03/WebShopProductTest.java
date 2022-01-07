package day03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WebShopProductTest {
    WebShopProduct product = new WebShopProduct("product", 100);

    @Test
    void getExpirationDate() {
        assertEquals(LocalDate.now().plusMonths(3), product.getExpirationDate());
    }

    @Test
    void buy() {
        WebShopProduct bought = (WebShopProduct) product.buy();
        assertNotSame(product, bought);
        assertEquals(product.getName(), bought.getName());
        assertEquals(product.getPrice(), bought.getPrice());
        assertEquals(LocalDate.now().plusMonths(3), bought.getExpirationDate());
    }

    @Test
    void buyExtendedGuarantee() {
        WebShopProduct bought = (WebShopProduct) product.buy();
        bought.buyExtendedGuarantee();

        assertEquals(LocalDate.now().plusMonths(36), bought.getExpirationDate());
    }

    @Test
    void getName() {
        assertEquals("product", product.getName());
    }

    @Test
    void getPrice() {
        assertEquals(100, product.getPrice());
    }
}