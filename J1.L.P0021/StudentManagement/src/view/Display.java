package view;

import controller.StudentController;
import model.CourseType;
import model.Student;
import utility.DataHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Chi Kien-Luu | github/luwukien
 * Initialize Date: 19/01/2026
 */

public class Display {
    private final DataHelper validation = new DataHelper();

    public int displayMenu() {
        System.out.println("============== Student Management Program ==============");
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");

        int choice = validation.checkInputLimitChoices("Enter your choice: ",1, 5);
        return choice;
    }

    /**
     *
     * @param student
     */
    public void displayStudent(Student student) {
        String id = student.getId();
        String name = student.getStudentName();
        CourseType courseType = student.getCourseName();
        String semester = student.getSemester();
        System.out.printf("%-10s%-25s%-10s%-25s\n", id, name, semester, courseType);
    }

    public void displayHeader() {
        System.out.printf("%-10s%-25s%-10s%-25s\n", "ID", "Name", "Semester", "Course");
    }

    public void displayCreateHeader(int countStudent) {
        System.out.println("============ Create New Student "+ countStudent + "============ ");
    }

    public void displayDeleteHeader() {
        System.out.println("============ Delete Student ============\n");
    }

    public void displayUpdateHeader() {
        System.out.println("============ Update New Student ============\n");
    }

    public void displayReportHeader() {
        System.out.println("============ Report Student ============\n");
    }

    public void displaySortedStudentByName(ArrayList<Student> listStudent, StudentController studentController) {
        System.out.println("============ The sorted list Student ============\n");
        displayHeader();
        for (Student student : studentController.sortStudentByName(listStudent)) {
            displayStudent(student);
        }
    }

    public void displayAllRecordsOfStudent(ArrayList<Student> foundList) {
        System.out.println("============ The found list Student ============\n");
        System.out.printf("%-5s%-20s%-10s\n", "No", "Name", "Course");
        int countStudent = 0;
        for (Student student : foundList) {
            countStudent++;
            String name = student.getStudentName();
            CourseType courseType = student.getCourseName();
            System.out.printf("%-5s%-20s%-10s\n", countStudent, name, courseType);
        }
    }

    /**
     *
     * @param reportMap
     */
    public void displayReport(HashMap<String, Integer> reportMap) {
        if (reportMap == null) {
            System.err.println("List is empty. Nothing to report!!!");
            return;
        }

        displayReportHeader();
        for (String key : reportMap.keySet()) {
            String[] fullKey = key.split("\\|");
            String name = fullKey[0];
            String course = fullKey[1];
            int total = reportMap.get(key);

            System.out.printf("%-20s | %-10s | %-5d\n", name, course, total);
        }
    }
}
