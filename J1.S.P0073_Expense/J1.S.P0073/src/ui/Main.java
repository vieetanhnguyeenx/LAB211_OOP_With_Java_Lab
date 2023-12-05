package ui;

import controller.ExpenseManageController;
import exception.ExpenseNotFoundException;
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

            int choice = Validation.getInt("Your choice: ", 1, 4);

            switch (choice) {
                case 1:
                    System.out.println("Expense added: " + controller.addExpense());
                    break;
                case 2:
                    System.out.println(controller.getExpensesDisplayed());
                    break;
                case 3:
                    try {
                        System.out.println("Expense deleted: " + controller.deleteExpense());
                    } catch (ExpenseNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
