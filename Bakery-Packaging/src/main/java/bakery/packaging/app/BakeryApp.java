package bakery.packaging.app;

import bakery.packaging.app.model.CreateFinalOrder;
import bakery.packaging.app.model.CreateOrder;
import bakery.packaging.app.service.OrderService;
import bakery.packaging.app.service.OrderServiceFactory;
import bakery.packaging.app.utils.Constants;

public class BakeryApp {

    public static void main(String[] args){
        System.out.println("------- BAKERY ------");
        System.out.println("Orders that are ordered: ");

        Constants.CLIENT_ORDERS.forEach(o -> System.out.println(o.orderDetails()));

        CreateOrder orderInput = new CreateOrder();
        orderInput.setOrders(Constants.CLIENT_ORDERS);

        OrderService orderService = OrderServiceFactory.get();

        CreateFinalOrder finalOrder = orderService.createOrder(orderInput);

        System.out.println(System.lineSeparator());
        System.out.println("---- The best packaging of orders are: ");
        System.out.println(finalOrder.toString());

    }
}
