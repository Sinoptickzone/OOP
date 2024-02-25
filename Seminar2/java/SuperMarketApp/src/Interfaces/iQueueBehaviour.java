package Interfaces;

/**
 * The iQueueBehaviour interface represents the behavior of a queue in the system.
 */
public interface iQueueBehaviour {
    /**
     * Adds an actor to the queue.
     *
     * @param actor The actor to be added to the queue.
     */
    void takeInQueue(iActorBehaviour actor);
    /**
     * Releases an actor from the queue.
     */
    void releaseFromQueue();
    /**
     * Takes an order from actors in the queue.
     */
    void takeOrder ();
    /**
     * Gives an order to actors in the queue.
     */
    void giveOrder ();
}
