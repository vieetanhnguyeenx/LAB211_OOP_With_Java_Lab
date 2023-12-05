package bo;

import entity.Worker;
import exception.Validation;

import java.util.List;

public class WorkerInputer {
    private Worker worker;
    private List<Integer> idList;

    public WorkerInputer() {
        worker = new Worker();
    }

    public Worker getWorker() {
        return worker;
    }

    public void inputWorker() {
        worker.setId(-1);
        worker.setName(Validation.getString("Enter Name: ",
                Validation.NAME_PATTERN,
                "Invalid input, input must be real name"));
    }
}
