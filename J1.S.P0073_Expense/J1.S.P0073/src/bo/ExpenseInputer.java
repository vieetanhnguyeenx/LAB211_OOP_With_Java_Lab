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
        expense.setId(-1);

        expense.setDate(Validation.getDateString("Enter Date: ",
                "Invalid input, input must be date with format dd-MM-yyyy!",
                "dd-MM-yyyy",
                "Invalid date format, input must be date with format dd-MM-yyyy!",
                Validation.DATE_PATTERN));

        expense.setAmount(Validation.getDouble("Enter Amount: ", 1, Double.MAX_VALUE));

        expense.setContent(Validation.getString("Enter Content: "));
    }

}
