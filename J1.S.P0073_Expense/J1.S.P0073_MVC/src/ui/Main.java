package ui;

import controller.ExpenseManageController;
import utils.Validation;

public class Main {
    public static void main(String[] args) {
        ExpenseManageController controller = new ExpenseManageController();

        while (true) {
            System.out.println("=======Handy Expense program======");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");

            int choice = Validation.getInt("Your choice: ",
                    1,
                    4);

            switch (choice) {
                case 1:
                    System.out.println("-------- Add an expense--------");
                    try {
                        System.out.println("Added expense " + controller.addExpense());
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("---------Display all expenses------------");
                    System.out.println(controller.getDisplayedExpense());
                    break;

                case 3:
                    System.out.println("--------Delete an expense------");
                    try {
                        System.out.println("Delete an expense successful " + controller.deleteExpense());
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;

                case 4:
                    return;
            }

        }
    }
}
