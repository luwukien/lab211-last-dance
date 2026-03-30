package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import model.Task;
import model.TaskService;
import utilities.DataHelper;
import view.Display;

/**
 *
 * @author IdeaPad
 */
public class TaskController {

    private ArrayList<Task> allTask;
    private final Display display = new Display();
    private final DataHelper dataHelper = new DataHelper();
    private final TaskService taskService;


    public TaskController(ArrayList<Task> allTask) {
        this.allTask = allTask;
        this.taskService = new TaskService(allTask);
    }

    public void run() {
        while (true) {
            int choice = dataHelper.getChoiceMenu();
            switch (choice) {
                case 1:
                    handleAddTask();
                    break;
                case 2:
                    handleDeleteTask();
                    break;
                case 3:
                    display.showTask(allTask);
                    break;
                case 4:
                    return;
            }
        }
    }
    
    /**
     * this methods help add to a task into list task
     * 
     */
    public void handleAddTask() {
        System.out.println("--------------Add Task--------------");
        int currentId = taskService.getIndexTaskID();
        System.out.print("Requirement Name: ");
        String name = dataHelper.inputString();
        System.out.print("Task Type: ");
        String type = dataHelper.inputTaskType();
        System.out.print("Date: ");
        Date date = dataHelper.inputDate();
        System.out.print("From: ");
        String fromTime = dataHelper.inputPlanTime();
        System.out.print("To: ");
        String endTime = dataHelper.inputEndPlanTime(fromTime);
        System.out.print("Assignee: ");
        String assignee = dataHelper.inputString();
        System.out.print("Reviewer: ");
        String reviewer = dataHelper.inputString();
        taskService.addTask(currentId, type, name, date, fromTime, endTime, assignee, reviewer);
        System.out.println("Added task successfull with the ID " + currentId);
    }

    public void handleDeleteTask() {
        System.out.println("-------------Delete Task--------------");
        System.out.print("ID: ");
        int id = dataHelper.inputInt();

        boolean isDeleted = taskService.deleleTask(id);
        if (isDeleted) {
            System.out.println("Deleted task id " + id + " successful!!!");
        } else {
            System.out.println("Not exist any id in DB. Try again");
        }
    }
}
