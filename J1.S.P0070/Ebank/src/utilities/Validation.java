package utilities;

import java.util.ArrayList;
import model.Account;

/**
 *
 * @author IdeaPad
 */
public class Validation {
    
    /**
     * check exist a account number 
     * 
     * @param listAccount The list of valid accounts for credential validation 
     * @param accountNumber a string account number by user input
     * @return true if a account number matches with any listAccount, otherwise false
     */
    public boolean checkAccountNumber(ArrayList<Account> listAccount, String accountNumber) {
        
        if (listAccount.isEmpty()) {
            return false;
        }
        
        for (Account account : listAccount) {
            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * check a account matches password and accountNumber
     * 
     * @param listAccount The list of valid accounts for credential validation 
     * @param accountNumber a string account number by user input
     * @param password a string password by user input
     * @return true if a account matches the password, and accountNumber and exist in listAccount
     */
    public boolean checkPassword(ArrayList<Account> listAccount, String accountNumber, String password) {
        if (listAccount.isEmpty()) {
            return false;
        }
        
        for (Account account : listAccount) {
            if (account.getAccountNumber().equals(accountNumber) && 
                    account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    } 
}
