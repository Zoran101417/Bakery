package bakery.packaging.app.utils;

import bakery.packaging.app.model.Order;
import bakery.packaging.app.model.Product;
import bakery.packaging.app.model.ProductSaleDetail;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final List<Product> CUSTOM_PRODUCTS;
    public static final List<Order> CLIENT_ORDERS;

    private Constants() {
    }

    static {
        Product vs5 = new Product("Vegemite Scroll", "VS5");
        vs5.setCustomerSaleDetails(
                Arrays.asList(
                                ProductSaleDetail.of(3, BigDecimal.valueOf(6.99)),
                                ProductSaleDetail.of(5, BigDecimal.valueOf(8.99))
                        )
        );

        Product mb11 = new Product("Blueberry Muffin", "MB11");
        mb11.setCustomerSaleDetails(
                Arrays.asList(
                                ProductSaleDetail.of(2, BigDecimal.valueOf(9.95)),
                                ProductSaleDetail.of(5, BigDecimal.valueOf(16.95)),
                                ProductSaleDetail.of(8, BigDecimal.valueOf(24.95))
                        )
        );

        Product cf = new Product("Croissant", "CF");
        cf.setCustomerSaleDetails(
                Arrays.asList(
                                ProductSaleDetail.of(3, BigDecimal.valueOf(5.95)),
                                ProductSaleDetail.of(5, BigDecimal.valueOf(9.95)),
                                ProductSaleDetail.of(9, BigDecimal.valueOf(16.99))
                        )
        );

        CUSTOM_PRODUCTS = Arrays.asList(vs5, mb11, cf);

        CLIENT_ORDERS = Arrays.asList(
                Order.of("VS5", 10),
                Order.of("MB11", 14),
                Order.of("CF", 13)
        );
    }
}
