package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

/**
 * This class represents a view for interacting with student data through console input and output.
 */
public class ViewClass implements iGetView {
    /**
     * Prints a list of students to the console.
     *
     * @param students the list of Student objects to be printed
     */
    public void printAllStudents(List<Student> students) {
        // print list of students to console
        System.out.println("--------------------Список студентов-------------------");
        for(Student s: students) {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------");
    }

    /**
     * Prompts the user with a message and reads user input from the console.
     *
     * @param msg the message displayed to the user as a prompt
     * @return the user input as a String
     */
    public String prompt(String msg) {
        // write message and get user input
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }
}
