package controller;

import bo.ExpenseInputer;
import bo.ExpenseManager;
import entity.Expense;
import exception.ExpenseNotFoundException;
import utils.Validation;

public class ExpenseManageController {
    private ExpenseManager expenseManager;
    private ExpenseInputer expenseInputer;

    public ExpenseManageController() {
        expenseManager = new ExpenseManager();
    }

    public Expense addExpense() {
        expenseInputer = new ExpenseInputer();
        expenseInputer.inputExpense();
        Expense expense = expenseInputer.getExpense();
        expenseManager.addExpense(expense);
        return expense;
    }

    public Expense deleteExpense() throws ExpenseNotFoundException {
        System.out.println("----------- Delete an expense -----------");
        int id = Validation.getInt("Enter ID: ");
        return expenseManager.deleteExpenseById(id);
    }

    public String getExpensesDisplayed() {
        String s = "---------------------- Display all expenses ----------------------\n";
        s+= expenseManager;
        return s;
    }
}
