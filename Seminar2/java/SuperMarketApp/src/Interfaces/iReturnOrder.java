package Interfaces;

import Classes.Product;
import Classes.Receipt;

import java.math.BigDecimal;
import java.util.Map;

/**
 * The iReturnOrder interface represents the behavior of returning an order in the system.
 */
public interface iReturnOrder {
    /**
     * Shows the receipt of the order.
     *
     * @return The receipt of the order.
     */
    Receipt showReceipt();
    /**
     * Returns the products from the order.
     *
     * @return A map containing the returned products along with their quantities.
     */
    Map<Product, Integer> returnProducts();
    /**
     * Receives the refund amount for the returned order.
     *
     * @param amount The amount to be refunded for the returned order.
     */
    void receiveMoney(BigDecimal amount);
}
