package controller;

import bo.WorkerInputer;
import bo.WorkerManager;
import bo.WorkerSalaryInputer;
import bo.WorkerSalaryManager;
import entity.SalaryHistory;
import entity.Worker;

public class WorkerManageController {
    WorkerManager workerManager;
    WorkerInputer workerInputer;
    WorkerSalaryManager workerSalaryManager;
    WorkerSalaryInputer workerSalaryInputer;

    public WorkerManageController() {
        workerManager = new WorkerManager();
        workerSalaryManager = new WorkerSalaryManager();
    }

    public void addWorker() throws Exception {
        workerInputer = new WorkerInputer();
        workerInputer.inputWorker();
        Worker worker = workerInputer.getWorker();
        workerManager.addWorker(worker);
    }

    public SalaryHistory increaseSalary() throws Exception {
        workerSalaryInputer = new WorkerSalaryInputer();

        workerSalaryInputer.inputSalaryHistory();
        SalaryHistory salaryHistory = workerSalaryInputer.getSalaryHistory();
        salaryHistory.setStatus(SalaryHistory.SalaryStatus.UP);

        return changeSalary(salaryHistory);
    }

    public SalaryHistory decreaseSalary() throws Exception {
        workerSalaryInputer = new WorkerSalaryInputer();

        workerSalaryInputer.inputSalaryHistory();
        SalaryHistory salaryHistory = workerSalaryInputer.getSalaryHistory();
        salaryHistory.setStatus(SalaryHistory.SalaryStatus.DOWN);

        return changeSalary(salaryHistory);
    }

    private SalaryHistory changeSalary(SalaryHistory salaryHistory) throws Exception {
        Worker worker = workerManager.changeSalary(salaryHistory.getStatus(),
                salaryHistory.getId(),
                salaryHistory.getAmount());
        if (worker == null)
            throw new AssertionError();

        salaryHistory.setBaseInfo(worker);
        if (workerSalaryManager.addHistory(salaryHistory))
            return salaryHistory;

        throw new Exception("Add Failed!");
    }

    public String getDisplayedInformationSalary() {
        return workerSalaryManager.toString();
    }
}
