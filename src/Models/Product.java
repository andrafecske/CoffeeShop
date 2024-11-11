package Models;

/**
 * The {@code Product} class represents a product with a unique ID, price, reward points, and name.
 * This class implements the {@code HasID} interface, providing the method to retrieve the unique ID of the product.
 */
public class Product implements HasID {

    /**
     * The unique identifier for this product.
     */
    protected Integer ID;

    /**
     * The reward points associated with this product.
     */
    protected int points;

    /**
     * The price of this product.
     */
    protected int price;

    /**
     * The name of this product.
     */
    protected String name;

    /**
     * Constructs a new {@code Product} with the specified ID, price, points, and name.
     *
     * @param ID     the unique identifier for this product
     * @param price  the price of this product
     * @param points the reward points associated with this product
     * @param name   the name of this product
     */
    public Product(Integer ID, int price, int points, String name) {
        this.ID = ID;
        this.price = price;
        this.points = points;
        this.name = name;
    }

    /**
     * Retrieves the unique ID of this product.
     *
     * @return the ID of this product
     */
    public Integer getProductID() {
        return ID;
    }

    /**
     * Sets a new unique ID for this product.
     *
     * @param ID the new ID to set for this product
     */
    public void setProductID(Integer ID) {
        this.ID = ID;
    }

    /**
     * Retrieves the reward points associated with this product.
     *
     * @return the points associated with this product
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the reward points for this product.
     *
     * @param points the new points to associate with this product
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Retrieves the name of this product.
     *
     * @return the name of this product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for this product.
     *
     * @param name the new name to set for this product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of this product.
     *
     * @return the price of this product
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price for this product.
     *
     * @param price the new price to set for this product
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retrieves the unique identifier of this product, fulfilling the {@code HasID} interface contract.
     *
     * @return the ID of this product
     */
    @Override
    public Integer getId() {
        return ID;
    }
}
