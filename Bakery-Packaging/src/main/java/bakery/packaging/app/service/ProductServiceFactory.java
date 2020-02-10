package bakery.packaging.app.service;

public class ProductServiceFactory {

    public static ProductService get() {

        return new ProductServiceImpl();
    }

}
