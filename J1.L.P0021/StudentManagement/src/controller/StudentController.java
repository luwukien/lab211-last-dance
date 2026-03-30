package controller;

import model.CourseType;
import model.Student;
import model.StudentServices;
import utility.DataHelper;
import view.Display;

import java.util.ArrayList;
/**
 * @author Chi Kien Luu | github.com/luwukien
 * Initialize Date: 19/01/2026
 */

public class StudentController {
    private final Display display = new Display();
    private ArrayList<Student> listStudent = new ArrayList<>();
    private final DataHelper dataHelper = new DataHelper();
    private final StudentServices studentServices = new StudentServices(listStudent);
    private final int LEAST_STUDENT_NUMBER = 3;
    private int FIRST_INDEX_STUDENT = 1;

    public StudentController(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public void run() {
        while (true) {
            int choice = display.displayMenu();
            switch (choice) {
                case 1:
                    handleCreateStudent();
                    break;
                case 2:
                    findStudent();
                    break;
                case 3:
                    updateDeleteStudent(listStudent);
                    break;
                case 4:
                    display.displayReport(studentServices.generateReport(listStudent));
                    break;
                case 5:
                    System.out.println("Good bye! See you again!");
                    return;
            }
        }
    }

    public void handleCreateStudent() {
        while (true) {
            display.displayCreateHeader(FIRST_INDEX_STUDENT);
            String id = dataHelper.inputString("Enter id:");

            Student existingStudent = studentServices.findStudentById(listStudent, id);
            String name;
            if (existingStudent != null) {
                name = existingStudent.getStudentName();
                System.out.println("Student ID exists. System automatically retrieved name: " + name);
            } else {
                name = dataHelper.inputString("Enter student name: ");
            }

            String semester = dataHelper.inputString("Enter semester: ");
            CourseType course = dataHelper.inputCourseName("Enter course: ");
            if (studentServices.addStudent(id, name, semester, course)) {
                studentServices.saveStudent(new Student(id, name, semester, course));
                System.out.println("Added successfully the student");
                FIRST_INDEX_STUDENT++;

                if (listStudent.size() >= LEAST_STUDENT_NUMBER) {
                    boolean choice = dataHelper.getYesNoChoice("Do you want to continue (Y/N)?",
                            "You can only enter Y/y or N/n. Please try again!!!");
                    if (!choice) {
                        break;
                    }
                }
            } else {
                System.out.println("The student duplicated record. Please try again!!!");
            }
        }
    }

    /**
     * The UI which user interact
     *
     */
    public void findStudent() {
        ArrayList<Student> foundStudents = new ArrayList<>();

        if (listStudent == null || listStudent.isEmpty()) {
            System.out.println("List student is empty. Cannot find!!!");
        } else {
            String name = dataHelper.inputString("Enter the name student who you want to find: ");
            foundStudents = studentServices.findStudentByName(name.toLowerCase());

            if (foundStudents.isEmpty()) {
                System.out.println("No student found");
            } else {
                display.displaySortedStudentByName(foundStudents);
            }
        }

    }

    /**
     * This method helps update the information of student: name, semester, course
     *
     * @return Student with new information updated
     */
    public Student updateStudent(Student student) {
        String name = dataHelper.inputString("New Name: ");
        String semester = dataHelper.inputString("New Semester: ");
        CourseType courseName = dataHelper.inputCourseName("New Course: ");
        studentServices.updateStudentInfo(student, name, semester, courseName);
        System.out.println("Update successfully the student!!!");
        return student;
    }

    /**
     * This method helps hard delete from the list student
     *
     * @return Student who was deleted from the list student
     */
    public Student deleteStudent(Student studentToDelete) {
        studentServices.deleteStudent(studentToDelete);
        System.out.println("Delete successfully the student!!!");
        return studentToDelete;
    }

    /**
     * The UI which user interact
     *
     * @param listStudent a list valid student
     * @return student who was deleted or updated
     */
    public Student updateDeleteStudent(ArrayList<Student> listStudent) {
        Student result = null;

        if (listStudent.isEmpty()) {
            System.out.println("List is empty. Nothing to update or delete!");
        } else {
            String studentId = dataHelper.inputString("Input student ID: ");
            ArrayList<Student> listFound = studentServices.findListStudentById(studentId);

            if (listFound.isEmpty()) {
                System.out.println("Not found any student has " + studentId);
            } else {
                Student studentToProcess = listFound.getFirst();

                if (listFound.size() > 1) {
                    display.displayAllRecordsOfStudent(listFound);

                    int index = dataHelper.checkInputLimitChoices("Choose record to process: ",
                            1, listFound.size());
                    studentToProcess = listFound.get(index - 1);
                }

//            Getting choice from user. True: Update; False: Delete
                boolean isUpdate = dataHelper.getUpdateDelete("Do you want to update (U) or delete (D) this student",
                        "You can only select U/u to update or D/d to delete!!!.");
                if (isUpdate) {
                    display.displayUpdateHeader();
                    result = updateStudent(studentToProcess);
                } else {
                    display.displayDeleteHeader();
                    result = deleteStudent(studentToProcess);
                }
            }
        }
        return result;
    }

}
