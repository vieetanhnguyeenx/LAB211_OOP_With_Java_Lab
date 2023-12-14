package controller;

import bo.ExpenseInputer;
import bo.ExpenseManager;
import entity.Expense;

public class ExpenseManageController {
    private ExpenseInputer expenseInputer;
    private ExpenseManager expenseManager;

    public ExpenseManageController() {
        expenseManager = new ExpenseManager();
    }

    public Expense addExpense() throws Exception {
        expenseInputer = new ExpenseInputer();
        expenseInputer.inputExpense();
        Expense expense = expenseInputer.getExpense();
        if (expenseManager.addExpense(expense))
            return expense;

        throw new Exception("Add an expense fail!");
    }

    public String getDisplayedExpense() {
        //%-5d%-20s%-20.1f%-20s
        String s = String.format("%-5s%-20s%-20s%-20s\n",
                "ID",
                "Date",
                "Amount",
                "Content");

        s += expenseManager.toString();

        return s;
    }

    public Expense deleteExpense() throws Exception {
        expenseInputer = new ExpenseInputer();
        expenseInputer.inputExpenseDelete();
        Expense expense = expenseInputer.getExpense();
        return expenseManager.deleteExpense(expense.getId());
    }
}
