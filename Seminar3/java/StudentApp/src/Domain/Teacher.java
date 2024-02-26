package Domain;

/**
 * This class represents a teacher who is a person with an academic degree.
 * It extends the Person class and adds an additional field for the academic degree.
 */
public class Teacher extends Person {
    private String acadDegree;

    /**
     * Constructor to create a new Teacher object with a first name, age, and academic degree.
     * @param firstName The first name of the teacher.
     * @param age The age of the teacher.
     * @param acadDegree The academic degree of the teacher.
     */
    public Teacher(String firstName, int age, String acadDegree) {
        super(firstName, age);
        this.acadDegree = acadDegree;
    }
}
