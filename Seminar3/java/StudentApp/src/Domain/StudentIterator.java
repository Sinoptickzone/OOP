package Domain;

import java.util.Iterator;
import java.util.List;

/**
 * This class represents an iterator for a list of students.
 */
public class StudentIterator implements Iterator<Student> {
    private int counter;
    private final List<Student> students;

    /**
     * Constructor to create a new StudentIterator object with a list of students.
     * @param students The list of students to iterate over.
     */
    public StudentIterator(List<Student> students) {
        this.students = students;
        this.counter = 0;
    }

    /**
     * Checks if there are more students in the list to iterate over.
     * @return true if there are more students, false otherwise.
     */
    @Override
    public boolean hasNext() {
       return counter < students.size();
    }

    /**
     * Retrieves the next student in the list.
     * @return The next student in the list or null if there are no more students.
     */
    @Override
    public Student next() {
        if(!hasNext())
        {
            return null;
        }
        //counter++;
        return students.get(counter++);        
    }
}

