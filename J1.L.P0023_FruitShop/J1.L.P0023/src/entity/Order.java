package entity;

import java.util.Map;

public class Order {
    private int id;
    private String customerName;
    private double totalPrice;
    private Map<Integer, OrderDetail> orderDetails;

    public Order() {
    }

    public Order(int id, String customerName, double totalPrice, Map<Integer, OrderDetail> orderDetails) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Integer, OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Map<Integer, OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
