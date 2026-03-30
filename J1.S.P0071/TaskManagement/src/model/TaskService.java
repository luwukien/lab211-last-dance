package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class TaskService {
    private ArrayList<Task> allTask;
    private static final int STARTING_ID = 1;
    private static final int ID_STEP = 1;

    public TaskService(ArrayList<Task> allTask) {
        this.allTask = allTask;
    }

    /**
     * This method helps check id task is exist in list
     *
     * @param id id task
     * @return
     */
    private boolean checkExistIdTask(int id) {
        boolean isExsit = false;

        for (Task task : allTask) {
            if (task.getId() == id) {
                isExsit = true;
                break;
            }
        }
        return isExsit;
    }

    public void addTask(int currentId, String type, String name, Date date,
                        String fromTime, String endTime, String assignee,String reviewer) {
        this.allTask.add(new Task(currentId, type, name, date, fromTime, endTime, assignee, reviewer));
    }

    public int getIndexTaskID() {
        int currentId;
        if (allTask.isEmpty()) {
            currentId = STARTING_ID;
        } else {
            currentId = allTask.get(allTask.size() - 1).getId() + ID_STEP;
        }
        return currentId;
    }

    /**
     *  methods helps delete a task in list tasks
     *
     */
    public boolean deleleTask(int id) {
        boolean result = false;
        Iterator<Task> it = allTask.iterator();
        while (it.hasNext()) {
            Task task = it.next();
            if (task.getId() == id) {
                it.remove();
                result = true;
            }
        }
        return result;
    }

}
