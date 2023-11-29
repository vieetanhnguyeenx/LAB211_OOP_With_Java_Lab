package entity;

import java.util.HashMap;
import java.util.Map;

public class Student implements Comparable<Student>{

    public enum Course {

        Java("Java", 1),
        DotNet (".Net", 2),
        CCPlus ("C/C++", 3);


        private int id;
        private String name;

        private Course(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public static Course getTypeByInt(int type) {
            switch (type) {
                case 1:
                    return Java;
                case 2:
                    return DotNet;
                case 3:
                    return CCPlus;
                default:
                    throw new AssertionError();

            }
        }
    }

    private int id;
    private String name;
    private String semester;
    private Course course;

    public Student(int id, String name, String semester, Course course) {
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

    public Course getCourse() {
        return course;
    }

    public String getCourseName() {
        return course.getName();
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int compareTo(Student s) {
        return this.getName().compareTo(s.getName());
    }
}
