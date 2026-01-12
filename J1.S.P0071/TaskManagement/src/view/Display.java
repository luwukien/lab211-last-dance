package view;
import utilities.Validation;

/**
 *
 * @author IdeaPad
 */
public class Display {
    private final Validation validation = new Validation();
    public int displayMenu() {
        System.out.println("============== Task Program ==============");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
        int choice = validation.checkInputLimitChoices(1, 4);
        return choice;
    }
}
