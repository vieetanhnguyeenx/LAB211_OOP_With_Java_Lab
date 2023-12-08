package controller;

import bo.DoctorInputer;
import bo.DoctorManager;
import entity.Doctor;
import utils.Validation;

import javax.print.Doc;
import java.util.Map;

public class DoctorManageController {
    private DoctorManager doctorManager;
    private DoctorInputer doctorInputer;

    public DoctorManageController() {
        doctorManager = new DoctorManager();
    }

    public Doctor addDoctor() throws Exception {
        doctorInputer = new DoctorInputer();
        doctorInputer.inputDoctor();
        Doctor doctor = doctorInputer.getDoctor();

        if (doctorManager.addDoctor(doctor))
            return doctor;

        throw new Exception("Add failed!");
    }

    public Doctor updateDoctor() throws Exception {
        doctorInputer = new DoctorInputer();
        doctorInputer.inputDoctor();
        Doctor doctor = doctorInputer.getDoctor();

        Doctor doctorAfterUpdate = doctorManager.updateDoctor(doctor);
        if (doctorAfterUpdate != null)
            return doctorAfterUpdate;

        throw new AssertionError("Update failed");
    }

    public Doctor deleteDoctor() throws Exception {
        doctorInputer = new DoctorInputer();
        doctorInputer.deleteDoctor();
        Doctor doctor = doctorInputer.getDoctor();

        Doctor deletedDoctor = doctorManager.deleteDoctor(doctor);
        if (deletedDoctor != null)
            return deletedDoctor;

        throw new AssertionError("Delete failed");
    }

    public String searchDoctor() throws Exception {
        String s = Validation.getString("Enter text: ");
        Map<String, Doctor> map = doctorManager.searchDoctor(s);
        String result = String.format("%-10s%-20s%-25s%-20s\n",
                "Code",
                "Name",
                "Specialization",
                "Availability");

        for (Map.Entry<String, Doctor> entry : map.entrySet()) {
            result += entry.getValue().toString();
        }
        return result;
    }
}
