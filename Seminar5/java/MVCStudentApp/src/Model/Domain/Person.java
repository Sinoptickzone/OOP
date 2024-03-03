package Model.Domain;

/**
 * This abstract class represents a Person with a name and age.
 */
public abstract class Person {
    private String name;
    private int age;

    /**
     * Constructs a Person object with the specified name and age.
     * @param name the name of the person
     * @param age the age of the person
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name of the person.
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     * @param name the new name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age of the person.
     * @return the age of the person
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     * @param age the new age of the person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns a string representation of the Person object.
     * @return a string representation of the Person object
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
