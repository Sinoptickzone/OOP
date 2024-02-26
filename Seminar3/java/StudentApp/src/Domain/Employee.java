package Domain;

/**
 * This class represents an employee, which is a type of person with a special attribute.
 */
public class Employee extends Person{
    private String special;

    /**
     * Constructor to create a new Employee object with a name, age, and special attribute.
     * @param firstName The first name of the employee.
     * @param age The age of the employee.
     * @param special The special attribute of the employee.
     */
    public Employee(String firstName, int age, String special) {
        super(firstName, age);
        this.special = special;
    }
}

