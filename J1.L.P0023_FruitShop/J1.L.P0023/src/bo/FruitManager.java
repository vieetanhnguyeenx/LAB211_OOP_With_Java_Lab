package bo;

import entity.Fruit;
import entity.Order;
import entity.OrderDetail;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitManager {
    private Map<Integer, Fruit> fruits;
    private int lastId;
    private int totalQuantity;

    public FruitManager() {
        fruits = new HashMap<>();
        lastId = 0;
        totalQuantity = 0;
    }

    public boolean addFruit(Fruit fruit) {
        fruit.setId(++lastId);
        fruits.put(fruit.getId(), fruit);
        totalQuantity += fruit.getQuantity();
        return true;
    }

    public Fruit getFruitById(int id) {
        return  fruits.get(id);
    }

    public Fruit getFruitInformationById(int id) {
        Fruit f = fruits.get(id);
        return new Fruit(f.getId(), f.getName(), f.getPrice(), f.getQuantity(), f.getOrigin());
    }

    public int getLastId() {
        return lastId;
    }

    public Set<Integer> getIdSet() {
        return fruits.keySet();
    }


    public void changeQuantity(Order order) {
        for (Map.Entry<Integer, OrderDetail> entry : order.getOrderDetails().entrySet() ) {
            fruits.get(entry.getKey()).setQuantity(fruits.get(entry.getKey()).getQuantity() - entry.getValue().getQuantity());
            totalQuantity -= entry.getValue().getQuantity();
        }
    }

    public boolean isOutOfStock() {
        return !(totalQuantity > 0);
    }

    @Override
    public String toString() {
        // %10s%26s%12s%11s
        String s = String.format("%-15s%-25s%-15s%-15s\n",
                "Item",
                "Fruit Name",
                "Origin",
                "Price");

        for (Map.Entry<Integer, Fruit> entry : fruits.entrySet()){
            s += String.format("%-15d%-25s%-15s%-15.1f\n",
                    entry.getValue().getId(),
                    entry.getValue().getName(),
                    entry.getValue().getOrigin(),
                    entry.getValue().getPrice());
        }
        return s;
    }


}
