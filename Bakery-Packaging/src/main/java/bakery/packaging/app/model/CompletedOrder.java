package bakery.packaging.app.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CompletedOrder {
    private final Order order;
    private final BigDecimal totalPrice;
    private final List<OrderSaleDetails> saleDetails;
    private final Boolean isEmpty;

    public CompletedOrder(Order order, BigDecimal totalPrice, List<OrderSaleDetails> saleDetails, Boolean isEmpty) {
        this.order = order;
        this.totalPrice = totalPrice;
        this.saleDetails = saleDetails;
        this.isEmpty = isEmpty;
    }

    public static CompletedOrder of(Order order, BigDecimal totalPrice, List<OrderSaleDetails> saleDetails) {
        return new CompletedOrder(order, totalPrice, saleDetails, false);
    }

    public static CompletedOrder emptyOutputOfOrder(Order order) {
        return new CompletedOrder(order, BigDecimal.ZERO, Collections.emptyList(), true);
    }

    public String orderPackagingDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        this.saleDetails.forEach(o -> {
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append(" " + o.getAmount() + " x " + o.getSaleSize() + " $" + o.getSalePrice());
        });
        return stringBuilder.toString();
    }

    public Order getOrder() {
        return order;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public List<OrderSaleDetails> getSaleDetails() {
        return saleDetails;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }
}
