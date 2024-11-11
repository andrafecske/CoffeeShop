package Models;

/**
 * The {@code Coffee} class represents a coffee product, inheriting from the {@code Product} class.
 * It includes additional properties specific to coffee, such as caffeine content and milk type.
 */
public class Coffee extends Product {

    /**
     * Indicates whether the coffee contains caffeine.
     */
    private Boolean hasCaffeine;

    /**
     * The type of milk used in the coffee.
     */
    private Enum MilkType;

    /**
     * Constructs a new {@code Coffee} product with the specified ID, price, points, name,
     * caffeine content, and milk type.
     *
     * @param productID   the unique identifier for the coffee product
     * @param price       the price of the coffee product
     * @param points      the reward points associated with the coffee product
     * @param name        the name of the coffee product
     * @param hasCaffeine indicates if the coffee contains caffeine
     * @param milkType    the type of milk used in the coffee
     */
    public Coffee(Integer productID, int price, int points, String name, boolean hasCaffeine, Enum milkType) {
        super(productID, price, points, name);
        this.hasCaffeine = hasCaffeine;
        this.MilkType = milkType;
    }

    /**
     * Retrieves the type of milk used in the coffee.
     *
     * @return the milk type as an {@code Enum}
     */
    public Enum getMilkType() {
        return MilkType;
    }

    /**
     * Sets a new milk type for the coffee.
     *
     * @param milkType the new milk type to set
     */
    public void setMilkType(Enum milkType) {
        this.MilkType = milkType;
    }

    /**
     * Checks if the coffee contains caffeine.
     *
     * @return {@code true} if the coffee contains caffeine, {@code false} otherwise
     */
    public Boolean getHasCaffeine() {
        return hasCaffeine;
    }

    /**
     * Sets the caffeine content of the coffee.
     *
     * @param hasCaffeine {@code true} if the coffee should contain caffeine, {@code false} otherwise
     */
    public void setHasCaffeine(Boolean hasCaffeine) {
        this.hasCaffeine = hasCaffeine;
    }

    /**
     * Returns a string representation of the coffee product, including caffeine content, milk type,
     * and inherited attributes such as ID, points, name, and price.
     *
     * @return a string representation of the coffee product
     */
    @Override
    public String toString() {
        return "Coffee{" +
                "hasCaffeine=" + hasCaffeine +
                ", MilkType=" + MilkType +
                ", ID=" + ID +
                ", points=" + points +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
