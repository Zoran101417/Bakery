package bakery.packaging.app.model;

import java.util.List;

public class Product {
    private final String name;
    private final String code;
    private List<ProductSaleDetail> customerSaleDetails;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<ProductSaleDetail> getCustomerSaleDetails() {
        return customerSaleDetails;
    }

    public void setCustomerSaleDetails(List<ProductSaleDetail> customerSaleDetails) {
        this.customerSaleDetails = customerSaleDetails;
    }

}
