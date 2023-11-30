package controller;

import bo.FruitInputer;
import bo.FruitManager;
import entity.Fruit;
import utils.Validation;

import java.util.ArrayList;
import java.util.List;

public class FruitShopController {
    private FruitInputer fruitInputer;
    private FruitManager fruitManager;

    public FruitShopController() {
        fruitManager = new FruitManager();
    }

    private Fruit addFruit() {
        fruitInputer = new FruitInputer();
        fruitInputer.inputFruitInformation();
        Fruit fruit = fruitInputer.getFruit();
        return fruitManager.addFruit(fruit);
    }

    public void addFruits() {
        List<Fruit> addedFruits = new ArrayList<>();

        do {
            addedFruits.add(addFruit());
        }while (Validation.getYesNo("Do you want to continue (Y/N)",
                "Invalid input!"));

        System.out.println("List of added Fruits: ");
        System.out.println(String.format("%-15s%-25s%-15s%-15s%-15s", "ID", "Name", "Price", "Quantity", "Origin"));
        for (Fruit f : addedFruits) {
            System.out.println(f);
        }
    }
}
