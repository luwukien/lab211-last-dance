package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import utilities.DataHelper;
import model.Task;

/**
 *
 * @author IdeaPad
 */
public class Display {

    private final DataHelper dataHelper = new DataHelper();

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

    /**
     * this method helps show all task which has the list task
     *
     * @param allTask the list task in array task
     */
    public void showTask(ArrayList<Task> allTask) {
        displayTask(allTask);
    }
}
