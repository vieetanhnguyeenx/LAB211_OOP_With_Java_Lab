package controller;

import bo.WorkerInputer;
import bo.WorkerManager;
import bo.WorkerSalaryInputer;
import bo.WorkerSalaryManager;
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
}
