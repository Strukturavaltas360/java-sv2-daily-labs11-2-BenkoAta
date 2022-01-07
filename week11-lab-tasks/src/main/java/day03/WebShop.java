package day03;

import java.util.ArrayList;
import java.util.List;

public class WebShop {
    private List<CanSellInWebShop> items = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public WebShop() {
    }

    public WebShop(List<CanSellInWebShop> items) {
        for (CanSellInWebShop item : items) {
            addItem(item);
        }
    }

    public WebShop(List<CanSellInWebShop> items, List<User> users) {
        this(items);
        for (User user : users) {
            addUser(user);
        }
    }

    public boolean buy(String userName, String itemName) {
        CanSellInWebShop item = findItem(itemName);
        if (item == null) {
            throw new IllegalArgumentException(String.format("Can not find item (%s)!", itemName));
        }
        int userIndex = users.indexOf(new User(userName, 0));
        if (userIndex < 0) {
            throw new IllegalArgumentException(String.format("Can not find user (%s)!", userName));
        }
        return users.get(userIndex).buy(item);
    }

    public void addItem(CanSellInWebShop item) {
        if (findItem(item.getName()) != null) {
            throw new IllegalArgumentException(String.format("Same item (%s) can not be added twice!", item.getName()));
        }
        items.add(item);
    }

    public void addUser(User user) {
        if (users.contains(user)) {
            throw new IllegalArgumentException(String.format("Same user (%s) can not be added twice!", user.getName()));
        }
        users.add(user);
    }

    private CanSellInWebShop findItem(String itemName) {
        CanSellInWebShop result = null;
        for (CanSellInWebShop item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                if (result != null) {
                    throw new IllegalStateException(String.format("Duplicated item (%s) found!", itemName));
                }
                result = item;
            }
        }
        return result;
    }

    public List<CanSellInWebShop> getItems() {
        return items;
    }

    public List<User> getUsers() {
        return users;
    }
}
