package day03;

import java.time.LocalDate;

public class WebShopService implements CanSellInWebShop {
    private static final int DEFAULT_EXPIRATION_MONTH = 12;
    private String name;
    private int price;
    private LocalDate expirationDate;

    public WebShopService(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public WebShopService(WebShopService service) {
        this.name = service.name;
        this.price = service.price;
        this.expirationDate = getExpirationDate();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public LocalDate getExpirationDate() {
        if (expirationDate != null) {
            return expirationDate;
        }
        return LocalDate.now().plusMonths(DEFAULT_EXPIRATION_MONTH);
    }

    @Override
    public CanSellInWebShop buy() {
        return new WebShopService(this);
    }
}
