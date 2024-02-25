package Interfaces;

import Classes.Actor;
import Classes.Product;
import Classes.Receipt;

import java.util.Map;

/**
 * The iActorBehaviour interface represents the behavior of an actor in the market.
 */
public interface iActorBehaviour extends iReturnOrder {
    /**
     * Checks if the actor is taking an order.
     *
     * @return true if the actor is taking an order, false otherwise.
     */
    boolean isTakeOrder();
    /**
     * Checks if the actor is making an order.
     *
     * @return true if the actor is making an order, false otherwise.
     */
    boolean isMakeOrder();
    /**
     * Sets the take an order status of the actor.
     *
     * @param val The value to set for taking an order.
     */
    void setTakeOrder(boolean val);
    /**
     * Sets the make an order status of the actor.
     *
     * @param val The value to set for making an order.
     */
    void setMakeOrder(boolean val);
    /**
     * Gets the actor associated with the behavior.
     *
     * @return The actor associated with the behavior.
     */
    Actor getActor();
    /**
     * Checks if the actor is returning an order.
     *
     * @return true if the actor is returning an order, false otherwise.
     */
    boolean isReturnOrder();
    /**
     * Sets the return an order status of the actor.
     *
     * @param val The value to set for returning an order.
     */
    void setReturnOrder(boolean val);
    /**
     * Sets the receipt associated with the actor.
     *
     * @param receipt The receipt to set for the actor.
     */
    void setReceipt(Receipt receipt);
    /**
     * Sets the products and their quantities associated with the actor.
     *
     * @param products A map of products and their quantities.
     */
    void setProducts(Map<Product, Integer> products);
}
