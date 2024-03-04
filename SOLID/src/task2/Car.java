package task2;

/**
 * A class representing a Car, which is a type of Vehicle.
 */
public class Car extends Vehicle {
    /**
     * Constructs a new Car with the specified maximum speed.
     *
     * @param maxSpeed the maximum speed of the car
     */
    public Car(int maxSpeed) {
        super(maxSpeed);
    }

    /**
     * Calculates the allowed speed for the car, which is 80% of the maximum speed.
     *
     * @return the allowed speed for the car
     */
    @Override
    public int calculateAllowedSpeed() {
        return (int) (this.getMaxSpeed() * 0.8);
    }
}
