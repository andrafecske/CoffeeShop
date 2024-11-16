package Models;

import java.util.List;

/**
 * The {@code Food} class represents a food product, inheriting from the {@code Product} class.
 * It includes additional properties specific to food items, such as the food type.
 */
public class Food extends Product {

    /**
     * The type of food, represented as an enum.
     */
    private Enum FoodType;

    /**
     * Constructs a new {@code Food} product with the specified ID, price, points, name, and food type.
     *
     * @param productID the unique identifier for the food product
     * @param price     the price of the food product
     * @param points    the reward points associated with the food product
     * @param name      the name of the food product
     * @param foodType  the type of food (e.g., appetizer, main course, dessert)
     */
    public Food(Integer productID, int price, int points, String name, Enum foodType) {
        super(productID, price, points, name);
        this.FoodType = foodType;
    }

    /**
     * Retrieves the type of food.
     *
     * @return the food type as an {@code Enum}
     */
    public Enum getFoodType() {
        return FoodType;
    }

    /**
     * Sets a new food type for this food item.
     *
     * @param foodType the new food type to set
     */
    public void setFoodType(Enum foodType) {
        this.FoodType = foodType;
    }

    /**
     * Returns a string representation of the food product, including its ID, points, price, name, and food type.
     *
     * @return a string representation of the food product
     */
    @Override
    public String toString() {
        return
                "ID=" + ID +
                ", points=" + points +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", FoodType=" + FoodType +
                 '\n';
    }


}
