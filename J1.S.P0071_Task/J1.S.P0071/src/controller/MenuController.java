package controller;

import utils.Validation;

public class MenuController {
    public MenuController() {

    }

    public void display() {
        System.out.println("========= Task program =========");
        System.out.println("1.\tAdd Task");
        System.out.println("2.\tDelete task");
        System.out.println("3.\tDisplay Task");
        System.out.println("4.\tExit");

    }

    public int getOption(String msg, int min, int max) {
        return Validation.getInt(msg, min, max);
    }
}
