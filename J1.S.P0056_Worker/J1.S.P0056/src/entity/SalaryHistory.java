package entity;

import java.time.LocalDate;

public class SalaryHistory extends Worker{

    public enum SalaryStatus {
        UP,
        DOWN;
    }

    public SalaryHistory() {

    }

    private SalaryStatus status;
    private LocalDate date;

    public SalaryHistory(int id, String name, int age, double salary, String workLocation, SalaryStatus status, LocalDate date) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public void setStatus(SalaryStatus status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
