package model;

/**
 * Represents a complex number with real and imaginary parts.
 */
public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    /**
     * Constructs a complex number with the specified real and imaginary parts.
     *
     * @param realPart      The real part of the complex number.
     * @param imaginaryPart The imaginary part of the complex number.
     */
    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Gets the real part of the complex number.
     *
     * @return The real part of the complex number.
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * Gets the imaginary part of the complex number.
     *
     * @return The imaginary part of the complex number.
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * Returns a string representation of the complex number in the form (a + bi) or (a - bi).
     *
     * @return A string representation of the complex number.
     */
    @Override
    public String toString() {
        if (imaginaryPart < 0) return "(" + realPart + " - " + (-1 * imaginaryPart)  + "i)";
        return "(" + realPart + " + " + imaginaryPart + "i)";
    }
}
