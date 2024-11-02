package Models;

import java.util.List;

public class Food extends Product {
    Enum FoodType ;

    public Food(Integer productID, int price, int points, String name, Enum FoodType) {
        super(productID, price, points, name);
        this.FoodType = FoodType;
    }

    public Enum getFoodType() {
        return FoodType;
    }
    public void setFoodType(Enum foodType) {
        FoodType = foodType;
    }

}
