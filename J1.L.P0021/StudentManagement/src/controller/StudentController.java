package controller;

import model.CourseType;
import model.Student;
import utility.DataHelper;
import utility.Validation;
import view.Display;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Chi Kien-Luu | github/luwukien
 * Initialize Date: 19/01/2026
 */

public class StudentController {
    private final DataHelper dataHelper = new DataHelper();
    private final Validation validation = new Validation();
    private final int LEAST_STUDENT_NUMBER = 3;
    private int FIRST_INDEX_STUDENT = 1;

    /**
     * Create a valid student and then add list Student. Create at least 10 student
     *
     * @param listStudent a list valid student
     * @return creat at least 10 valid student
     */
    public ArrayList<Student> createStudent(ArrayList<Student> listStudent, Display display) {
        while(true) {
            display.displayCreateHeader(FIRST_INDEX_STUDENT);
            String id = dataHelper.inputString("Enter id:");

            Student existingStudent = findStudentById(listStudent, id);
            String name;

            if (existingStudent != null) {
                name = existingStudent.getStudentName();
                System.out.println("Student ID exists. System automatically retrieved name: " + name);
            } else {
                name = dataHelper.inputString("Enter student name: ");
            }

            String semester = dataHelper.inputString("Enter semester: ");
            CourseType course = dataHelper.inputCourseName("Enter course: ");

            if (validation.isDuplicate(listStudent, id, name, semester, course)) {
                System.err.println("The student duplicated record. Please try again!!!");
                continue;
            }

            listStudent.add(new Student(id, name, semester, course));
            System.out.println("Added successfully the student");
            FIRST_INDEX_STUDENT++;

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
    public ArrayList<Student> findStudent(ArrayList<Student> listStudent, Display display) {
        ArrayList<Student> result = new ArrayList<>();

        if (listStudent == null || listStudent.isEmpty()) {
            System.err.println("List student is empty. Cannot find!!!");
        } else  {
            String name = dataHelper.inputString("Enter the name student who you want to find: ");
            result = findStudentByName(listStudent, name.toLowerCase());

            if (result.isEmpty()) {
                System.out.println("No student found");
            }
        }
        return result;

    }

    /**
     *
     *
     * @param listStudent
     * @param studentId
     * @return
     */
    public Student findStudentById(ArrayList<Student> listStudent, String studentId) {
        Student foundStudent = null;
        if (listStudent != null && !listStudent.isEmpty()) {
            for (Student student : listStudent) {
                if (student.getId().equalsIgnoreCase(studentId)) {
                    foundStudent = student;
                    break;
                }
            }
        }
        return foundStudent;
    }

    /**
     *  This method helps find student by id
     *
     * @param listStudent a list valid student
     * @param studentId the student id who user want to find
     * @return Student if id is found, otherwise return null
     */
    public ArrayList<Student> findListStudentById(ArrayList<Student> listStudent, String studentId) {
        ArrayList<Student> foundStudent = new ArrayList<>();
        if (listStudent != null && !listStudent.isEmpty()) {
            for (Student student : listStudent) {
                if (student.getId().equalsIgnoreCase(studentId)) {
                    foundStudent.add(student);
                }
            }
        }
        return foundStudent;
    }

    /**
     *  This method helps update the information of student: name, semester, course
     *
     * @param student
     * @return Student with new information updated
     */
    public Student updateStudent(Student student) {
        System.out.println("Updating info for student: " + student.getStudentName());
        String name = dataHelper.inputString("New Name: ");
        student.setStudentName(name);
        String semester = dataHelper.inputString("New Semester: ");
        student.setSemester(semester);
        CourseType courseName =  dataHelper.inputCourseName("New Course: ");
        student.setCourseName(courseName);
        System.out.println("Update successfully the student!!!");
        return student;
    }

    /**
     * This method helps hard delete from the list student
     *
     * @param listStudent a list valid student
     * @return Student who was deleted from the list student
     */
    public Student deleteStudent(ArrayList<Student> listStudent, Student StudentToDelete) {
        listStudent.remove(StudentToDelete);
        System.out.println("Delete successfully the student!!!");
        return StudentToDelete;
    }

    /**
     * The UI which user interact
     *
     * @param listStudent a list valid student
     * @return student who was deleted or updated
     */
    public Student updateDeleteStudent(ArrayList<Student> listStudent, Display display) {
        Student result = null;

        if (listStudent.isEmpty()) {
            System.out.println("List is empty. Nothing to update or delete!");
        } else {
            String studentId = dataHelper.inputString("Input student ID: ");
            ArrayList<Student> listFound = findListStudentById(listStudent, studentId);

            if (listFound.isEmpty()) {
                System.err.println("Not found any student has " + studentId);
            }

            Student studentToProcess = listFound.get(0);

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
                result =  deleteStudent(listStudent, studentToProcess);
            }
        }
        return result;
    }

    /**
     *
     * @param listStudent
     * @return
     */
    public HashMap<String, Integer> generateReport(ArrayList<Student> listStudent) {
        HashMap<String, Integer> reportMap = null;
        if (listStudent != null && !listStudent.isEmpty()) {
//        Initialize HashMap: Key: String: NameStudent#Course, Value: Integer: Total course
            reportMap = new HashMap<>();
            for (Student student : listStudent) {
                String key = student.getStudentName() + "|" + student.getCourseName();
                reportMap.put(key, reportMap.getOrDefault(key, 0) + 1);
            }
        }
        return reportMap;
    }
}
