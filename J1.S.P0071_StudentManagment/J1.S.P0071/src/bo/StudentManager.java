package bo;

import entity.Student;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;
    private int lastId;

    public StudentManager() {
        students = new ArrayList<>();
        lastId = 0;
    }


}
