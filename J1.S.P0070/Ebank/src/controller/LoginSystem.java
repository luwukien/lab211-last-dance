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
    private final GetData dataInput = new GetData();
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
     *  Performs user login with Captcha verification and localization support
     * 
     * @param locale The locale for language setting (ResourseBundle)
     * @param listAccount The list of valid accounts for credential validation 
     * @return the account number if login successful, otherwise null
     */
    public String loginSystem(Locale locale, ArrayList<Account> listAccount) {
        String result = null;

        while (true) {
            ResourceBundle handleLanguage = ResourceBundle.getBundle("language", locale);
            String accountNumber = dataInput.getAccountNumber(handleLanguage.getString("accountNumber"),
                    handleLanguage.getString("inputAccountError"));
            String password = dataInput.getPassword(handleLanguage.getString("password"),
                    handleLanguage.getString("inputPasswordError"));

            while (true) {
                String captchaGenerated = handle.generateCaptcha();

                String captchaInput = handle.getCaptcha(captchaGenerated,
                        handleLanguage.getString("captcha"),
                        handleLanguage.getString("inputCaptcha"),
                        handleLanguage.getString("captchaInputEmpty"));

                if (handle.checkCaptcha(captchaInput.trim(), captchaGenerated.trim())) {
                    System.out.println(handleLanguage.getString("captchaValid"));
                    break;
                } else {
                    System.out.println(handleLanguage.getString("captchaError"));
                }
            }

            if (validation.checkAccountNumber(listAccount, accountNumber)
                    && validation.checkPassword(listAccount, accountNumber, password)) {
                System.out.println(handleLanguage.getString("loginSuccess"));
                result = accountNumber;
                break;
            } else {
                System.out.println(handleLanguage.getString("loginFail"));
            }
        }
        return result;

    }
}
