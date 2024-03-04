package task1;

import java.math.BigDecimal;

/**
 * A utility class for calculating net salary based on the base salary and tax rate.
 */
public class SalaryCalculator {
    /**
     * Calculates the net salary by subtracting the tax amount from the base salary.
     *
     * @param baseSalary the base salary of the employee
     * @return the net salary after deducting the tax amount
     */
    public static BigDecimal calculateNetSalary(BigDecimal baseSalary) {
        return baseSalary.subtract(calculateTax(baseSalary)); // subtract tax
    }

    /**
     * Calculates the tax amount based on the given salary using a fixed tax rate of 25%.
     *
     * @param salary the total salary amount before tax deduction
     * @return the tax amount to be deducted from the salary
     */
    private static BigDecimal calculateTax(BigDecimal salary) {
        return salary.multiply(new BigDecimal("0.25")); // Example calculation of tax with a tax rate of 25%
    }
}
