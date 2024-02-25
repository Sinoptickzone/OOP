package Classes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Represents a receipt in the system.
 */
public class Receipt {
    private Map<Product, Integer> products;
    private LocalDateTime dateTime;
    private BigDecimal sum = new BigDecimal(0);

    /**
     * Constructor for Receipt class.
     * @param products A map of products and their quantities on the receipt.
     * @param dateTime The date and time when the receipt was created.
     */
    public Receipt(Map<Product, Integer> products, LocalDateTime dateTime) {
        this.products = products;
        this.dateTime = dateTime;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            this.sum.add(entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue())));
        }
    }

    /**
     * Gets the map of products and their quantities on the receipt.
     * @return The map of products and quantities.
     */
    public Map<Product, Integer> getProducts() {
        return products;
    }

    /**
     * Gets the date and time when the receipt was created.
     * @return The date and time of the receipt.
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Gets the total sum of the receipt.
     * @return The total sum of the receipt.
     */
    public BigDecimal getSum() {
        return sum;
    }

    /**
     * Returns a string representation of the receipt.
     * @return A string containing the products, date, and total sum of the receipt.
     */
    @Override
    public String toString() {
        return "Receipt{" +
                "products=" + products +
                ", dateTime=" + dateTime +
                ", sum=" + sum +
                '}';
    }
}
