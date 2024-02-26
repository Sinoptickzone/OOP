package Domain;

/**
 * This class represents a student who is a person and can be compared based on age and ID.
 */
public class Student extends Person implements Comparable<Student> {
    private int id;
    private static int generalId;

    /**
     * Constructor to create a new Student object with a name, age, and unique ID.
     * @param name The name of the student.
     * @param age The age of the student.
     */
    public Student(String name, int age) {
        super(name, age);
        this.id = generalId;
        generalId++;
    }

    /**
     * Get the ID of the student.
     * @return The ID of the student.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns a string representation of the student.
     * @return A string containing the age, name, and ID of the student.
     */
    @Override
    public String toString() {
        return "Students [age=" + super.getAge() + ", name=" + super.getName() + ", id=" + id + "]";
    }

    /**
     * Compare this student with another student based on age and ID.
     * @param o The student to compare with.
     * @return 0 if the students are equal, 1 if this student is greater, -1 if this student is less than the other student.
     */
    @Override
    public int compareTo(Student o) {

        System.out.println(super.getName()+" - "+o.getName());
        if(super.getAge()==o.getAge())
        {
            if(id==o.id) return 0 ;
            if(id>o.id) return 1;
            else return -1;
            //return 0;
        }

        if(super.getAge()>o.getAge())
            return 1;
        else return -1;
    }
}


