package Domain;

import java.util.Iterator;
import java.util.List;

/**
 * This class represents a group of students with an ID.
 * It implements the Iterable interface to allow iteration over the students in the group
 * and the Comparable interface for comparing groups based on size and ID.
 */
public class StudentGroup implements Iterable<Student>, Comparable<StudentGroup> {
    private List<Student> group;
    private Integer idGroup;

    /**
     * Constructor to create a new StudentGroup object with a list of students and an ID.
     * @param group The list of students in the group.
     * @param idGroup The ID of the group.
     */
    public StudentGroup(List<Student> group, Integer idGroup) {
        this.group = group;
        this.idGroup = idGroup;
    }

    /**
     * Retrieves the list of students in the group.
     * @return The list of students in the group.
     */
    public List<Student> getGroup() {
        return group;
    }

    /**
     * Sets the list of students in the group.
     * @param group The list of students to set for the group.
     */
    public void setGroup(List<Student> group) {
        this.group = group;
    }

    /**
     * Retrieves the ID of the group.
     * @return The ID of the group.
     */
    public Integer getIdGroup() {
        return idGroup;
    }

    /**
     * Sets the ID of the group.
     * @param idGroup The ID to set for the group.
     */
    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    /**
     * Returns a string representation of the StudentGroup object.
     * @return A string representation containing the ID, number of students, and the list of students in the group.
     */
     @Override
    public String toString() {
        return "StudentGroup{" +
                "idGroup=" + idGroup +
                ", studentsCount=" + group.size() +
                ", group=" + group +
                '}';
    }

    // @Override
    // public Iterator<Student> iterator() {
    //    return new Iterator<Student>() {

    //     private int counter;

    //     @Override
    //     public boolean hasNext() {

    //         if(counter<group.size())
    //         {
    //             return true;
    //         }
    //         else
    //         {
    //             return false;
    //         }            
    //     }

    //     @Override
    //     public Student next() {            
    //         return group.get(counter++);
    //     }
        
    //    };
        
    // }

    /**
     * Returns an iterator over the students in the group using the StudentIterator class.
     * @return An iterator over the students in the group.
     */
     @Override
    public Iterator<Student> iterator() {
       return new StudentIterator(group);
    }

    /**
     * Compares this StudentGroup with another based on size and ID.
     * @param o The StudentGroup to compare with.
     * @return A negative integer, zero, or a positive integer if this group is smaller, equal, or larger than the other group.
     */
    @Override
    public int compareTo(StudentGroup o) {
        int sizeComparison = Integer.compare(this.group.size(), o.group.size());
        if (sizeComparison == 0) {
            return Integer.compare(this.idGroup, o.idGroup);
        }
        return sizeComparison;
    }
}
