package task4;

/**
 * A class representing a square, which is a special type of rectangle where all sides are equal in length.
 */
public class Square extends Rectangle {

    /**
     * Constructs a square with the specified side length.
     *
     * @param side the length of each side of the square
     */
    public Square(int side) {
        super(side, side);
    }
}
