package entity;

import java.util.Calendar;

public class Candidate {
    public enum CandidateType{
        Experience(0),
        Fresher(1),
        Intern(2);

        private final int value;
        private CandidateType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private int id;
    private String firstName;
    private String lastName;
    private int yob;
    private String address;
    private String phone;
    private String email;
    private CandidateType type;

    public Candidate() {
    }

    public Candidate(int id, String firstName, String lastName, int yob, String address, String phone, String email, CandidateType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yob = yob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) throws Exception {
        if (yob < 1900 || yob > Calendar.getInstance().get(Calendar.YEAR))
            throw new Exception("Yob out of range");
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CandidateType getType() {
        return type;
    }

    public void setType(CandidateType type) {
        this.type = type;
    }
}
