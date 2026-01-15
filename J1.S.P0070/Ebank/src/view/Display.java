package view;

import utilities.Validation;

/**
 *
 * @author IdeaPad
 */
public class Display {

    private final Validation validation = new Validation();

    public int displayMenu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        
        int choice = validation.checkInputLimitChoices("Input your choice: ", 1, 4);
        return choice;
    }
}
