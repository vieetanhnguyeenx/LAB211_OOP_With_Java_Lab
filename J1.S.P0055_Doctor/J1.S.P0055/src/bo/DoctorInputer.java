package bo;

import entity.Doctor;
import utils.Validation;

public class DoctorInputer {
    private Doctor doctor;

    public DoctorInputer() {
        doctor = new Doctor();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void inputDoctor() {
        doctor.setCode(Validation.getString("Enter Code: "));

        doctor.setName(Validation.getString("Enter Name:"));

        doctor.setSpecialization(Validation.getString("Enter Specialization:"));

        doctor.setAvailability(Validation.getInt("Enter Availability: "));
    }

    public void deleteDoctor() {
        doctor.setCode(Validation.getString("Enter Code: "));
    }

}
