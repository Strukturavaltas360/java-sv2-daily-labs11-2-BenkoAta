package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User("testuser", 1000);
    CanSellInWebShop item1 = new WebShopProduct("product1", 334);
    CanSellInWebShop item2 = new WebShopProduct("product2", 333);
    CanSellInWebShop item3 = new WebShopService("service", 500);
    CanSellInWebShop item4 = new WebShopService("service", 5000);

    @Test
    void buyProductTest() {
        assertTrue(user.buy(item1));
        assertEquals(1, user.getBoughtItems().size());
        CanSellInWebShop bought = user.getBoughtItems().get(0);
        assertNotSame(item1, bought);
        assertEquals(item1.getName(), bought.getName());
        assertEquals(item1.getPrice(), bought.getPrice());
        assertEquals(item1.getExpirationDate(), bought.getExpirationDate());
    }

    @Test
    void buyProductWithExtendedGuaranteeTest() {
        assertTrue(user.buy(item2));
        assertEquals(1, user.getBoughtItems().size());
        CanSellInWebShop bought = user.getBoughtItems().get(0);
        assertNotSame(item2, bought);
        assertEquals(item2.getName(), bought.getName());
        assertNotEquals(item2.getPrice(), bought.getPrice());
        assertNotEquals(item2.getExpirationDate(), bought.getExpirationDate());
    }


    @Test
    void buyServiceTest() {
        assertTrue(user.buy(item3));
        assertEquals(1, user.getBoughtItems().size());
        CanSellInWebShop bought = user.getBoughtItems().get(0);
        assertNotSame(item3, bought);
        assertEquals(item3.getName(), bought.getName());
        assertEquals(item3.getPrice(), bought.getPrice());
        assertEquals(item3.getExpirationDate(), bought.getExpirationDate());
    }

    @Test
    void buyFalseTest() {
        assertFalse(user.buy(item4));
        assertEquals(0, user.getBoughtItems().size());
    }
}