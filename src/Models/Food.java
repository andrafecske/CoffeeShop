package Models;

import java.util.List;

public class Food extends Product {
    Enum FoodType;
    List<String> Ingredients;

    public Food(int productID, int points, String name) {
        super(productID, points, name);
    }

    public Enum getFoodType() {
        return FoodType;
    }
    public void setFoodType(Enum foodType) {
        FoodType = foodType;
    }
    public List<String> getIngredients() {
        return Ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        Ingredients = ingredients;
    }
}
