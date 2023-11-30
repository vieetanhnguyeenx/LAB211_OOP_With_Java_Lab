package entity;

import java.util.ArrayList;
import java.util.Map;

public class Order {
    private int id;
    private String customerName;
    private double totalPrice;
    private ArrayList<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(int id, String customerName, double totalPrice, ArrayList<OrderDetail> orderDetails) {
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

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
