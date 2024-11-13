package Models;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code Order} class represents an order placed by a client, containing details
 * about the client ID, the products in the order, the total cost, and the reward points.
 * Each order has a unique identifier (ID).
 */
public class Order implements HasID {

    /**
     * The unique identifier for this order.
     */
    private Integer ID;

    /**
     * The ID of the client who placed the order.
     */
    private Integer clientID;

    /**
     * The total reward points accumulated from the products in the order.
     */
    private int points;

    /**
     * The total cost of the order, calculated from the product prices.
     */
    private int totalCost;

    /**
     * The list of products included in the order.
     */
    private List<Product> products;

    /**
     * Constructs a new {@code Order} with the specified order ID, client ID, and list of products.
     * It also calculates the total cost and points based on the provided products.
     *
     * @param orderID  the unique identifier for this order
     * @param clientID the ID of the client who placed the order
     * @param products the list of products in the order
     */
    public Order(Integer orderID, Integer clientID, List<Product> products) {
        this.ID = orderID;
        this.clientID = clientID;
        this.products = products;
        calculatePoints();
        calculateTotalCost();
    }

    /**
     * Retrieves the total points for the order, calculated from the products.
     *
     * @return the total reward points for the order
     */
    public int getPoints() {
        return points;
    }

    /**
     * Calculates and updates the total cost of the order by summing the prices of the products.
     */
    public void calculateTotalCost() {
        totalCost = 0;
        for (Product product : products) {
            totalCost += product.getPrice();
        }
    }

    /**
     * Retrieves the ID of the client who placed the order.
     *
     * @return the client ID associated with the order
     */
    public Integer getClientID() {
        return clientID;
    }

    /**
     * Retrieves the list of products included in the order.
     *
     * @return a list of {@code Product} objects in the order
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets a new order ID for this order.
     *
     * @param orderID the new order ID to set
     */
    public void setOrderID(Integer orderID) {
        this.ID = orderID;
    }

    /**
     * Calculates and updates the total reward points of the order based on the products.
     */
    public void calculatePoints() {
        points = 0;
        for (Product product : products) {
            points += product.getPoints();
        }
    }

    /**
     * Retrieves the total cost of the order.
     *
     * @return the total cost of the order
     */
    public int getTotalCost() {
        return totalCost;
    }

    /**
     * Retrieves the unique identifier of this order.
     *
     * @return the order ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Sets a new unique identifier for this order.
     *
     * @param ID the new ID to set for the order
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * Sets a new client ID for this order.
     *
     * @param clientID the new client ID to associate with the order
     */
    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    /**
     * Sets a new point value for this order.
     *
     * @param points the new points value to set for the order
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Sets a new total cost for this order.
     *
     * @param totalCost the new total cost to set for the order
     */
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Sets a new list of products for this order.
     *
     * @param products the new list of products to associate with the order
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Retrieves the unique identifier of this order, fulfilling the {@code HasID} interface contract.
     *
     * @return the order ID
     */
    @Override
    public Integer getId() {
        return ID;
    }

    /**
     * Returns a string representation of the order, including its ID, client ID, points, total cost, and products.
     *
     * @return a string representation of the order
     */
    @Override
    public String toString() {
        // Collect product names from the list of products
        String productNames = products.stream()
                .map(Product::getName)  // Assuming Product has a getName() method
                .collect(Collectors.joining(", "));  // Join names with commas

        return
                "ID=" + ID +
                ", clientID=" + clientID +
                ", points=" + points +
                ", price=" + totalCost +
                ", products=[" + productNames + "]" ;
    }
}
