import Controller.*;
import Models.*;
import Presentation.AdminUI;
import Presentation.ClientUI;
import Presentation.UI;
import Repository.FileRepository;
import Repository.InMemoryRepository;
import Service.*;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        InMemoryRepository<Admin> adminRepo = new InMemoryRepository<>();
        InMemoryRepository<Client> clientRepo = new InMemoryRepository<>();
        InMemoryRepository<Food> foodRepo = new InMemoryRepository<>();
        InMemoryRepository<Coffee> coffeeRepo = new InMemoryRepository<>();
        InMemoryRepository<Order> OrderRepo = new InMemoryRepository<>();
        InMemoryRepository<Offer> OfferRepo = new InMemoryRepository<>();
        InMemoryRepository <OfferOrder> OfferOrderRepo = new InMemoryRepository<>();


        //andra
//        FileRepository<Admin> adminFileRepo = new FileRepository<>("C:\\Coding\\facultate\\MAP\\ProiectMAP\\src\\Files\\Admins.txt");
//        FileRepository<Client> clientFileRepo = new FileRepository<>("C:\\Coding\\facultate\\MAP\\ProiectMAP\\src\\Files\\Clients.txt");
//        FileRepository<Food> foodFileRepo = new FileRepository<>("C:\\Coding\\facultate\\MAP\\ProiectMAP\\src\\Files\\Foods.txt");
//        FileRepository<Coffee> coffeeFileRepo = new FileRepository<>("C:\\Coding\\facultate\\MAP\\ProiectMAP\\src\\Files\\Coffees.txt");
//        FileRepository<Order> orderFileRepo = new FileRepository<>("C:\\Coding\\facultate\\MAP\\ProiectMAP\\src\\Files\\Orders.txt");
//        FileRepository<Offer> offerFileRepo = new FileRepository<>("C:\\Coding\\facultate\\MAP\\ProiectMAP\\src\\Files\\Offers.txt");
//        FileRepository<OfferOrder> offerOrderFileRepo = new FileRepository<>("C:\\Coding\\facultate\\MAP\\ProiectMAP\\src\\Files\\OfferOrders.txt");

        //ale
        FileRepository<Admin> adminFileRepo = new FileRepository<>("/Users/alexandrabercu/CoffeeShop/src/FileAle/Admin2.txt");
        FileRepository<Client> clientFileRepo = new FileRepository<>("/Users/alexandrabercu/CoffeeShop/src/FileAle/Client2.txt");
        FileRepository<Food> foodFileRepo = new FileRepository<>("/Users/alexandrabercu/CoffeeShop/src/FileAle/Food2.txt");
        FileRepository<Coffee> coffeeFileRepo = new FileRepository<>("/Users/alexandrabercu/CoffeeShop/src/FileAle/Coffee2.txt");
        FileRepository<Offer> offerFileRepo = new FileRepository<>("/Users/alexandrabercu/CoffeeShop/src/FileAle/Offer2.txt");
        FileRepository<OfferOrder> offerOrderFileRepo = new FileRepository<>("/Users/alexandrabercu/CoffeeShop/src/FileAle/OfferOrder.txt");
        FileRepository<Order> orderFileRepo = new FileRepository<>("/Users/alexandrabercu/CoffeeShop/src/FileAle/Order2.txt");

        CoffeeShopService coffeeShopService = new CoffeeShopService(adminFileRepo,clientFileRepo,coffeeFileRepo,foodFileRepo,orderFileRepo,offerFileRepo, offerOrderFileRepo);

        CoffeeShopController coffeeShopController = new CoffeeShopController(coffeeShopService);

        System.out.println(coffeeShopController.listAllAdmins());




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
