package ui;

import controller.StudentManageController;
import entity.Student;
import utils.Validation;

public class Main {
    public static void main(String[] args) {
        StudentManageController controller = new StudentManageController();

        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1.\tCreate");
            System.out.println("2.\tFind and Sort");
            System.out.println("3.\tUpdate/Delete");
            System.out.println("4.\tReport");
            System.out.println("5.\tExit");
            System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");

            int choice = Validation.getInt("Enter your choice:", 1, 5);

            switch (choice) {
                case 1:
                    controller.createStudent();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;

            }

        }
    }
}
