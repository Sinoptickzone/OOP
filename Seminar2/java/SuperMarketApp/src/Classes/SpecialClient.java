package Classes;

/**
 * Represents a special client in the system, extending the Actor class.
 */
public class SpecialClient extends Actor {
    private int idVIP;

    /**
     * Constructor for SpecialClient class.
     * @param name The name of the special client.
     * @param idVIP The VIP identification number of the special client.
     */
    public SpecialClient(String name, int idVIP) {
        super(name);
        this.idVIP = idVIP;
    }
}
