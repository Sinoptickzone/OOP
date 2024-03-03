package Main;

import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;
import Model.FileModelClass;
import Model.ModelClass;
import Model.ModelClassHash;
import View.ViewClass;
import View.ViewClassEng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the main application that initializes student objects, fills lists and maps with students,
 * and launches the MVC architecture for managing student data.
 */
public class App {
    /**
     * The main method that serves as the entry point for the application.
     *
     * @param args the command-line arguments passed to the application
     */
    public static void main(String[] args) {
        //create students objects
        Student student1 = new Student("Ivan", 21);
        Student student2 = new Student("Anna", 25);
        Student student3 = new Student("Vasya", 22);

        Student student4 = new Student("Nastya", 27);
        Student student5 = new Student("Vasilisa", 26);
        Student student6 = new Student("Karina", 25);

        Student student7 = new Student("Andrey", 22);
        Student student8 = new Student("Masha", 27);
        Student student9 = new Student("Irina", 28);
        Student student10 = new Student("Nikolay", 30);

        // fill the list with students
        List<Student> studList1 = new ArrayList<>();
        studList1.add(student1);
        studList1.add(student2);
        studList1.add(student3);

        List<Student> studList2 = new ArrayList<>();
        studList2.add(student4);
        studList2.add(student5);
        studList2.add(student6);

        List<Student> studList3 = new ArrayList<>();
        studList3.add(student7);
        studList3.add(student8);
        studList3.add(student9);
        studList3.add(student10);

        // initialize fileModelClass
        FileModelClass fileModelClass = new FileModelClass("StudentDB.csv");
        //fileModelClass.saveAllStudentsToFile(studList1, true); // save list of students to file

        // fill the map with students
        HashMap<Integer, Student> studentMap = new HashMap<>();
        for (Student student : studList2) {
            studentMap.put(student.getId(), student);
        }

        //choose view
        Scanner scanner = new Scanner(System.in);
        iGetView view = null;
        boolean viewChosen = false;
        while (!viewChosen) {
            System.out.println("Choose language. Write \"rus\" for Russian or \"eng\" for English:");
            String language = scanner.next();
            if (language.equals("rus")) {
                view = new ViewClass();
                viewChosen = true;
            } else if (language.equals("eng")) {
                view = new ViewClassEng();
                viewChosen = true;
            }
        }
        //initialize models
        iGetModel modelClassHash = new ModelClassHash(studentMap);
        iGetModel modelClass = new ModelClass(studList3);
        List<iGetModel> models = List.of(fileModelClass, modelClassHash, modelClass);

        //initialize controller
        ControllerClass controller = new ControllerClass(models, view);

        //controller.update();

        // launch controller
        controller.run();
    }
}
