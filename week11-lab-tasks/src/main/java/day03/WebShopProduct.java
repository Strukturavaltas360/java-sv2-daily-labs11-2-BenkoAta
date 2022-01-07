package day03;

import java.time.LocalDate;

public class WebShopProduct implements CanSellInWebShop, CanBuyExtendedGuarantee {
    private static final int DEFAULT_GUARANTEE_MONTH = 3;
    private static final int EXTENDED_GUARANTEE_MONTH = 36;
    private String name;
    private int price;
    private LocalDate expirationDate;

    public WebShopProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public WebShopProduct(WebShopProduct product) {
        this.name = product.name;
        this.price = product.price;
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
        return LocalDate.now().plusMonths(DEFAULT_GUARANTEE_MONTH);
    }

    @Override
    public CanSellInWebShop buy() {
        return new WebShopProduct(this);
    }

    @Override
    public void buyExtendedGuarantee() {
        expirationDate = expirationDate.plusMonths((long) EXTENDED_GUARANTEE_MONTH - DEFAULT_GUARANTEE_MONTH);
        price *= 1.1;
    }
}
