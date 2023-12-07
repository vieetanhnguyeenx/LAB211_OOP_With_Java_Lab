package bo;

import entity.SalaryHistory;

import java.util.ArrayList;
import java.util.List;

public class WorkerSalaryManager {
    private List<SalaryHistory> histories;

    public WorkerSalaryManager() {
        histories = new ArrayList<>();
    }

    public boolean addHistory(SalaryHistory salaryHistory) {
        return histories.add(salaryHistory);
    }

    @Override
    public String toString() {
        String s = String.format("%-10s%-20s%-10s%-15s%-12s%-20s\n",
                "Code",
                "Name",
                "Age",
                "Salary",
                "Status",
                "Date");
        for (SalaryHistory salaryHistory : histories) {
            s += salaryHistory;
        }

        return s + "\n";
    }
}
