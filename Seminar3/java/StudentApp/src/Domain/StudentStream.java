package Domain;

import java.util.Iterator;
import java.util.List;

/**
 * This class represents a student stream containing multiple student groups.
 * It implements the Iterable interface to allow iteration over the student groups in the stream.
 */
public class StudentStream implements Iterable<StudentGroup> {
    private List<StudentGroup> groups;
    private int streamNumber;

    /**
     * Constructor to create a new StudentStream object with a list of student groups and a stream number.
     * @param groups The list of student groups in the stream.
     * @param streamNumber The number assigned to the stream.
     */
    public StudentStream(List<StudentGroup> groups, int streamNumber) {
        this.groups = groups;
        this.streamNumber = streamNumber;
    }

    /**
     * Retrieves the list of student groups in the stream.
     * @return The list of student groups in the stream.
     */
    public List<StudentGroup> getGroups() {
        return groups;
    }

    /**
     * Sets the list of student groups in the stream.
     * @param groups The list of student groups to set for the stream.
     */
    public void setGroups(List<StudentGroup> groups) {
        this.groups = groups;
    }

    /**
     * Retrieves the number assigned to the stream.
     * @return The number assigned to the stream.
     */
    public int getStreamNumber() {
        return streamNumber;
    }

    /**
     * Sets the number assigned to the stream.
     * @param streamNumber The number to set for the stream.
     */
    public void setStreamNumber(int streamNumber) {
        this.streamNumber = streamNumber;
    }

    /**
     * Returns an iterator over the student groups in the stream using an anonymous Iterator class.
     * @return An iterator over the student groups in the stream.
     */
    @Override
    public Iterator<StudentGroup> iterator() {
        return new Iterator<StudentGroup>() {
            private int counter;

            @Override
            public boolean hasNext() {
                return counter < groups.size();
            }

            @Override
            public StudentGroup next() {
                if (!hasNext()) return null;
                return groups.get(counter++);
            }
        };
    }

    /**
     * Returns a string representation of the StudentStream object.
     * @return A string representation containing the stream number, number of groups,
     * and the list of groups in the stream.
     */
    @Override
    public String toString() {
        return "StudentSteam{" +
                "steamNumber=" + streamNumber +
                ", groupCount=" + groups.size() +
                ", groups=" + groups +
                '}';
    }
}
