package bakery.packaging.app.service;

import bakery.packaging.app.model.*;
import bakery.packaging.app.utils.CombinatePackagin;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService  {

    private final ProductService productService = ProductServiceFactory.get();

    @Override
    public CreateFinalOrder createOrder(CreateOrder orderInput) {
        List<Order> orders = orderInput.getOrders();

        Map<String, Product> codeProductMap = getAvailableProductsForOrders(orders);

        List<CompletedOrder> completedOrder = orders
                .stream()
                .map(order ->
                        Optional.ofNullable(codeProductMap.get(order.getProductCode()))
                                .map(product -> getProductOrderCalculation(product, order))
                                .orElse(CompletedOrder.emptyOutputOfOrder(order))
                )
                .collect(Collectors.toList());

        CreateFinalOrder finalOrder = new CreateFinalOrder();
        finalOrder.setFinalOrder(completedOrder);

        return finalOrder;
    }

    private Map<String, Product> getAvailableProductsForOrders(List<Order> orders) {

        List<String> productCodesToSearch = orders
                .stream()
                .map(Order::getProductCode)
                .collect(Collectors.toList());

        GetProductsSearchInput searchInput = new GetProductsSearchInput();
        searchInput.setProductCodes(productCodesToSearch);

        GetProductsOutput output = productService.getProducts(searchInput);

        return output
                .getProducts()
                .stream()
                .collect(Collectors.toMap(Product::getCode, p -> p));
    }

    private CompletedOrder getProductOrderCalculation(Product product, Order order) {

        Map<Integer, BigDecimal> saleSizePriceMap = product
                .getCustomerSaleDetails()
                .stream()
                .collect(Collectors.toMap(ProductSaleDetail::getSaleSize, ProductSaleDetail::getPrice));

        Map<Integer, Integer> sizedPackageAmountMap = CombinatePackagin.getRightCalculatedCombination(order.getAmount(), new ArrayList<>(saleSizePriceMap.keySet()));

        List<OrderSaleDetails> orderSaleDetails = sizedPackageAmountMap.entrySet()
                .stream()
                .map(entry -> new OrderSaleDetails(entry.getValue(), entry.getKey(), saleSizePriceMap.get(entry.getKey())))
                .collect(Collectors.toList());

        BigDecimal totalPrice = orderSaleDetails
                .stream()
                .map(f -> f.getSalePrice().multiply(new BigDecimal(f.getAmount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return CompletedOrder.of(order, totalPrice, orderSaleDetails);

    }



}
