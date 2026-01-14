package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import utilities.Validation;
import model.Task;

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

    public void displayTask(ArrayList<Task> allTask) {
        if (allTask.isEmpty()) {
            System.err.println("Not any task to display!");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        System.out.println("------------------------------------------------Task------------------------------------------------");
        System.out.printf(
                "%-5s%-20s%-10s%-15s%-15s%-15s%-15s%-15s%n",
                "ID", "Name", "Task", "Date", "From", "To", "Assignee", "Reviewer"
        );

        for (Task task : allTask) {
            System.out.printf(
                    "%-5d%-20s%-10s%-15s%-15s%-15s%-15s%-15s%n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskTypeID(),
                    sdf.format(task.getDate()),
                    task.getPlanFrom(),
                    task.getPlanTo(),
                    task.getAssignee(),
                    task.getReviewer()
            );
        }

    }
}
