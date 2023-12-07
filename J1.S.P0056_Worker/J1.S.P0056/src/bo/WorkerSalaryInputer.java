package bo;

import entity.SalaryHistory;
import utils.Validation;

import java.time.LocalDate;

public class WorkerSalaryInputer {
    private SalaryHistory salaryHistory;

    public WorkerSalaryInputer() {
        salaryHistory = new SalaryHistory();
    }

    public SalaryHistory getSalaryHistory() {
        return salaryHistory;
    }

    public void inputSalaryHistory() {
        salaryHistory.setId(Validation.getInt("Enter Code: "));
        salaryHistory.setAmount(Validation.getDouble("Enter Salary: ", 0.01, Double.MAX_VALUE));
        salaryHistory.setDate(LocalDate.now());
    }
}
