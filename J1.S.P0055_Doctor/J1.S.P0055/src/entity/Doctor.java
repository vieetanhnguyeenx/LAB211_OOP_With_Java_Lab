package entity;

public class Doctor {
    private String code;
    private String name;
    private String Specialization;
    private int availability;

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        Specialization = specialization;
        this.availability = availability;
    }

    public Doctor() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
