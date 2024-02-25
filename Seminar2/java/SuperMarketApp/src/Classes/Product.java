package Classes;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a product in the system.
 */
public class Product {
    private String name;
    private BigDecimal price;

    /**
     * Constructor for Product class.
     * @param name The name of the product.
     * @param price The price of the product.
     */
    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the product.
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * @param name The new name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the product.
     * @return The price of the product.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * @param price The new price of the product.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Checks if two products are equal based on name and price.
     * @param o The object to compare with.
     * @return true if the products are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    /**
     * Generates a hash code for the product based on name and price.
     * @return The hash code of the product.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    /**
     * Returns a string representation of the product.
     * @return A string containing the name and price of the product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
