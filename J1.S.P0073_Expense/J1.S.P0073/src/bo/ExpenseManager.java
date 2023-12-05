package bo;

import entity.Expense;
import exception.ExpenseNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;
    private int lastId;
    private double totalAmount;

    public ExpenseManager() {
        expenses = new ArrayList<>();
        lastId = 0;
        totalAmount = 0;
    }

    public boolean addExpense(Expense expense) {
        expense.setId(++lastId);
        totalAmount += expense.getAmount();
        return expenses.add(expense);
    }

    private int searchById(int id) {
        for (int index = 0; index < expenses.size(); index++) {
            if (expenses.get(index).getId() == id)
                return index;
        }

        return -1;
    }

    public Expense deleteExpenseById(int id) throws ExpenseNotFoundException {
        int index = searchById(id);
        if (index != -1) {
            totalAmount -= expenses.get(index).getAmount();
            return expenses.remove(index);
        }


        throw new ExpenseNotFoundException("Expense dose not exits");
    }

    @Override
    public String toString() {
        String s = String.format("%-10s%-25s%-15s%-25s\n",
                "ID",
                "Date",
                "Amount",
                "Content");
        for (Expense expense : expenses) {
            s+= expense;
        }

        s+="         Total: " + totalAmount + "         \n";

        return s;
    }
}
