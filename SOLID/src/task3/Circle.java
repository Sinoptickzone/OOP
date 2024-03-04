package task3;

/**
 * A class representing a circle, which is a two-dimensional shape with all points on the boundary equidistant from the center.
 */
public class Circle implements TwoDShape {
    private double radius;

    /**
     * Constructs a circle with the specified radius.
     *
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle.
     *
     * @return the area of the circle
     */
    @Override
    public double area() {
        return 3.14 * radius * radius;
    }
}
