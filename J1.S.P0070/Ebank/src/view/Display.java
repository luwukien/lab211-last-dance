package view;

import utilities.GetData;

/**
 *
 * @author IdeaPad
 */
public class Display {

    private final GetData dataInput = new GetData();

    public int displayMenu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        
        int choice = dataInput.checkInputLimitChoices("Input your choice: ", 1, 4);
        return choice;
    }
}
