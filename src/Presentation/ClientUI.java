package Presentation;

import Controller.ClientController;
import Controller.CoffeeController;
import Controller.FoodController;
import Models.Client;

import java.util.Scanner;

public class ClientUI {

    private final ClientController clientController;
    private final CoffeeController coffeeController;
    private final FoodController foodController;
    private final Scanner scanner;
    public ClientUI(ClientController clientController, CoffeeController coffeeController, FoodController foodController, Scanner scanner) {
        this.clientController = clientController;
        this.coffeeController = coffeeController;
        this.foodController = foodController;
        this.scanner = scanner;
    }

    public void start(){
        boolean continueLoop = true;

        while(continueLoop){
            System.out.println("""
                    Coffee Shop
                    
                    1. View Clients
                    2. Add Client
                    3. View Menu
                    4. Exit
                    
                    """);
            System.out.println("Choose an option: ");
            String option = scanner.nextLine();

            switch(option){
                case "1":
                    clientController.listAllClients();
                    break;
                case"2":
                    addClient(scanner);
                    break;
                case "3":
                    System.out.println("Foods in the menu:");
                     foodController.listAllFoods();
                     System.out.println("Coffe menu:");
                     coffeeController.listAllCoffees();
                     break;
                case "4":
                    continueLoop = false;

            }
        }
    }



    private void addClient(Scanner scanner){
            System.out.println("Enter Client ID:");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter Age:");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Name:");
            String name = scanner.nextLine();

            Client client = new Client(id, age, name);
            clientController.addClient(client);
    }


}
