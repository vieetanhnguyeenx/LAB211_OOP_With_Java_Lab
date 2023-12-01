package ui;

import controller.FruitShopController;
import utils.Validation;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FruitShopController controller = new FruitShopController();

        while (true) {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1.\tCreate Fruit");
            System.out.println("2.\tView orders");
            System.out.println("3.\tShopping (for buyer)");
            System.out.println("4.\tExit");
            System.out.println(" (Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).");

            int choice = Validation.getInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    controller.addFruits();
                    break;
                case 2:
                    controller.displayAllOrder();
                    break;
                case 3:
                    controller.addOrder();
                    break;
                case 4:
                    return;
            }

        }
    }
}
