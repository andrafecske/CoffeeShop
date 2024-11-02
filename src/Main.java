import Controller.AdminController;
import Controller.ClientController;
import Controller.CoffeeController;
import Controller.FoodController;
import Models.Admin;
import Models.Client;
import Models.Coffee;
import Models.Food;
import Presentation.AdminUI;
import Presentation.ClientUI;
import Presentation.UI;
import Repository.InMemoryRepository;
import Service.AdminService;
import Service.ClientService;
import Service.CoffeeService;
import Service.FoodService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create the repository
        InMemoryRepository<Admin> adminRepo = new InMemoryRepository<>();
        InMemoryRepository<Client> clientRepo = new InMemoryRepository<>();
        InMemoryRepository<Food> foodRepo = new InMemoryRepository<>();
        InMemoryRepository<Coffee> coffeeRepo = new InMemoryRepository<>();

        // Set up the service with the repository
        AdminService adminService = new AdminService(adminRepo);
        ClientService clientService = new ClientService(clientRepo, adminRepo);
        FoodService foodService = new FoodService(foodRepo);
        CoffeeService coffeeService = new CoffeeService(coffeeRepo);

        // Create the controller with the service
        AdminController adminController = new AdminController(adminService);
        ClientController clientController = new ClientController(clientService);
        FoodController foodController = new FoodController(foodService);
        CoffeeController coffeeController = new CoffeeController(coffeeService);

        // Create a Scanner instance
        Scanner scanner = new Scanner(System.in);

        // Initialize the UI with the controller and Scanner
        AdminUI adminUi = new AdminUI(adminController, clientController,coffeeController, foodController, scanner);
        ClientUI clientUi = new ClientUI(clientController, coffeeController, foodController, scanner);

        // Initialize and start the main UI for login
        UI mainUI = new UI(adminController, clientController, adminUi, clientUi);
        mainUI.start();

        // Close the scanner at the end of the application
        scanner.close();
    }
}
