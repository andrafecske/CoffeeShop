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

        InMemoryRepository<Admin> adminRepo = new InMemoryRepository<>();
        InMemoryRepository<Client> clientRepo = new InMemoryRepository<>();
        InMemoryRepository<Food> foodRepo = new InMemoryRepository<>();
        InMemoryRepository<Coffee> coffeeRepo = new InMemoryRepository<>();
        InMemoryRepository<Order> OrderRepo = new InMemoryRepository<>();
        InMemoryRepository<Offer> OfferRepo = new InMemoryRepository<>();
        InMemoryRepository <OfferOrder> OfferOrderRepo = new InMemoryRepository<>();

        CoffeeShopService coffeeShopService = new CoffeeShopService(adminRepo,clientRepo,coffeeRepo,foodRepo,OrderRepo,OfferRepo, OfferOrderRepo);

        CoffeeShopController coffeeShopController = new CoffeeShopController(coffeeShopService);

        // Create a Scanner instance
        //CoffeeShopController coffeeShopController2 = new CoffeeShopController(coffeeShopService);
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
