package view;

import model.CourseType;
import model.Student;
import utility.DataHelper;

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

        int choice = validation.checkInputLimitChoices("Enter your choice",1, 4);
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
        System.out.printf("%-10s%-25s%-10s%-25s", id, name, semester, courseType);
    }
}
