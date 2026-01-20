package controller;

import model.CourseType;
import model.Student;
import utility.DataHelper;
import utility.Validation;

import java.util.ArrayList;

/**
 * @author Chi Kien-Luu | github/luwukien
 * Initialize Date: 19/01/2026
 */

public class StudentController {
    private final DataHelper dataHelper = new DataHelper();
    private final Validation validation = new Validation();
    private final int LEAST_STUDENT_NUMBER = 10;

    /**
     *
     * @param listStudent
     * @return
     */
    public ArrayList<Student> createStudent(ArrayList<Student> listStudent) {
        while(true) {
            System.out.println("====== Create New Student ======");
            String id = dataHelper.inputString("Enter id:");
            String name = dataHelper.inputString("Enter student name: ");

            if (!validation.isNameMatchWithId(listStudent, id, name)) {
                System.err.println("The id exist in the list Student. Please input other id!!!");
                continue;
            }

            String semester = dataHelper.inputString("Enter semester: ");
            CourseType course = dataHelper.inputCourseName("Enter course: ");

            if (validation.isDuplicate(listStudent, id, name, semester, course)) {
                System.err.println("The student duplicated record. Please try again!!!");
                continue;
            }

            listStudent.add(new Student(id, name, semester, course));
            System.out.println("Added successfully the student");

            if (listStudent.size() >= LEAST_STUDENT_NUMBER) {
                boolean choice = dataHelper.getYesNoChoice("Do you want to continue (Y/N)?",
                        "You can only enter Y/y or N/n. Please try again!!!");
                if (!choice) {
                    break;
                }
            }
        }
        return listStudent;

    }
}
