package controller;

import bo.*;
import entity.Fruit;
import entity.OrderDetail;
import utils.Validation;

import java.util.ArrayList;
import java.util.List;

public class FruitShopController {
    private FruitInputer fruitInputer;
    private FruitManager fruitManager;
    private OrderDetailInputer orderDetailInputer;
    private OrderManager orderManager;
    private OrderInputer orderInputer;

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

    public void addOrder(){
        System.out.println("List of fruit: ");
        System.out.println(fruitManager);
        orderDetailInputer = new OrderDetailInputer();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        do {
            int selectedId = Validation.getIntInKeySet("Enter select item",
                    1,
                    fruitManager.getLastId(),
                    fruitManager.getIdSet(),
                    "Invalid input, input must be in list");

            Fruit selectedFruit = fruitManager.getFruitById(selectedId);

            System.out.println("You selected: " + selectedFruit.getName());

            orderDetailInputer.setOrderFruit(selectedFruit);
            orderDetailInputer.inputOrderDetail();
        }while (Validation.getYesNo("Do you want to order now (Y/N): ", "Invalid input (Y/N) only"));


    }
}
