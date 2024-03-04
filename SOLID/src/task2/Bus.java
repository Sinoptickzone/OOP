package task2;

/**
 * A class representing a Bus, which is a type of Vehicle.
 */
public class Bus extends Vehicle {

    /**
     * Constructs a new Bus with the specified maximum speed.
     *
     * @param maxSpeed the maximum speed of the bus
     */
    public Bus(int maxSpeed) {
        super(maxSpeed);
    }

    /**
     * Calculates the allowed speed for the bus, which is 60% of the maximum speed.
     *
     * @return the allowed speed for the bus
     */
    @Override
    public int calculateAllowedSpeed() {
        return (int) (this.getMaxSpeed() * 0.6);
    }
}
