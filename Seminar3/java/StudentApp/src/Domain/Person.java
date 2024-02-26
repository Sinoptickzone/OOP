package Domain;

/**
 * This class represents a person with a name and age.
 */
public abstract class Person {
    private String name;
    private int age;

    /**
     * Constructor to create a new Person object with a name and age.
     * @param name The name of the person.
     * @param age The age of the person.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Get the name of the person.
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the person.
     * @param name The new name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the age of the person.
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the age of the person.
     * @param age The new age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns a string representation of the person.
     * @return A string containing the name and age of the person.
     */
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}


