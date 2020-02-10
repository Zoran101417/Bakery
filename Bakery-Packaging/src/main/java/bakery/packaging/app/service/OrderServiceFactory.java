package bakery.packaging.app.service;


public class OrderServiceFactory {

    public static OrderService get() {
        return new OrderServiceImpl();
    }
}
