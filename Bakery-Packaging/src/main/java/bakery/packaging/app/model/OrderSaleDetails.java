package bakery.packaging.app.model;

import java.math.BigDecimal;

public class OrderSaleDetails {

    private final Integer amount;
    private final Integer saleSize;
    private final BigDecimal salePrice;

    public OrderSaleDetails(Integer amount, Integer saleSize, BigDecimal salePrice) {
        this.amount = amount;
        this.saleSize = saleSize;
        this.salePrice = salePrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getSaleSize() {
        return saleSize;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }
}
