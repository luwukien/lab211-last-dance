package model;

import utility.DataHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class StudentServices {
    private final DataHelper dataHelper = new DataHelper();
    private ArrayList<Student> listStudent = new ArrayList<>();

    public StudentServices(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    /**
     * Create a valid student and then add list Student. Create at least 10 student
     *
     * @return creat at least 10 valid student
     */
    public boolean addStudent(String id, String name, String semester, CourseType course) {
        boolean result = true;
        if (isDuplicate(listStudent, id, name, semester, course)) {
            result = false;
        }
        return result;
    }
    /**
     * Checks if a student record already exists in the list.
     * Uniqueness is defined by the combination of ID, name, semester, course type.
     *
     * @param listStudent The list of existing students to check again.
     * @param id          the student id
     * @param name        the student name (case-insensitive)
     * @param courseType  the semester (case-insensitive)
     * @param semester    the type of course (Java, .Net, C/C++)
     * @return true if a duplicate is found, false otherwise
     */
    public boolean isDuplicate(ArrayList<Student> listStudent, String id, String name,
                               String semester, CourseType courseType) {

        for (Student student : listStudent) {
            if (student.getStudentName().equalsIgnoreCase(name)
                    && student.getId().equalsIgnoreCase(id)
                    && student.getCourseName().equals(courseType)
                    && student.getSemester().equalsIgnoreCase(semester)) return true;
        }

        return false;
    }

    /**
     * sort student by name ascending
     *
     */
    public ArrayList<Student> sortStudentByName() {
        Collections.sort(listStudent, Comparator.comparing(Student::getStudentName));
        return listStudent;
    }

    /**
     * The logic find student by name
     *
     * @param name the name student who user want to find
     * @return a list student name contain name student who user want to find
     */
    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> foundStudent = new ArrayList<>();
        if (listStudent != null && !listStudent.isEmpty()) {
            for (Student student : listStudent) {
                if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                    foundStudent.add(student);
                }
            }
        }

        if (!foundStudent.isEmpty()) {
            foundStudent = sortStudentByName();
        }
        return foundStudent;
    }

    /**
     * This method helps find student by id
     *
     * @param listStudent a list valid student
     * @param studentId   the student id who user want to find
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
     * This method helps find a list student by id
     *
     * @param studentId   the student id who user want to find
     * @return List Student if id is found, otherwise return empty array
     */
    public ArrayList<Student> findListStudentById(String studentId) {
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

    public void updateStudentInfo(Student student, String name, String semester, CourseType course) {
        student.setStudentName(name);
        student.setSemester(semester);
        student.setCourseName(course);
    }

    /**
     * This method count amount of courses of a student
     *
     * @param listStudent a list valid student
     * @return HashMap contains elements: Key and Value. Key: NameStudent|CourseName;
     * Value: total of courses of this student
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

    public void saveStudent(Student student) {
        this.listStudent.add(student);
    }
    public void deleteStudent(Student student) {
        this.listStudent.remove(student);
    }
}
