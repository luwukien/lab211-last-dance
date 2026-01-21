package controller;

import model.CourseType;
import model.Student;
import utility.DataHelper;
import utility.Validation;
import view.Display;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Chi Kien-Luu | github/luwukien
 * Initialize Date: 19/01/2026
 */

public class StudentController {
    private final DataHelper dataHelper = new DataHelper();
    private final Validation validation = new Validation();
    private final Display display = new Display();
    private final int LEAST_STUDENT_NUMBER = 10;

    /**
     * Create a valid student and then add list Student. Create at least 10 student
     *
     * @param listStudent a list valid student
     * @return creat at least 10 valid student
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

    /**
     *  sort student by name ascending
     *
     * @param listStudent a list valid student
     */
    public ArrayList<Student> sortStudentByName(ArrayList<Student> listStudent) {
        Collections.sort(listStudent, Comparator.comparing(Student::getStudentName));
        return listStudent;
    }

    /**
     *  The logic find student by name
     *
     * @param listStudent a list valid student
     * @param name the name student who user want to find
     * @return a list student name contain name student who user want to find
     */
    public ArrayList<Student> findStudentByName(ArrayList<Student> listStudent, String name) {
        ArrayList<Student> foundStudent = new ArrayList<>();
        if (listStudent != null && !listStudent.isEmpty()) {
            for (Student student : listStudent) {
                if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                    foundStudent.add(student);
                }
            }
        }

        if (!foundStudent.isEmpty()) {
            foundStudent = sortStudentByName(foundStudent);
        }
        return foundStudent;
    }

    /**
     *  The UI which user interact
     *
     * @param listStudent a list valid student
     * @return a list sorted student and some information related to
     */
    public ArrayList<Student> findStudent(ArrayList<Student> listStudent) {
        ArrayList<Student> result = new ArrayList<>();

        if (listStudent == null || listStudent.isEmpty()) {
            System.err.println("List student is empty. Cannot find!!!");
        } else  {
            String name = dataHelper.inputString("Enter the name student who you want to find: ");
            result = findStudentByName(listStudent, name.toLowerCase());

            if (result.isEmpty()) {
                System.out.println("No student found");
            } else {
                System.out.printf("%-10s%-25s%-10s%-25s", "ID", "Name", "Semester", "Course");
                for (Student student : result) display.displayStudent(student);
            }
        }
        return result;

    }
}
