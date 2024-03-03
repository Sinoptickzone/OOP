package Controller;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;
import View.ViewClass;

import java.util.ArrayList;
import java.util.List;

/**
 * ControllerClass represents the controller in the MVC (Model-View-Controller) or MVP (Model-View-Presenter) design pattern.
 * It manages interactions between the models and the view.
 */
public class ControllerClass {
    private final List<iGetModel> models;
    private final iGetView view;
    private final List<Student> bufferStudentList = new ArrayList<Student>();

    /**
     * Constructor for ControllerClass.
     *
     * @param models List of models that provide data.
     * @param view   View interface for displaying data.
     */
    public ControllerClass(List<iGetModel> models, iGetView view) {
        this.models = models;
        this.view = view;
    }

    /**
     * Checks if the list of students is empty.
     *
     * @param students List of students to check.
     * @return True if the list is not empty, false otherwise.
     */
    private boolean testData(List<Student> students) {
        //check if list of students is empty
        return !students.isEmpty();
    }

    /**
     * Updates the view with the latest student data.
     * Collects all students from models and displays them in the view.
     */
    public void update() {
        // MVC
        // view.printAllStudent(model.getStudents());

        // MVP
        // collect all students in one buffer
        List<Student> allStudents = new ArrayList<>();
        for (iGetModel model : models) {
            bufferStudentList.addAll(model.getAllStudents());
        }
        // print list of all students if it's not empty
        if (testData(bufferStudentList)) {
            view.printAllStudents(bufferStudentList);
        } else {
            if (view.getClass().equals(ViewClass.class)) {
                System.out.println("Список студентов пуст!");
            } else {
                System.out.println("List of students is empty!");
            }
        }
    }

    /**
     * Runs the program and handles user input commands.
     */
    public void run() {
        // write list of all commands
        if (view.getClass().equals(ViewClass.class)) {
            System.out.println("Список команд: ");
        } else {
            System.out.println("All commands: ");
        }
        for (Command command : Command.values()) {
            System.out.println(command);
        }

        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            //read command from console
            String command = "";
            if (view.getClass().equals(ViewClass.class)) {
                command = view.prompt("Введите команду: ");
            } else {
                command = view.prompt("Enter command: ");
            }

            // get enum element matching command
            try {
                com = Command.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                if (view.getClass().equals(ViewClass.class)) {
                    System.out.println("Такой команды нет или она недоступна.");
                } else {
                    System.out.println("No such command or it's not available.");
                }
            }

            // execute appropriate command
            switch (com) {
                case EXIT: // exit the program
                    getNewIteration = false;
                    if (view.getClass().equals(ViewClass.class)) {
                        System.out.println("Выход из программы!");
                    } else {
                        System.out.println("Exiting program!");
                    }
                    break;
                case LIST: // write list of students to console
                    for (iGetModel model : models) {
                        view.printAllStudents(model.getAllStudents());
                    }
                    break;
                case DELETE: // delete student by id
                    boolean studentDeleted = false;
                    int idToDelete = -1;
                    while (true) {
                        // get id of student to delete from view
                        String idLine = "";
                        if (view.getClass().equals(ViewClass.class)) {
                            idLine = view.prompt("Введите номер студента для удаления:");
                        } else {
                            idLine = view.prompt("Enter number of student to delete:");
                        }
                        /* if correct input stop cycle
                           else continue querying number of student
                         */
                        try {
                            idToDelete = Integer.parseInt(idLine);
                            break;
                        } catch (NumberFormatException e) {
                            if (view.getClass().equals(ViewClass.class))
                                System.out.println("Неверный ввод.");
                            else
                                System.out.println("Wrong input.");
                        }
                    }
                    // cycle through all models
                    for (iGetModel model : models) {
                        /* try to delete student
                           if student deleted break cycle
                         */
                        studentDeleted = model.delete(idToDelete); // ask model to delete student
                        if (studentDeleted) break;
                    }
                    // if student is not deleted pass that to view
                    if (!studentDeleted) {
                        if (view.getClass().equals(ViewClass.class))
                            System.out.println("Студента с таким номером не существует.");
                        else
                            System.out.println("There is no such student with this number.");
                    } else { // if student is deleted pass that to view
                        if (view.getClass().equals(ViewClass.class))
                            System.out.println("Студент удалён.");
                        else
                            System.out.println("Student is deleted.");
                    }
                    break;
            }
        }
    }
}
