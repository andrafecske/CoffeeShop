package Controller;

import Models.Coffee;
import Models.Food;
import Service.CoffeeService;

import java.util.List;

public class CoffeeController {
    private CoffeeService coffeeService;
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    public void addCoffee(Coffee coffee) {
        coffeeService.addCoffee(coffee);
        System.out.println("Coffee added");
    }

    public void listAllCoffees() {
        List<Coffee> coffeeList = coffeeService.getAllCoffee();
        if(coffeeList.isEmpty())
                System.out.println("There are no coffees");
        else{
            for (Coffee coffee : coffeeList) {
                System.out.println(coffee);
            }
        }

    }

    public Coffee getCoffeeById(int id) {
        return coffeeService.getCoffeeById(id);
    }
}
