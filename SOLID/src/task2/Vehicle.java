package task2;

/**
 * An abstract class representing a vehicle with a maximum speed.
 */
public abstract class Vehicle {

    private int maxSpeed;

    /**
     * Constructs a new Vehicle with the specified maximum speed.
     *
     * @param maxSpeed the maximum speed of the vehicle
     */
    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Gets the maximum speed of the vehicle.
     *
     * @return the maximum speed of the vehicle
     */
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    /**
     * Calculates the allowed speed for the vehicle (to be implemented by subclasses).
     *
     * @return the allowed speed for the vehicle
     */
    public abstract int calculateAllowedSpeed();
}
