package controller;

import bo.AccountInputter;
import bo.AccountManager;
import bo.CaptchaInputter;
import entity.Account;
import utils.LanguageLabel;

import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class AccountManagerController {
    public static final String VI_LANGUAGE = "vn";
    public static final String EN_LANGUAGE = "en";
    private AccountInputter accountInputter;
    private AccountManager accountManager;
    private CaptchaInputter captchaInputter;

    public AccountManagerController() {
        accountManager = new AccountManager();

    }

    public void login(String language) {
        Locale locale = new Locale(language);
        ResourceBundle bundle = ResourceBundle.getBundle("language", locale);
        accountInputter = new AccountInputter(language);
        Account account = accountInputter.getAccountLogin();

        captchaInputter = new CaptchaInputter();
        String captcha = captchaInputter.generateCaptcha();
        System.out.println(bundle.getString(LanguageLabel.CAPTCHA) + " " + captcha);
        captchaInputter.verifyCaptcha(bundle.getString(LanguageLabel.INPUT_CAPTCHA), captcha, bundle.getString(LanguageLabel.CAPTCHA_ERROR));

        Account verifiedAccount = accountManager.verifyAccount(account);

        if (verifiedAccount == null)
            System.out.println(bundle.getString(LanguageLabel.LOGIN_FAIL));
        else
            System.out.println(bundle.getString(LanguageLabel.LOGIN_SUCCESS));
    }


}
