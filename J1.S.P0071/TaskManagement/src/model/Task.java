package model;

import java.util.Date;

/**
 *
 * @author IdeaPad
 */
public class Task {
    private String id;
    private String taskTypeID;
    private String requirementName;
    private Date date;
    private String planFrom;
    private String planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(String id, String taskTypeID, String requirementName, Date date, String planFrom, String planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "Task{" + "id=" + id + ", taskTypeID=" + taskTypeID + ", requirementName=" +
                requirementName + ", date=" + date + ", planFrom=" + planFrom +
                ", planTo=" + planTo + ", assignee=" + assignee + ", reviewer=" + reviewer + '}';
    }
    
    
}
