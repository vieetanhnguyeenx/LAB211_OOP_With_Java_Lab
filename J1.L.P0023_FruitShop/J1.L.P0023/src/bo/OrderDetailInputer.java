package bo;

import entity.Fruit;
import entity.OrderDetail;
import utils.Validation;

public class OrderDetailInputer {
    private OrderDetail orderDetail;
    private Fruit orderFruit;

    public OrderDetailInputer(){
        orderDetail = new OrderDetail();
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public void setOrderFruit(Fruit orderFruit) {
        this.orderFruit = orderFruit;
    }

    public void inputOrderDetail() {
        orderDetail.setFruitId(orderFruit.getId());
        orderDetail.setFruitName(orderFruit.getName());
        orderDetail.setPrice(orderFruit.getPrice());
        orderDetail.setQuantity(Validation.getInt(
                "Please input quantity: ",
                1,
                orderFruit.getQuantity()));

    }
}
