package Model;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class represents a model for handling student data using a Map for efficient lookup.
 */
public class ModelClassHash implements iGetModel {
    // map to store pairs of id and student
    private final Map<Integer, Student> students;

    /**
     * Constructs a new ModelClassHash with the specified map of students.
     *
     * @param students the map of students where the key is the student id and the value is the Student object
     */
    public ModelClassHash(Map<Integer, Student> students) {
        this.students = students;
    }

    /**
     * Retrieves all students stored in the Map.
     *
     * @return a list of Student objects stored in the Map
     */
    @Override
    public List<Student> getAllStudents() {
        // return list of students creating it from map values
        return new ArrayList<>(students.values());
    }

    /**
     * Deletes a student with the specified id from the Map.
     *
     * @param id the id of the student to delete
     * @return true if student was successfully deleted, false otherwise
     */
    @Override
    public boolean delete(int id) {
        // remove student from map by key (id)
        return students.remove(id) != null;
    }
}
