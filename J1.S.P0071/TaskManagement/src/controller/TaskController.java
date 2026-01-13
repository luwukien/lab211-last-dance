package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import model.Task;
import utilities.Validation;

/**
 *
 * @author IdeaPad
 */
public class TaskController {

    private final Validation validation = new Validation();

    /**
     * this methods help add to a task into list task
     * 
     * @param allTask the list task in array task
     * @return the id associated a task which just added.
     */
    public int addTask(ArrayList<Task> allTask) {
        int currentId = 1;
        if (allTask.isEmpty()) {
            currentId = 1;
        } else {
            currentId = allTask.get(allTask.size() - 1).getId() + 1;
        }

        System.out.println("--------------Add Task--------------");
        System.out.print("Requirement Name: ");
        String name = validation.inputString();
        System.out.print("Task Type: ");
        String type = validation.inputTaskType();
        System.out.print("Date: ");
        Date date = validation.inputDate();
        System.out.print("From: ");
        String fromTime = validation.inputPlanTime();
        System.out.print("To: ");
        String endTime = "";
        while (true) {
            endTime = validation.inputPlanTime();
            
            if (Double.parseDouble(endTime) >= Double.parseDouble(fromTime)) {
                break;
            }
            System.out.print("Please input endTime > fromTime. Try again: ");
        }
        
        System.out.print("Assignee: ");
        String assignee = validation.inputString();
        System.out.print("Reviewer: ");
        String reviewer = validation.inputString();

        allTask.add(new Task(currentId, type, name, date, fromTime, endTime, assignee, reviewer));
        System.out.println("Added task successfull with the ID " + currentId);
        
        return currentId;
    }

    /**
     * this methods helps delete a task in list tasks
     * 
     * @param allTask the list task in array task
     */
    public void deleleTask(ArrayList<Task> allTask) {

        System.out.println("-------------Delete Task--------------");
        System.out.print("ID: ");
        int id = validation.inputInt();

        Iterator<Task> it = allTask.iterator();
        while (it.hasNext()) {
            Task task = it.next();
            if (task.getId() == id) {
                it.remove();
                System.out.println("Deleted task id " + id + " successful!!!");
                return;
            }
        }
        System.out.println("Not exist any id in DB. Try again");

    }

    /**
     * this method helps show all task which has the list task
     * 
     * @param allTask the list task in array task
     */
    public void showTask(ArrayList<Task> allTask) {
        System.out.println("------------------------------------------------Task------------------------------------------------");
        for (Task task : allTask) {
            task.display();
        }
    }
}
