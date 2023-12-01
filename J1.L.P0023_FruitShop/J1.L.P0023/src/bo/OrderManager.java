package bo;

import entity.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private Map<Integer, Order> orders;
    private int lastId;

    public OrderManager() {
        orders = new HashMap<>();
        lastId = 0;
    }

    public Order addOrder(Order order) {
        order.setId(++lastId);
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public String toString() {
        String s = "";

        for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
            s += entry.getValue().toString() + "\n";
        }

        return s;
    }
}
