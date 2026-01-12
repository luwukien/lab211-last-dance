
import view.Display;
import controller.TaskControllers;
import java.util.ArrayList;
import model.Task;

/**
 *
 * @author IdeaPad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Task> allTask = new ArrayList<>();

        Display display = new Display();
        TaskControllers controller = new TaskControllers();

        while (true) {
            int choice = display.displayMenu();
            switch (choice) {
                case 1:
                    controller.addTask(allTask);
                    break;
                case 2:
                    controller.deleleTask(allTask);
                    break;
                case 3:
                    controller.showTask(allTask);
                    break;
                case 4:
                    return;
            }
        }

    }

}
