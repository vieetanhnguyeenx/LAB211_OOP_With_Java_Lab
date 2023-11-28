package ui;

import bo.AccountManager;
import controller.AccountManagerController;
import controller.MenuController;
import utils.Validation;

public class Main {
    public static void main(String[] args) {
        AccountManagerController accountController = new AccountManagerController();

        do {
            // 1. Display main menu
            MenuController.DisplayMenu();

            // 2. Get user choice
            int choice = Validation.getInt("Please choice one option:", 1, 3);

            //3. Perform option base on the user choice
            switch (choice) {
                // Login with Vietnamese
                case 1:
                    accountController.login(AccountManagerController.VI_LANGUAGE);
                    break;
                // Login with English
                case 2:
                    accountController.login(AccountManagerController.EN_LANGUAGE);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }while (true);
    }
}
