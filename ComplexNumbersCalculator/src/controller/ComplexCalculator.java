package controller;

import model.ComplexNumber;

/**
 * A utility class for performing arithmetic operations on complex numbers.
 */
public class ComplexCalculator {
    /**
     * Adds two complex numbers.
     * @param num1 The first complex number.
     * @param num2 The second complex number.
     * @return The sum of the two complex numbers.
     */
    public static ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        double real = num1.getRealPart() + num2.getRealPart();
        double imaginary = num1.getImaginaryPart() + num2.getImaginaryPart();
        return new ComplexNumber(real, imaginary);
    }

    /**
     * Subtracts one complex number from another.
     * @param num1 The complex number to subtract from.
     * @param num2 The complex number to subtract.
     * @return The result of subtracting the second complex number from the first.
     */
    public static ComplexNumber subtract(ComplexNumber num1, ComplexNumber num2) {
        double real = num1.getRealPart() - num2.getRealPart();
        double imaginary = num1.getImaginaryPart() - num2.getImaginaryPart();
        return new ComplexNumber(real, imaginary);
    }

    /**
     * Multiplies two complex numbers.
     * @param num1 The first complex number.
     * @param num2 The second complex number.
     * @return The product of the two complex numbers.
     */
    public static ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        double real = num1.getRealPart() * num2.getRealPart() - num1.getImaginaryPart() * num2.getImaginaryPart();
        double imaginary = num1.getRealPart() * num2.getImaginaryPart() + num1.getImaginaryPart() * num2.getRealPart();
        return new ComplexNumber(real, imaginary);
    }

    /**
     * Divides one complex number by another.
     * @param num1 The complex number to be divided.
     * @param num2 The complex number to divide by.
     * @return The result of dividing the first complex number by the second.
     */
    public static ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        double denominator = num2.getRealPart() * num2.getRealPart() + num2.getImaginaryPart() * num2.getImaginaryPart();
        double real = (num1.getRealPart() * num2.getRealPart() + num1.getImaginaryPart() * num2.getImaginaryPart()) / denominator;
        double imaginary = (num1.getImaginaryPart() * num2.getRealPart() - num1.getRealPart() * num2.getImaginaryPart()) / denominator;
        return new ComplexNumber(real, imaginary);
    }
}
