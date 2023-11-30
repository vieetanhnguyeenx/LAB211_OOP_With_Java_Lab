package bo;

import entity.Fruit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitManager {
    private Map<Integer, Fruit> fruits;
    private int lastId;

    public FruitManager() {
        fruits = new HashMap<>();
        lastId = 0;
    }

    public Fruit addFruit(Fruit fruit) {
        fruit.setId(++lastId);
        fruits.put(fruit.getId(), fruit);
        return fruit;
    }

    public Fruit getFruitById(int id) {
        return fruits.get(id);
    }

    public int getLastId() {
        return lastId;
    }

    public Set<Integer> getIdSet() {
        return fruits.keySet();
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
