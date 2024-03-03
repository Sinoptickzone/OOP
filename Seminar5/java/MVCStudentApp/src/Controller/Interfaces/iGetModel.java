package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

/**
 * This interface defines methods for getting and deleting student objects.
 */
public interface iGetModel {
    /**
     * Retrieves a list of all student objects.
     *
     * @return A list of all student objects
     */
    List<Student> getAllStudents();

    /**
     * Deletes a student object based on the provided ID.
     *
     * @param id The ID of the student to be deleted
     * @return true if the student was successfully deleted, false otherwise
     */
    boolean delete(int id);
}
