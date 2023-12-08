package ui;

import bo.DoctorManager;
import entity.Doctor;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DoctorManager doctorManager = new DoctorManager();
        try {
            boolean s =doctorManager.addDoctor(new Doctor("Doc 1", "NVA", "Rang Ham Mat", 1));
            System.out.println(s);

            boolean i =doctorManager.addDoctor(new Doctor("Doc 1", "HA", "Rang Ham Mat", 1));
            System.out.println(i);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
