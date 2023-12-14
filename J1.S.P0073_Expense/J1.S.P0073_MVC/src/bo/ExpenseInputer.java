package bo;

import entity.Expense;
import utils.Validation;

public class ExpenseInputer {
    private Expense expense;

    public ExpenseInputer() {
        expense = new Expense();
    }

    public Expense getExpense() {
        return expense;
    }

    public void inputExpense() {
        expense.setDate(Validation.getDateString("Enter Date: ",
                "Invalid input, input must be date with format dd/MM/yyyy",
                Validation.DATE_PATTERN_IN,
                "Invalid input, input must be date with format dd/MM/yyyy",
                Validation.DATE_PATTERN_OUT));

        expense.setAmount(Validation.getDouble("Enter Amount: ",
                0.001,
                Double.MAX_VALUE));

        expense.setContent(Validation.getString("Enter Content: "));
    }

    public void inputExpenseDelete() {
        expense.setId(Validation.getInt("Enter ID: ",
                1,
                Integer.MAX_VALUE));
    }
}
