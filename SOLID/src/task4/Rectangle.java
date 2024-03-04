package task4;

/**
 * A class representing a rectangle, which is a two-dimensional shape
 * with opposite sides that are equal in length and all angles are right angles.
 */
public class Rectangle {
    private int width;
    private int height;

    /**
     * Constructs a rectangle with the specified width and height.
     *
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return the area of the rectangle
     */
    public int area() {
        return this.width * this.height;
    }
}
