package bakery.packaging.app.model;

import java.util.List;

public class CreateFinalOrder {

    private List<CompletedOrder> completedOrder;

    public List<CompletedOrder> getOrderOutputs() {
        return completedOrder;
    }

    public void setFinalOrder(List<CompletedOrder> orderOutputs) {
        this.completedOrder = orderOutputs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        completedOrder
                .forEach(o -> {
                    builder.append(System.lineSeparator());
                    builder.append(o.getOrder().getAmount() + " " + o.getOrder().getProductCode() + " " + o.orderPackagingDetails());
                    builder.append(System.lineSeparator());
                });
        return builder.toString();

    }
}
