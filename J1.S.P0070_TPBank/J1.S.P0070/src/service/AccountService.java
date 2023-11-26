package service;

import model.Account;
import repository.AccountRepository;
import util.Captcha;
import util.LanguageLabel;
import util.Validation;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class AccountService {
    public static final String VI_LANGUAGE = "vn";
    public static final String EN_LANGUAGE = "en";
    Locale locale;

    public AccountService() {
    }

    public void setLocate(String language) {
        locale = new Locale(language);
    }

    public void Login() {
        if (locale == null)
            setLocate(AccountService.EN_LANGUAGE);
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
        String generatedCaptcha = Captcha.generateCaptcha();
        System.out.println(bundle.getString(LanguageLabel.CAPTCHA) + " " + generatedCaptcha);

        Captcha.checkValidCaptcha(bundle.getString(LanguageLabel.INPUT_CAPTCHA),
                generatedCaptcha,
                bundle.getString(LanguageLabel.CAPTCHA_ERROR)
                );

        Account account = CheckAccount(accountNumber, password);
        if (account == null)
            System.out.println(bundle.getString(bundle.getString(LanguageLabel.LOGIN_FAIL)));
        else
            System.out.println(bundle.getString(bundle.getString(LanguageLabel.LOGIN_SUCCESS)));
    }

    private static Account CheckAccount(String accountNumber, String password) {
        AccountRepository accountRepository = new AccountRepository();
        List<Account> accountList = accountRepository.getAccountList();
        if (accountList.isEmpty())
            return null;
        // Loop to access each element of account list
        for (Account acc: accountList) {
            // Check is account number exits or not
            if (acc.getAccountNumber().equals(accountNumber)) {

                // Check is correct or not
                if (acc.getPassword().equals(password))
                    return acc;
                return null;
            }
        }

        return null;
    }
}
