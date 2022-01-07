package day03;

import java.time.LocalDate;

public interface CanSellInWebShop {
    String getName();
    int getPrice();
    LocalDate getExpirationDate();
    CanSellInWebShop buy();
}
