package day03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebShopTest {
    List<CanSellInWebShop> itemsOk = List.of(
            new WebShopProduct("item1", 334),
            new WebShopProduct("item2", 333),
            new WebShopService("item3", 500),
            new WebShopService("item4", 5000)
    );
    List<CanSellInWebShop> itemsNok = List.of(
            new WebShopProduct("item1", 334),
            new WebShopProduct("Item", 333),
            new WebShopService("item", 500),
            new WebShopService("item4", 5000)
    );
    List<User> usersOk = List.of(
            new User("user1", 1000),
            new User("user2", 1000),
            new User("user3", 1000)
    );
    List<User> usersNok = List.of(
            new User("user1", 1000),
            new User("User", 1000),
            new User("user", 1000)
    );

    WebShop webShop = new WebShop(itemsOk, usersOk);

    @Test
    void createOkTest() {
        webShop = new WebShop(itemsOk);
        assertEquals(4, webShop.getItems().size());
        assertEquals(0, webShop.getUsers().size());

        webShop = new WebShop(itemsOk, usersOk);
        assertEquals(4, webShop.getItems().size());
        assertEquals(3, webShop.getUsers().size());
    }

    @Test
    void createNokTest() {
        assertThrows(IllegalArgumentException.class, () -> new WebShop(itemsNok));
        assertThrows(IllegalArgumentException.class, () -> new WebShop(itemsOk, usersNok));
    }

    @Test
    void addItemOkTest() {
        assertEquals(4, webShop.getItems().size());
        webShop.addItem(new WebShopProduct("product123", 123));
        assertEquals(5, webShop.getItems().size());
        CanSellInWebShop actual = webShop.getItems().get(4);
        assertEquals("product123", actual.getName());
        assertEquals(123, actual.getPrice());
    }

    @Test
    void addItemNokTest() {
        CanSellInWebShop item = new WebShopProduct("ITEM1", 123);
        assertThrows(IllegalArgumentException.class, () -> webShop.addItem(item));
    }

    @Test
    void addUserOkTest() {
        assertEquals(3, webShop.getUsers().size());
        webShop.addUser(new User("user123", 123));
        assertEquals(4, webShop.getUsers().size());
        User actual = webShop.getUsers().get(3);
        assertEquals("user123", actual.getName());
        assertEquals(123, actual.getBalance());
    }

    @Test
    void addUserNokTest() {
        User user = new User("USER1", 1);
        assertThrows(IllegalArgumentException.class, () -> webShop.addUser(user));
    }

    @Test
    void buyTest() {
        User user = webShop.getUsers().get(0);
        assertEquals(0, user.getBoughtItems().size());
        assertTrue(webShop.buy(user.getName(), "item1"));
        assertEquals(1, user.getBoughtItems().size());
        assertFalse(webShop.buy(user.getName(), "item4"));
        assertEquals(1, user.getBoughtItems().size());
    }

    @Test
    void buyExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> webShop.buy("user", "item1"));
        assertThrows(IllegalArgumentException.class, () -> webShop.buy("user1", "item"));
    }
}