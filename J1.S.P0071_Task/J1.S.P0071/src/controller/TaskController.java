package controller;

import bo.TaskInputter;
import bo.TaskManager;
import entity.Task;
import exception.ObjectNotFoundException;

public class TaskController {
    private TaskInputter taskInputter;
    private TaskManager taskManager;

    public TaskController() {
        taskManager = new TaskManager();
    }

    public void addTask() {
        taskInputter = new TaskInputter();
        taskInputter.createTask();
        Task task = taskInputter.getTask();
        taskManager.addTask(task);

    }

    public void displayAllTask() {
        System.out.println(taskManager);
    }

    public void deleteTask() {
        int taskId = taskInputter.deleteTask();
        try {
            Task task = taskManager.deleteById(taskId);
            if (task != null)
                System.out.println("Deleted");

        } catch (ObjectNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Delete Failed");
        }
    }

}
