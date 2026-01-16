package model;

import java.util.ArrayList;

/**
 *
 * @author IdeaPad
 */
public class AccountList {

    public ArrayList<Account> database() {
        ArrayList<Account> listAccount = new ArrayList<>();

        listAccount.add(new Account("0123456789", "123456ab"));
        listAccount.add(new Account("0814069335", "abcacong123"));
        
        return listAccount;
    }
}
