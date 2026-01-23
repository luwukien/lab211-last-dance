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
                    controller.createStudent(listStudent, display);
                    break;
                case 2:
                    ArrayList<Student> foundStudents = controller.findStudent(listStudent, display);
                    display.displaySortedStudentByName(foundStudents, controller);
                    break;
                case 3:
                    controller.updateDeleteStudent(listStudent, display);
                    break;
                case 4:
                    display.displayReport(controller.generateReport(listStudent));
                    break;
                case 5:
                    return;
            }
        }
    }
}