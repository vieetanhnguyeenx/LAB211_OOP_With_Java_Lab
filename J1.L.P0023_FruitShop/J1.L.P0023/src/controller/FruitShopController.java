package controller;

import bo.*;
import entity.Fruit;
import entity.OrderDetail;
import utils.Validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopController {
    private FruitInputer fruitInputer;
    private FruitManager fruitManager;
    private OrderDetailInputer orderDetailInputer;
    private OrderManager orderManager;
    private OrderInputer orderInputer;

    public FruitShopController() {
        fruitManager = new FruitManager();
        orderManager = new OrderManager();
    }

    private Fruit addFruit() {
        fruitInputer = new FruitInputer();
        fruitInputer.inputFruitInformation();
        Fruit fruit = fruitInputer.getFruit();
        fruitManager.addFruit(fruit);
        return fruit;
    }

    public void addFruits() {
        List<Fruit> addedFruits = new ArrayList<>();

        do {
            addedFruits.add(addFruit());
        }while (Validation.getYesNo("Do you want to continue (Y/N)",
                "Invalid input!", true));

        System.out.println("List of added Fruits: ");
        System.out.println(String.format("%-15s%-25s%-15s%-15s%-15s", "ID", "Name", "Price", "Quantity", "Origin"));
        for (Fruit f : addedFruits) {
            System.out.println(f);
        }
    }

    public void addOrder(){
        if (fruitManager.isOutOfStock()) {
            System.out.println("Products are out of stock!");
            return;
        }

        // List all fruit
        System.out.println("List of fruit: ");
        System.out.println(fruitManager);
        orderDetailInputer = new OrderDetailInputer();
        Map<Integer, OrderDetail> orderDetailMap = new HashMap<>();

        // Loop to get all order detail
        do {
            if (fruitManager.isOutOfStock()) {
                System.out.println("Products are out of stock!");
                continue;
            }
            orderDetailInputer.setOrderDetail(new OrderDetail());
            int selectedId = Validation.getIntInKeySet("Enter select item",
                    1,
                    fruitManager.getLastId(),
                    fruitManager.getIdSet(),
                    "Invalid input, input must be in list");

            Fruit selectedFruit = fruitManager.getFruitInformationById(selectedId);
            if (selectedFruit.getQuantity() <= 0) {
                System.out.println("The product is out of stock!");
                continue;
            }

            if (orderDetailMap.containsKey(selectedFruit.getId()))
                if (selectedFruit.getQuantity() - orderDetailMap.get(selectedFruit.getId()).getQuantity() == 0) {
                    System.out.println("The product is out of stock!");
                    continue;
                } else {
                    selectedFruit.setQuantity(selectedFruit.getQuantity() - orderDetailMap.get(selectedFruit.getId()).getQuantity());
                }


            System.out.println("You selected: " + selectedFruit.getName());

            orderDetailInputer.setOrderFruit(selectedFruit);
            orderDetailInputer.inputOrderDetail();
            OrderDetail orderDetail = orderDetailInputer.getOrderDetail();
            if (orderDetailMap.containsKey(selectedFruit.getId())) {
                orderDetail.setQuantity(orderDetail.getQuantity() + orderDetailMap.get(selectedFruit.getId()).getQuantity());
                orderDetailMap.put(selectedFruit.getId(), orderDetail);
            }
            else
                orderDetailMap.put(selectedFruit.getId(), orderDetail);




        }while (!Validation.getYesNo("Do you want to order now (Y/N): ",
                "Invalid input (Y/N) only", true));

        if(!orderDetailMap.isEmpty()) {
            System.out.println(String.format("%-25s%-15s%-15s%-15s",
                    "Product",
                    "Quantity",
                    "Price",
                    "Amount"));

            double total = 0;
            for (Map.Entry<Integer, OrderDetail> entry : orderDetailMap.entrySet()) {
                System.out.println(entry.getValue());
                total += entry.getValue().getAmount();
            }

            System.out.println("Total: " + total + "$");

            orderInputer = new OrderInputer(orderDetailMap);
            orderInputer.inputOrder();

            orderManager.addOrder(orderInputer.getOrder());
            fruitManager.changeQuantity(orderInputer.getOrder());
        }


    }

    public void displayAllOrder() {
        System.out.println(orderManager);
    }

}
