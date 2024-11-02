package Service;

import Models.Food;
import Repository.IRepository;
import Utils.FoodType;

import java.util.List;

public class FoodService {
    private final IRepository<Food> foodRepo;
    public FoodService(IRepository<Food> foodRepo) {
        this.foodRepo = foodRepo;
        initializeFoodRepo();
    }

    private void initializeFoodRepo(){
      Food food1 = new Food(1, 20, 50, "Chicken Sandwich", FoodType.SANDWICH);
      Food food2 = new Food(2, 26, 80, "Chickpea Salad", FoodType.MEAL);
    }

    public void addFood(Food food){
        if(food == null){
            System.out.println("Food is null");
            return;
        }

        foodRepo.create(food);
    }

    public List<Food> getAllFoods(){
        return foodRepo.getAll();
    }

    public Food getFoodById(int id){
        return  foodRepo.read(id);
    }
}
