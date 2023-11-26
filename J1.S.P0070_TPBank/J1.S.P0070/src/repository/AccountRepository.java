package repository;

import model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private List<Account> accountList;

    public AccountRepository() {
        accountList = new ArrayList<>();
        accountList.add(new Account("0123456789", "123456ab"));
        accountList.add(new Account("9999999999", "12345trewq"));
        accountList.add(new Account("8888888888", "qwert54321"));
    }

    public List<Account> getAccountList() {
        return accountList;
    }


}
