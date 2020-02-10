package bakery.packaging.app.model;

public class Order {
    private final String productCode;
    private final Integer amount;

    public Order(String productCode, Integer amount) {
        this.productCode = productCode;
        this.amount = amount;
    }

    public static Order of(String product, Integer amount) {
        return new Order(product, amount);
    }

    public String orderDetails() {
        return amount + " " + productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public Integer getAmount() {
        return amount;
    }
}
