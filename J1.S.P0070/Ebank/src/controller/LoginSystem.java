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
    
    
    public void VietnamSystem() {
        Locale Vietnam = new Locale("vi", "VN");
        loginSystem(Vietnam);
    }
    
    public void EnglishSystem() {
        Locale America  = new Locale("en", "US");
        loginSystem(America);
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
        String captcha = handle.getCaptcha(handleLanguage.getString("captcha"),
                handleLanguage.getString("inputCaptcha"), 
                handleLanguage.getString("captchaError"));
        
        boolean checkExistAccountNumber = validation.checkAccountNumber(listAccount, accountNumber);
        boolean checkPassword = validation.checkPassword(listAccount, accountNumber, password);
        boolean checkCaptcha = handle.checkCaptcha(captcha);
        
        if (checkExistAccountNumber && checkPassword && checkCaptcha) {
            System.out.println("");
            result = accountNumber;
        }
        return result;
    }
    
    
}
