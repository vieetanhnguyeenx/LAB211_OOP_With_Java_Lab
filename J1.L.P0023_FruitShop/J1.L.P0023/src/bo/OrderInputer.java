package bo;

import entity.Order;
import entity.OrderDetail;
import utils.Validation;

import java.util.Map;

public class OrderInputer {
    private Order order;
    private Map<Integer, OrderDetail> orderDetails;


    public OrderInputer(Map<Integer, OrderDetail> orderDetails) {
        order = new Order();
        this.orderDetails = orderDetails;
    }

    public Order getOrder() {
        return order;
    }

    public void inputOrder() {
        order.setCustomerName(Validation.getString("Input your name: ",
                Validation.NAME_PATTERN,
                "Invalid input, input must be name"));
        double total = 0;
        for (Map.Entry<Integer, OrderDetail> entry: orderDetails.entrySet()) {
            total += entry.getValue().getAmount();
        }
        order.setTotalPrice(total);
        order.setOrderDetails(orderDetails);
    }
}
