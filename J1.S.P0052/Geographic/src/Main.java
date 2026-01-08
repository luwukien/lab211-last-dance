
import controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import model.Country;
import view.Menu;

public class Main {

    
    public static void main(String[] args) {
        Menu menu = new Menu();
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        
        ArrayList<Country> lc = new ArrayList<>();
        while (true) {
            int choice = menu.displayMenu();
            switch (choice) {
                case 1:
                    manager.inputCountry(lc);
                    break;
                case 2:
                    manager.displayLastCountry(lc);
                    break;
                case 3:
                    manager.displaySearchCountry(lc);
                    break;
                case 4:
                    manager.displaySortedCountry(lc);
                    break;
                case 5:
                    return;
            }
        }

    }

}
