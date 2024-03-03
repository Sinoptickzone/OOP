package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

/**
 * This interface defines methods for displaying student information and prompting user input.
 */
public interface iGetView {
    /**
     * Displays a list of student objects.
     *
     * @param students The list of student objects to be displayed
     */
    public void printAllStudents(List<Student> students);

    /**
     * Prompts the user with a message and returns the user's input as a string.
     *
     * @param msg The message to be displayed as a prompt
     * @return The user's input as a string
     */
    public String prompt(String msg);
}
