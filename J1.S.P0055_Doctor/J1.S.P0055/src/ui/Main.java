package ui;

import bo.DoctorManager;
import controller.DoctorManageController;
import entity.Doctor;
import utils.Validation;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DoctorManageController controller = new DoctorManageController();

        while (true) {
            System.out.println("========= Doctor Management ==========");
            System.out.println("1.\tAdd Doctor");
            System.out.println("2.\tUpdate Doctor");
            System.out.println("3.\tDelete Doctor");
            System.out.println("4.\tSearch Doctor");
            System.out.println("5.\tExit");

            int choice = Validation.getInt("Enter your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    try {
                        System.out.println("--------- Add Doctor ----------");
                        System.out.println("Doctor added: " + controller.addDoctor());
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("--------- Update Doctor -------");
                        System.out.println("Doctor updated: " + controller.updateDoctor());
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("--------- Delete Doctor -------");
                        System.out.println("Doctor deleted: " + controller.deleteDoctor());
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("---------- Search Doctor --------");
                        String s = controller.searchDoctor();
                        System.out.println("--------- Result ------------");
                        System.out.println(s);
                    }catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    return;
            }

        }
    }
}
