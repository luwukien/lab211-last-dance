package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Task;
import utilities.Validation;

/**
 *
 * @author IdeaPad
 */
public class TaskControllers {

    private final Validation validation = new Validation();
    
    public void addTask(ArrayList<Task> allTask) {
        int lastId = allTask.get(allTask.size() - 1).getId();
        
        System.out.println("--------------Add Task--------------");
        System.out.print("Requirement Name:");
        String name = validation.inputString();
        System.out.println("Task Type: ");
        String type = validation.inputTaskType();
        System.out.println("Date: ");
        Date date = validation.inputDate();
        System.out.println("From: ");
        String fromTime = validation.inputPlanTime();
        System.out.println("To: ");
        String endTime = validation.inputPlanTime();
        System.out.println("Assignee:");
        String assignee = validation.inputString();
        System.out.println("Reviewer: ");
        String reviewer = validation.inputString();
        
        allTask.add(new Task(lastId, type, name, date, fromTime, endTime, assignee, reviewer));
        System.out.println("Added task successfull!!!");
        
    }
}
