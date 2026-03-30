
import view.Display;
import controller.TaskController;
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
        TaskController controller = new TaskController(allTask);

        controller.run();
    }

}
