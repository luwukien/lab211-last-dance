package view;

import utility.DataHelper;

/**
 * @author Chi Kien-Luu | github/luwukien
 * Initialize Date: 19/01/2026
 */

public class Display {
    private final DataHelper validation = new DataHelper();

    public int displayMenu() {
        System.out.println("============== Student Management Program ==============");
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");

        int choice = validation.checkInputLimitChoices("Enter your choice",1, 4);
        return choice;
    }
}
