package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author IdeaPad
 */
public class Task {

    private int id;
    private String taskTypeID;
    private String requirementName;
    private Date date;
    private String planFrom;
    private String planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    /**
     *  Constructs a new Task with the specified details.
     * 
     * @param id the unique identifier of the task
     * @param taskTypeID the ID represent the category/type of the task
     * @param requirementName  the name of the requirement or task description 
     * @param date the scheduled date for the task
     * @param planFrom the starting time of the task (e.g., "9.5")
     * @param planTo the end time of the task (e.g., "10.5")
     * @param assignee the name of the person assigned to perform the task
     * @param reviewer the name of the person responsible for reviewing the task
     */
    public Task(int id, String taskTypeID, String requirementName, Date date, String planFrom, String planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(String taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", taskTypeID=" + taskTypeID + ", requirementName=" + requirementName
                + ", date=" + date + ", planFrom=" + planFrom + ", planTo=" + planTo + ", assignee=" + assignee + ", reviewer=" + reviewer + '}';
    }

    public void display() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        System.out.printf(
                "%-5s%-20s%-10s%-15s%-15s%-15s%-15s%-15s%n",
                "ID", "Name", "Task", "Date", "From", "To", "Assignee", "Reviewer"
        );

        System.out.printf(
                "%-5d%-20s%-10s%-15s%-15s%-15s%-15s%-15s%n",
                id,
                requirementName,
                taskTypeID,
                sdf.format(date),
                planFrom,
                planTo,
                assignee,
                reviewer
        );
    }
}
