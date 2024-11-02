package Service;

import Models.Coffee;
import Repository.IRepository;
import Utils.MilkType;

import java.util.List;

public class CoffeeService {
    private final IRepository<Coffee> coffeeRepo;

    public CoffeeService(IRepository<Coffee> coffeeRepo) {
        this.coffeeRepo = coffeeRepo;
        initializeCoffeeRepo();
    }

    private void initializeCoffeeRepo(){
        Coffee coffee1 = new Coffee(1, 23, 100, "Pumpkin Spice Latte", true, MilkType.WHOLE);
        Coffee coffe2 = new Coffee(2, 20, 89, "Caramel Large Latte", true, MilkType.WHOLE);
        coffeeRepo.create(coffee1);
        coffeeRepo.create(coffe2);
    }

    public void addCoffee(Coffee coffee){
        if(coffee == null){
            System.out.println("Coffee is null");
            return;
        }

        coffeeRepo.create(coffee);
    }

    public List<Coffee> getAllCoffee(){
        return coffeeRepo.getAll();
    }

    public Coffee getCoffeeById(int id){
        return coffeeRepo.read(id);
    }
}
