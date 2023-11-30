package bo;

import entity.Fruit;

import java.util.HashMap;
import java.util.Map;

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


}
