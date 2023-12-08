package bo;

import entity.Doctor;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Map;

public class DoctorManager {

    private Map<String, Doctor> doctors;

    public DoctorManager() {
        doctors = new HashMap<>();
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        if (doctors == null)
            throw new Exception("Database dose not exits");

        if (doctor == null)
            throw new Exception("Data does not exist");

        if (doctors.containsKey(doctor.getCode()))
            throw new Exception("Doctor code [" + doctor.getCode() + "] is duplicate");

        return doctors.putIfAbsent(doctor.getCode(), doctor) == null;
    }

    public Doctor updateDoctor(Doctor doctor) throws Exception {
        if (doctors == null)
            throw new Exception("Database dose not exits");

        if (doctor == null)
            throw new Exception("Data does not exist");

        if (!doctors.containsKey(doctor.getCode()))
            throw new Exception("Doctor code dose not exist");

        return doctors.put(doctor.getCode(), doctor);
    }

    public Doctor deleteDoctor(Doctor doctor) throws Exception {
        if (doctors == null)
            throw new Exception("Database dose not exits");

        if (doctor == null)
            throw new Exception("Data does not exist");

        if (!doctors.containsKey(doctor.getCode()))
            throw new Exception("Doctor code dose not exist");

        return doctors.remove(doctor.getCode());
    }

    public Map<String, Doctor> searchDoctor(String input) throws Exception {
        if (doctors == null)
            throw new Exception("Database dose not exits");

        if (input == null)
            throw new Exception("Data does not exist");

        Map<String, Doctor> searchedMap = new HashMap<>();
        for (Map.Entry<String, Doctor> entry : doctors.entrySet()) {
            if (entry.getValue().getName().contains(input))
                searchedMap.put(entry.getKey(), entry.getValue());
        }
        return searchedMap;
    }
}
