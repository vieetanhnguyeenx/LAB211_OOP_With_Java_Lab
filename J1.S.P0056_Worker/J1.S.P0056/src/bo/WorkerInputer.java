package bo;

import entity.Worker;
import utils.Validation;

import java.util.Set;

public class WorkerInputer {
    private Worker worker;
    private Set<Integer> idSet;

    public WorkerInputer() {
        worker = new Worker();
    }

    public Worker getWorker() {
        return worker;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public void inputWorker() {
        if (idSet == null) {
            worker.setId(utils.Validation.getInt("Enter Code: "));

            worker.setName(Validation.getString("Enter Name: ",
                    Validation.NAME_PATTERN,
                    "Invalid input, input must be real name"));

            worker.setAge(Validation.getInt("Enter Age: ", 18, 50));

            worker.setSalary(Validation.getDouble("Enter Salary: ",
                    0.1, Integer.MAX_VALUE));

            worker.setWorkLocation(Validation.getString("Enter Work Location: "));
        } else {
            worker.setId(utils.Validation.getIntWithKeySet("Enter Code: ",
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE,
                    idSet,
                    "false",
                    false));

            worker.setName(Validation.getString("Enter Name: ",
                    Validation.NAME_PATTERN,
                    "Invalid input, input must be real name"));

            worker.setAge(Validation.getInt("Enter Age: ",
                    18,
                    50));

            worker.setSalary(Validation.getDouble("Enter Salary: ",
                    0.1,
                    Integer.MAX_VALUE));

            worker.setWorkLocation(Validation.getString("Enter Work Location: "));
        }

    }
}
