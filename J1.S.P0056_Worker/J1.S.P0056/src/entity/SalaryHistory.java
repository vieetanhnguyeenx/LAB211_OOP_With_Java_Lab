package entity;

import utils.Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryHistory extends Worker{

    public enum SalaryStatus {
        UP,
        DOWN;
    }


    private SalaryStatus status;
    private double amount;
    private LocalDate date;

    public SalaryHistory(int id, String name, int age, double salary, String workLocation, SalaryStatus status, double amount, LocalDate date) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.amount = amount;
        this.date = date;
    }

    public SalaryHistory(Worker worker, SalaryStatus status, double amount, LocalDate date) {
        super(worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation());
        this.status = status;
        this.amount = amount;
        this.date = date;
    }

    public SalaryHistory() {

    }

    public void setBaseInfo(Worker worker) {
        setId(worker.getId());
        setName(worker.getName());
        setAge(worker.getAge());
        setSalary(worker.getSalary());
        setWorkLocation(worker.getWorkLocation());
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-10d%-15.1f%-12s%-20s\n",
                "W " + getId(),
                getName(),
                getAge(),
                getSalary(),
                status.toString(),
                date.format(DateTimeFormatter.ofPattern(Validation.DATE_PATTERN)));
    }
}
