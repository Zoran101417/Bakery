package bakery.packaging.app.service;

import bakery.packaging.app.model.CreateFinalOrder;
import bakery.packaging.app.model.CreateOrder;

public interface OrderService {

    CreateFinalOrder createOrder(CreateOrder orderInput);
}
