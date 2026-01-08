package view;
import utilities.Validation;
/**
 *
 * @author IdeaPad
 */
public class Menu {
    private final Validation validation = new Validation();
    
    public int displayMenu() {
        System.out.println("1. Enter the information for 11 countries in Southeast Asia.");
        System.out.println("2. Display already information.");
        System.out.println("3. Search the country according to the entered country's name.");
        System.out.println("4. Display the information increasing with the country name.");
        System.out.println("5. Exit.");
        System.out.println("Please input your choice(1-5): ");
        
        int choice = validation.checkInputLimitChoices(1, 5);
        return choice;
    }
}
