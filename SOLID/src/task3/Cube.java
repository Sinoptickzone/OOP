package task3;

/**
 * A class representing a cube, which is a three-dimensional shape with all sides equal.
 */
public class Cube implements ThreeDShape {
    private double edge;

    /**
     * Constructs a cube with the specified edge length.
     *
     * @param edge the length of the edge of the cube
     */
    public Cube(double edge) {
        this.edge = edge;
    }

    /**
     * Calculates the surface area of the cube.
     *
     * @return the surface area of the cube
     */
    @Override
    public double area() {
        return 6 * edge * edge;
    }

    /**
     * Calculates the volume of the cube.
     *
     * @return the volume of the cube
     */
    @Override
    public double volume() {
        return edge * edge * edge;
    }
}
