package bo;

import entity.Account;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accounts;

    public AccountManager() {
        accounts = new ArrayList<>();
        accounts.add(new Account("0123456789", "123456ab"));
        accounts.add(new Account("9999999999", "12345trewq"));
        accounts.add(new Account("8888888888", "qwert54321"));
    }

    public Account verifyAccount(Account account) {
        if (accounts.isEmpty())
            return null;
        // Loop to access each element of account list
        for (Account acc: accounts) {
            // Check is account number exits or not
            if (acc.getAccountNumber().equals(account.getAccountNumber())) {

                // Check is correct or not
                if (acc.getPassword().equals(account.getPassword()))
                    return acc;
                return null;
            }
        }

        return null;
    }

}
