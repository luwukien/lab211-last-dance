import controller.StudentController;
import model.Student;
import view.Display;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> listStudent = new ArrayList<>();
        Display display = new Display();
        StudentController controller = new StudentController();

        while (true) {
            int choice = display.displayMenu();
            switch (choice) {
                case 1:
                    controller.createStudent(listStudent);
                    break;
                case 2:
                    display.displaySortedStudentByName(listStudent);
                    break;
                case 3:
                    controller.findStudent(listStudent);
                    break;
                case 4:
                    controller.updateDeleteStudent(listStudent);
                    break;
                case 5:
                    display.displayReport(controller.generateReport(listStudent));
                    break;
                case 6:
                    return;
            }
        }
    }
}