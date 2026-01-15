package controller;

import java.util.ArrayList;
import java.util.Locale;
import utilities.GetData;
import utilities.HandleCaptcha;
import utilities.Validation;
import java.util.ResourceBundle;
import model.Account;

/**
 *
 * @author IdeaPad
 */
public class LoginSystem {

    private final Validation validation = new Validation();
    private final GetData getData = new GetData();
    private final HandleCaptcha handle = new HandleCaptcha();

    public void VietnamSystem(ArrayList<Account> listAccount) {
        Locale Vietnam = new Locale("vi", "VN");
        loginSystem(Vietnam, listAccount);
    }

    public void EnglishSystem(ArrayList<Account> listAccount) {
        Locale Engligh = new Locale("en", "UK");
        loginSystem(Engligh, listAccount);
    }

    /**
     *
     * @param locale
     * @param listAccount
     * @return
     */
    public String loginSystem(Locale locale, ArrayList<Account> listAccount) {
        String result = null;

        ResourceBundle handleLanguage = ResourceBundle.getBundle("language", locale);
        String accountNumber = getData.getAccountNumber(handleLanguage.getString("accountNumber"),
                handleLanguage.getString("inputAccountError"));
        String password = getData.getPassword(handleLanguage.getString("password"),
                handleLanguage.getString("inputPasswordError"));

        while (true) {
            String captchaGenerated = handle.generateCaptcha();

            String captchaInput = handle.getCaptcha(handleLanguage.getString("captcha"),
                    handleLanguage.getString("inputCaptcha"),
                    handleLanguage.getString("captchaError"));

            if (handle.checkCaptcha(captchaInput, captchaGenerated)) {
                if (validation.checkAccountNumber(listAccount, accountNumber)
                        && validation.checkPassword(listAccount, accountNumber, password)) {
                    System.out.println(handleLanguage.getString("loginSuccess"));
                    result = accountNumber;
                    break;
                } else {
                    System.out.println(handleLanguage.getString("loginFail"));
                }
            } else {
                System.out.println(handleLanguage.getString("captchaError"));
            }
        }

        return result;
    }

}
