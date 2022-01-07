package day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private int balance;
    private List<CanSellInWebShop> boughtItems = new ArrayList<>();

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean buy(CanSellInWebShop item) {
        if (balance < item.getPrice()) {
            return false;
        }
        CanSellInWebShop boughtItem = item.buy();
        if (item instanceof CanBuyExtendedGuarantee && balance >= 3 * item.getPrice()) {
            ((CanBuyExtendedGuarantee) boughtItem).buyExtendedGuarantee();
        }
        balance -= boughtItem.getPrice();
        boughtItems.add(boughtItem);
        return true;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public List<CanSellInWebShop> getBoughtItems() {
        return boughtItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name.toLowerCase(), user.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }
}
