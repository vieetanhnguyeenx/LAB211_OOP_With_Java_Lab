package ui;

import controller.WorkerManageController;
import exception.Validation;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.put(1, 1));

        WorkerManageController controller = new WorkerManageController();

        while (true) {
            System.out.println("======== Worker Management =========");
            System.out.println("1.\tAdd Worker");
            System.out.println("2.\tUp salary");
            System.out.println("3.\tDown salary");
            System.out.println("4.\tDisplay Information salary");
            System.out.println("5.\tExit");

            int choice = Validation.getInt("Enter choice: ", 1, 5);
            switch (choice) {
                case 1:
                    try {
                        controller.addWorker();
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
            }
        }
    }
}
