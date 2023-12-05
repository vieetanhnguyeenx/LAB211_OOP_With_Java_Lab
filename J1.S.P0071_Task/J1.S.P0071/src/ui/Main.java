package ui;

import bo.TaskManager;
import controller.MenuController;
import controller.TaskController;
import utils.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        MenuController menuController = new MenuController();
        TaskController taskController = new TaskController();

        while (true) {
            menuController.display();
            int choice = menuController.getOption("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    taskController.addTask();
                    break;
                case 2:
                    taskController.deleteTask();
                    break;
                case 3:
                    taskController.displayAllTask();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }


    }
}
