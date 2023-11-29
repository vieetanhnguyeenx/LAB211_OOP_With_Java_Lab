package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Task {
    public static Map<Integer, TaskType> taskTypeMap = new HashMap<>();
    static {
        for (TaskType taskType : TaskType.values()) {
            taskTypeMap.put(taskType.getValue(), taskType);
        }
    }

    public enum TaskType {
        Code(1),
        Test(2),
        Design(3),
        Review(4);

        private int value;
        private TaskType(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    private int id;
    private TaskType type;
    private String requirementName;
    private LocalDate date;
    private double plantFrom;
    private double plantTo;
    private String assignee;
    private String expert;

    public Task() {
    }

    public Task(int id, TaskType type, String requirementName, LocalDate date, double plantFrom, double plantTo, String assignee, String expert) {
        this.id = id;
        this.type = type;
        this.requirementName = requirementName;
        this.date = date;
        this.plantFrom = plantFrom;
        this.plantTo = plantTo;
        this.assignee = assignee;
        this.expert = expert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public LocalDate getDate() {
        //localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        return date;
    }

    public String getDateWithFormat() {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public double getTime() {
        return plantTo - plantFrom;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPlantFrom() {
        return plantFrom;
    }

    public void setPlantFrom(double plantFrom) {
        this.plantFrom = plantFrom;
    }

    public double getPlantTo() {
        return plantTo;
    }

    public void setPlantTo(double plantTo) {
        this.plantTo = plantTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }
}
