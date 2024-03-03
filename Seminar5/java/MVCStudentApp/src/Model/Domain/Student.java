package Model.Domain;

/**
 * This class represents a Student, which is a type of Person with an additional id and id generator.
 */
public class Student extends Person implements Comparable<Student> {
    private int id;
    private static int idGenerator;

    /**
     * Constructs a Student object with the specified name and age.
     * The id of the student is automatically generated based on a static idGenerator.
     * @param name the name of the student
     * @param age the age of the student
     */
    public Student(String name, int age) {
        super(name, age);
        idGenerator++;
        this.id = idGenerator;
    }

    /**
     * Returns the id of the student.
     * @return the id of the student
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the student.
     * @param id the new id of the student
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns a string representation of the Student object.
     * @return a string representation of the Student object
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id + " name=" + super.getName() + " age=" + super.getAge() +
                '}';
    }

    /**
     * Compares this Student object with another Student object based on age and id.
     *
     * @param o the Student object to compare with
     * @return a negative integer, zero, or a positive integer as this Student object is less than, equal to, or greater than the specified Student object.
     */
    @Override
    public int compareTo(Student o) {
        System.out.println(this.getName() + " - " + o.getName());
        int ageComparison = Integer.compare(this.getAge(), o.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        }
        return Integer.compare(this.getId(), o.getId());
    }
}
