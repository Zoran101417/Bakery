package bakery.packaging.app.model;

import java.util.List;

public class GetProductsOutput {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
