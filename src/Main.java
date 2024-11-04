import Controller.*;
import Models.*;
import Presentation.AdminUI;
import Presentation.ClientUI;
import Presentation.UI;
import Repository.InMemoryRepository;
import Service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create the repository
        InMemoryRepository<Admin> adminRepo = new InMemoryRepository<>();
        InMemoryRepository<Client> clientRepo = new InMemoryRepository<>();
        InMemoryRepository<Food> foodRepo = new InMemoryRepository<>();
        InMemoryRepository<Coffee> coffeeRepo = new InMemoryRepository<>();
        InMemoryRepository<Order> OrderRepo = new InMemoryRepository<>();

        CoffeeShopService coffeeShopService = new CoffeeShopService(adminRepo,clientRepo,coffeeRepo,foodRepo,OrderRepo);

        CoffeeShopController coffeeShopController = new CoffeeShopController(coffeeShopService);

//        // Set up the service with the repository
//        AdminService adminService = new AdminService(adminRepo);
//        ClientService clientService = new ClientService(clientRepo, adminRepo);
//        FoodService foodService = new FoodService(foodRepo);
//        CoffeeService coffeeService = new CoffeeService(coffeeRepo);
//        OrderService OrderService = new OrderService(OrderRepo, foodService, coffeeService);
//
//        // Create the controller with the service
//        AdminController adminController = new AdminController(adminService);
//        ClientController clientController = new ClientController(clientService);
//        FoodController foodController = new FoodController(foodService);
//        CoffeeController coffeeController = new CoffeeController(coffeeService);
//        OrderController orderController = new OrderController(OrderService,clientController);

        // Create a Scanner instance
        CoffeeShopController coffeeShopController2 = new CoffeeShopController(coffeeShopService);
        Scanner scanner = new Scanner(System.in);

        // Initialize the UI with the controller and Scanner
        AdminUI adminUi = new AdminUI(coffeeShopController , scanner);
        ClientUI clientUi = new ClientUI(coffeeShopController, scanner);

        // Initialize and start the main UI for login
        UI mainUI = new UI(coffeeShopController, adminUi, clientUi);
        mainUI.start();

        // Close the scanner at the end of the application
        scanner.close();
    }
}
