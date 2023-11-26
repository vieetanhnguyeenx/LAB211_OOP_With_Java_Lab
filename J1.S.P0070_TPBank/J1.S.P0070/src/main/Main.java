package main;

import service.AccountService;
import util.Captcha;
import util.Validation;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        do {
            // 1. Display main menu
            Menu.DisplayMenu();

            // 2. Get user choice
            int choice = Validation.getInt("Please choice one option:", 1, 3);

            //3. Perform option base on the user choice
            switch (choice) {
                // Login with Vietnamese
                case 1:
                    accountService.setLocate(AccountService.VI_LANGUAGE);
                    accountService.Login();
                    break;
                // Login with English
                case 2:
                    accountService.setLocate(AccountService.EN_LANGUAGE);
                    accountService.Login();
                    break;
                case 3:
                    System.out.println(Captcha.generateCaptcha());
                    System.exit(0);
                    break;
            }
        }while (true);
    }
}
