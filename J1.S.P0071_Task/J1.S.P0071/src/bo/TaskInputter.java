package bo;

import entity.Task;
import utils.Validation;

import java.time.LocalDate;

public class TaskInputter {
    private Task task;

    public TaskInputter() {
        task = new Task();
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void createTask() {
        String name = Validation.getString("Requirement Name: ",
                Validation.NAME_PATTERN,
                "Invalid input, input must be real name!");

        int taskTypeInt = Validation.getInt("Task Type: ",
                1,
                4);

        Task.TaskType type = Task.taskTypeMap.get(taskTypeInt);

        LocalDate localDate = Validation.getLocalDate("Date: ",
                "Invalid input, input must be date with format dd-MM-yyyy!",
                "dd-MM-yyyy",
                "Invalid date format, input must be date with format dd-MM-yyyy!");

        double from = Validation.getDoubleWithRegex("From: ",
                Validation.TIME_NUMBER_PATTERN,
                "Invalid input, input must be date with format x.0 or x.5",
                8,
                17);

        double to = Validation.getDoubleWithRegex("To: ",
                Validation.TIME_NUMBER_PATTERN,
                "Invalid input, input must be date with format x.0 or x.5",
                from + 0.5,
                17.5);

        String assignee = Validation.getString("Assignee: ");
        String reviewer = Validation.getString("Reviewer: ");

        task.setId(-1);
        task.setType(type);
        task.setRequirementName(name);
        task.setDate(localDate);
        task.setPlantFrom(from);
        task.setPlantTo(to);
        task.setAssignee(assignee);
        task.setExpert(reviewer);
    }

    public int deleteTask() {
        System.out.println("---------Del Task------");
        return Validation.getInt("ID: ");
    }
}
