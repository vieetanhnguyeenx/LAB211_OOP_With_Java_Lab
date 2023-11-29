package entity;

import java.util.HashMap;
import java.util.Map;

public class StudentCourse {
    private static Map<Integer, Course> courseMapInt = new HashMap<>();
    private static Map<Integer, String> courseMapString = new HashMap<>();

    static {
        for (Course course : Course.values()) {
            courseMapInt.put(course.getId(), course);
            courseMapString.put(course.getId(), course.getName());
        }
    }

    public static String getCourseName(int id) {
        return courseMapString.get(id);
    }

    public static Course getCourseType(int id) {
        return courseMapInt.get(id);
    }

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
    }
}
