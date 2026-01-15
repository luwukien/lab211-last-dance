
import java.util.ArrayList;
import model.Account;
import model.AccountList;
import view.Display;
import controller.LoginSystem;

/**
 *
 * @author IdeaPad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccountList list = new AccountList();
        ArrayList<Account> listAccount = list.database();
        Display display = new Display();
        LoginSystem controller = new LoginSystem();

        while (true) {
            int choice = display.displayMenu();

            switch (choice) {
                case 1:
                    controller.VietnamSystem(listAccount);
                    break;
                case 2:
                    controller.EnglishSystem(listAccount);
                    break;
                case 3:
                    return;
            }
        }
    }

}
