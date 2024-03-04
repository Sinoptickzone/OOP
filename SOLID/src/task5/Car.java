package task5;

/**
 * A class representing a car that has an engine.
 */
public class Car {
    private Engine engine;

    /**
     * Constructs a car with the specified engine.
     *
     * @param engine the engine of the car
     */
    public Car(Engine engine) {
        this.engine = engine;
    }

    /**
     * Starts the car by starting its engine.
     */
    public void start() {
        this.engine.start();
    }
}
