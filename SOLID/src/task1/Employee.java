package task1;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents an Employee with basic information such as name, date of birth, and base salary.
 */
public class Employee {
    private String name;
    private LocalDate dob;
    private BigDecimal baseSalary;

    /**
     * Constructs an Employee with the specified name, date of birth, and base salary.
     *
     * @param name       the name of the employee
     * @param dob        the date of birth of the employee
     * @param baseSalary the base salary of the employee
     */
    public Employee(String name, LocalDate dob, BigDecimal baseSalary) {
        this.name = name;
        this.dob = dob;
        this.baseSalary = baseSalary;
    }

    /**
     * Returns the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     *
     * @param name the new name of the employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the date of birth of the employee.
     *
     * @return the date of birth of the employee
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the employee.
     *
     * @param dob the new date of birth of the employee
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Returns the base salary of the employee.
     *
     * @return the base salary of the employee
     */
    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    /**
     * Sets the base salary of the employee.
     *
     * @param baseSalary the new base salary of the employee
     */
    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * Returns a string representation of the employee's information (name and date of birth).
     *
     * @return a string containing the name and date of birth of the employee
     */
    public String getEmpInfo() {
        return "name - " + name + " , dob - " + dob.toString();
    }
}
