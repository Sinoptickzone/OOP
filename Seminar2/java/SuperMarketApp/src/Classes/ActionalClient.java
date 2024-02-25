package Classes;

/**
 * Represents an Actional Client in the system, extending the Actor class.
 */
public class ActionalClient extends Actor {
    private String actionName = "New action";
    private int clientId;
    /**
     * The number of participants in the action.
     */
    public static int numberOfParticipants = 1;

    /**
     * Constructor for ActionalClient class with name and clientId parameters.
     * @param name The name of the Actional Client.
     * @param clientId The client ID of the Actional Client.
     */
    public ActionalClient(String name, int clientId) {
        super(name);
        this.clientId = clientId;
    }

    /**
     * Gets the name of the action.
     * @return The name of the action.
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * Sets the name of the action.
     * @param actionName The name of the action to set.
     */
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    /**
     * Gets the client ID of the Actional Client.
     * @return The client ID.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Sets the client ID of the Actional Client.
     * @param clientId The client ID to set.
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
