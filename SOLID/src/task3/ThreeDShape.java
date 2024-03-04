package task3;

/**
 * An interface representing a three-dimensional geometric shape.
 */
public interface ThreeDShape extends TwoDShape {
    /**
     * Calculates the volume of the shape (to be implemented by subclasses).
     *
     * @return volume of the shape
     */
    double volume();
}
