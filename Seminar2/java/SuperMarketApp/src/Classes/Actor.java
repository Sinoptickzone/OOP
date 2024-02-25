package Classes;

import Interfaces.iActorBehaviour;
import Interfaces.iReturnOrder;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Represents an abstract Actor in the system.
 */
public abstract class Actor implements iActorBehaviour, iReturnOrder {
    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;
    private boolean isReturnOrder;

    private Receipt receipt;
    private Map<Product, Integer> products;
    private BigDecimal money;

    /**
     * Constructor for Actor class.
     * @param name The name of the actor.
     */
    public Actor(String name) {
        this.name = name;
        this.money = BigDecimal.valueOf(Math.random() * 10000);
    }

    /**
     * Checks if the special client takes an order.
     * @return True if the client takes an order, false otherwise.
     */
    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    /**
     * Checks if the special client makes an order.
     * @return True if the client makes an order, false otherwise.
     */
    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    /**
     * Sets whether the special client takes an order.
     * @param val The value to set for taking orders.
     */
    @Override
    public void setTakeOrder(boolean val) {
        this.isTakeOrder = val;
    }

    /**
     * Sets whether the special client makes an order.
     * @param val The value to set for making orders.
     */
    @Override
    public void setMakeOrder(boolean val) {
        this.isMakeOrder = val;
    }

    /**
     * Gets the actor object representing the special client.
     * @return The actor object representing the client.
     */
    @Override
    public Actor getActor() {
        return this;
    }

    /**
     * Abstract method to get the name of the actor.
     * @return The name of the actor.
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method to set the name of the actor.
     * @param name The new name of the actor.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the actor is returning an order.
     * @return true if the actor is returning an order, false otherwise.
     */
    @Override
    public boolean isReturnOrder() {
        return isReturnOrder;
    }

    /**
     * Sets the return order status of the actor.
     * @param b true to set as returning an order, false otherwise.
     */
    @Override
    public void setReturnOrder(boolean b) {
        this.isReturnOrder = b;
    }

    /**
     * Sets the products associated with the actor.
     * @param products A map of products and quantities.
     */
    @Override
    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    /**
     * Sets the receipt for the actor.
     * @param receipt The receipt for the actor's transaction.
     */
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    /**
     * Returns the receipt associated with the actor.
     * @return The receipt of the actor's transaction.
     */
    @Override
    public Receipt showReceipt() {
        return receipt;
    }

    /**
     * Returns the products of the actor.
     * @return A map of products and quantities to be returned.
     */
    @Override
    public Map<Product, Integer> returnProducts() {
        return products;
    }

    /**
     * Adds money to the actor's balance.
     * @param amount The amount of money to add to the balance.
     */
    @Override
    public void receiveMoney(BigDecimal amount) {
        this.money.add(amount);
    }
}





