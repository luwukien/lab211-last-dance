
import controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import model.Country;
import view.Menu;

public class Main {
    private final static Menu menu = new Menu();
    private final static ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
    
    public static void main(String[] args) {
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
