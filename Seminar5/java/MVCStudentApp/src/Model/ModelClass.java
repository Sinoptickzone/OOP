package Model;

import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

/**
 * This class represents a simple model for handling student data in memory.
 */
public class ModelClass implements iGetModel {
    private List<Student> students;

    /**
     * Constructs a new ModelClass with the specified list of students.
     *
     * @param students the list of students to be stored in memory
     */
    public ModelClass(List<Student> students) {
        this.students = students;
    }

    /**
     * Retrieves all students stored in memory.
     *
     * @return a list of Student objects stored in memory
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Deletes a student with the specified id from the list in memory.
     *
     * @param id the id of the student to delete
     * @return true if student was successfully deleted, false otherwise
     */
    @Override
    public boolean delete(int id) {
        // remove student from list if id matches
        return students.removeIf(student -> student.getId() == id);
    }
}
