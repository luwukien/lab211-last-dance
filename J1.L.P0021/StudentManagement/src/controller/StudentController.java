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
            display.displayCreateHeader();
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
                display.displayHeader();
                for (Student student : result) display.displayStudent(student);
            }
        }
        return result;

    }

    /**
     *  This method helps find student by id
     *
     * @param listStudent a list valid student
     * @param studentId the student id who user want to find
     * @return Student if id is found, otherwise return null
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
     *  This method helps update the information of student: name, semester, course
     *
     * @param listStudent  a list valid student
     * @param studentId the student id who user want to modifier
     * @return Student with new information updated
     */
    public Student updateStudent(ArrayList<Student> listStudent, String studentId) {
        Student foundStudent = findStudentById(listStudent, studentId);
        if (foundStudent != null) {
            int indexOfStudent = listStudent.indexOf(foundStudent);
            String name = dataHelper.inputString("Name new: ");
            foundStudent.setStudentName(name);
            String semester = dataHelper.inputString("Semester new: ");
            foundStudent.setSemester(semester);
            CourseType courseName =  dataHelper.inputCourseName("Course new: ");
            foundStudent.setCourseName(courseName);

            listStudent.set(indexOfStudent, foundStudent);
        }
        return foundStudent;
    }

    /**
     * This method helps hard delete from the list student
     *
     * @param listStudent a list valid student
     * @param studentId the student id who user want to delete
     * @return Student who was deleted from the list student
     */
    public Student deleteStudent(ArrayList<Student> listStudent, String studentId) {
        Student foundStudent = findStudentById(listStudent, studentId);
        if (foundStudent != null) {
            listStudent.remove(foundStudent);
        }
        return foundStudent;
    }

    /**
     * The UI which user interact
     *
     * @param listStudent a list valid student
     * @return student who was deleted or updated
     */
    public Student updateDeleteStudent(ArrayList<Student> listStudent) {
        Student resultStudent = null;
        boolean isFinished = false;
        while (!isFinished) {
            String studentId = dataHelper.inputString("Input student ID: ");

            if (studentId == null) {
                System.out.println("Not found any student has " + studentId);
                continue;
            }
//            Getting choice from user. True: Update; False: Delete
            boolean isUpdate = dataHelper.getUpdateDelete("Do you want to update (U) or delete (D) this student",
                    "You can only select U/u to update or D/d to delete!!!.");
            if (isUpdate) {
                display.displayUpdateHeader();
                resultStudent = updateStudent(listStudent, studentId);
                System.out.println("Update successfully the student!!!");
            } else {
                display.displayDeleteHeader();
                resultStudent = deleteStudent(listStudent, studentId);
                System.out.println("Delete successfully the student!!!");
            }

            display.displayHeader();
            display.displayStudent(resultStudent);
            isFinished = true;
        }
        return resultStudent;
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
