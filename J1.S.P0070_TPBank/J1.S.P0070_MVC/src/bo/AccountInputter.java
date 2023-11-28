package bo;

import controller.AccountManagerController;
import entity.Account;
import utils.LanguageLabel;
import utils.Validation;

import java.util.Locale;
import java.util.ResourceBundle;

public class AccountInputter {
    private Account account;
    private Locale locale;

    public AccountInputter(String language) {
        locale = new Locale(language);
        account = new Account();
    }


    public Account getAccountLogin() {
        if (locale == null)
            locale = new Locale(AccountManagerController.EN_LANGUAGE);
        ResourceBundle bundle = ResourceBundle.getBundle("language", locale);

        String accountNumber = Validation.getString(bundle.getString(LanguageLabel.ACCOUNT_NUMBER),
                bundle.getString(LanguageLabel.INPUT_ACCOUNT_ERROR),
                bundle.getString(LanguageLabel.INPUT_ACCOUNT_ERROR),
                Validation.ACCOUNT_NUMBER_PATTERN,
                bundle.getString(LanguageLabel.INPUT_ACCOUNT_ERROR)
        );

        String password = Validation.getString(bundle.getString(LanguageLabel.PASSWORD),
                bundle.getString(LanguageLabel.INPUT_PASSWORD_ERROR),
                bundle.getString(LanguageLabel.INPUT_PASSWORD_ERROR),
                Validation.PASSWORD_PATTERN,
                bundle.getString(LanguageLabel.INPUT_PASSWORD_ERROR)
        );

        return new Account(accountNumber, password);
    }
}
