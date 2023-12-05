package bo;

import entity.Task;
import exception.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private int lastId;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        lastId = 0;
    }

    public Task addTask(Task task) {
        task.setId(++lastId);
        tasks.add(task);
        return task;
    }

    private int searchTaskById(int id) {
        if (id < 0)
            return -1;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id)
                return i;
        }

        return -1;
    }


    public Task deleteById(int id) throws ObjectNotFoundException {
        int index = searchTaskById(id);
        if (index != -1)
            return tasks.remove(index);

        throw new ObjectNotFoundException("Task dose not exits");
    }

    @Override
    public String toString() {
        String s = "\n----------------------------------------- Task -----------------------------------------\n";
        s += String.format("%-7s%-20s%-12s%-15s%-7s%-15s%-15s\n",
                "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task t: tasks) {
            s+= String.format("%-7d%-20s%-12s%-15s%-7.1f%-15s%-15s\n",
                    t.getId(),
                    t.getRequirementName(),
                    t.getType(),
                    t.getDateWithFormat(),
                    t.getTime(),
                    t.getAssignee(),
                    t.getExpert());
        }
        return s;
    }
}
