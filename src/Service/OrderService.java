package Service;

import Models.Coffee;
import Models.Food;
import Models.Order;
import Models.Product;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderService {


    private IRepository<Order> orderRepo;
    private FoodService foodService;
    private CoffeeService coffeeService;

    public OrderService(IRepository<Order> orderRepo, FoodService foodService, CoffeeService coffeeService) {
        this.orderRepo = orderRepo;
        this.foodService = foodService;
        this.coffeeService = coffeeService;
    }

    public Order addOrder(Integer clientID, List<Integer> foodIDs, List<Integer> coffeeIDs) {
        int orderId = generateOrderID();
        List<Product> products = new ArrayList<>();
        for (Integer foodID : foodIDs) {
            Food food = foodService.getFoodById(foodID);
            products.add(food);
        }
        for (Integer coffeeID : coffeeIDs) {
            Coffee coffee = coffeeService.getCoffeeById(coffeeID);
            products.add(coffee);
        }
        Order order = new Order(orderId,clientID, products);

        orderRepo.create(order);
        return order;
    }




    public List<Order> getOrders() {
        return orderRepo.getAll();
    }

    public Order getOrderById(Integer orderID) {
        return orderRepo.read(orderID);
    }

    public void finalizeOrder(Order order) {
        order.calculatePoints();
    }

    private int generateOrderID() {
        // Implement logic to generate a unique order ID
        // This could be based on a counter, a UUID, or any other unique identifier scheme
        return (int) (Math.random() * 10000);  // Simplified for example purposes
    }

}
