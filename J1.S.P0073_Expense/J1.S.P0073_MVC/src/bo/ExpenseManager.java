package bo;

import entity.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;
    private int lastId;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        lastId = 0;
    }

    public boolean addExpense(Expense expense) throws Exception {
        if (expense == null)
            throw new Exception("Data can not be null or empty");
        expense.setId(++lastId);

        return expenses.add(expense);
    }

    private int getIndexById(int id) {
        for (int index = 0; index < expenses.size(); index++) {
            if (expenses.get(index).getId() == id)
                return index;
        }

        return -1;
    }

    public Expense deleteExpense(int id) throws Exception {
        int index = getIndexById(id);

        if (index == -1)
            throw new Exception("Delete an expense fail");

        return expenses.remove(index);
    }

    @Override
    public String toString() {
        String s = "";
        double total = 0;
        for(Expense expense : expenses) {
            s += expense;
            total += expense.getAmount();
        }

        s += "Total: " + total + "\n";

        return s;
    }
}
