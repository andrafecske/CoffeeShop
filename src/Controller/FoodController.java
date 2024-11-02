package Controller;

import Models.Food;
import Service.FoodService;
import java.util.List;

public class FoodController {
    private FoodService foodService;
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    public void addFood(Food food) {
        foodService.addFood(food);
        System.out.println("Food added");
    }

    public void listAllFoods() {
        List<Food> foodList = foodService.getAllFoods();

        if(foodList.isEmpty()) {
            System.out.println("No food found");
        }
        else {
            System.out.println("Food list:");
            for(Food food : foodList) {
                System.out.println(food);
            }
        }
    }

    public Food getFoodById(int id) {
        return foodService.getFoodById(id);
    }

}
