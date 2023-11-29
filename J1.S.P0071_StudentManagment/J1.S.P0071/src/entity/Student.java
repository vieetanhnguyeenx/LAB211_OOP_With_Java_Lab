package entity;

import java.util.HashMap;
import java.util.Map;

public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private String semester;
    private StudentCourse.Course course;

    public Student(int id, String name, String semester, StudentCourse.Course course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public StudentCourse.Course getCourse() {
        return course;
    }

    public String getCourseName() {
        return course.getName();
    }

    public void setCourse(StudentCourse.Course course) {
        this.course = course;
    }

    @Override
    public int compareTo(Student s) {
        return this.getName().compareTo(s.getName());
    }
}
