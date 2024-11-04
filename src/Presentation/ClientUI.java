package Presentation;

import Controller.ClientController;
import Controller.CoffeeController;
import Controller.FoodController;
import Controller.OrderController;
import Models.Client;
import Models.Food;
import Models.Order;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class ClientUI {

    private final ClientController clientController;
    private final CoffeeController coffeeController;
    private final FoodController foodController;
    private final OrderController orderController;
    private final Scanner scanner;
    private Integer id;
    public ClientUI(ClientController clientController, CoffeeController coffeeController, FoodController foodController, OrderController orderController, Scanner scanner) {
        this.clientController = clientController;
        this.coffeeController = coffeeController;
        this.foodController = foodController;
        this.orderController = orderController;
        this.scanner = scanner;
    }

    public void start(Integer id){
        boolean continueLoop = true;
        this.id = id;

        while(continueLoop){
            System.out.println("""
                    Coffee Shop
                    
                    1. View Clients
                    2. Add Client
                    3. View Menu
                    4. create Order
                    5. Exit
                    
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

                case"4":
                    List<Integer> foods = orderFood();
                    System.out.println(foods);
                    List<Integer> coffees = orderCoffee();
                    System.out.println(coffees);
                    Order order = orderController.addOrder(id, foods, coffees);
                    System.out.println("Order added successfully!" + order);

                    break;


                case "5":
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

    public List<Integer> orderFood(){
        List<Integer> foods = new ArrayList<>();
        while(true){
            foodController.listAllFoods();
            System.out.println("What food would you like to order? Enter the ID or press enter if you would like to stop ordering");
            String id = scanner.nextLine();
            if(id.isEmpty())
                break;
            Integer intId = Integer.parseInt(id);

            if(foodController.getFoodById(intId) != null){
                foods.add(intId);
            }
            else
            {
                System.out.println("Invalid ID");
            }

        }
        return foods;
    }

    public List<Integer> orderCoffee(){
        List<Integer> coffees = new ArrayList<>();
        while(true){
            coffeeController.listAllCoffees();
            System.out.println("What coffee would you like to order? Enter the ID or press enter if you would like to stop ordering");
            String id = scanner.nextLine();
            if(id.isEmpty())
                break;
            Integer intId = Integer.parseInt(id);
            if(coffeeController.getCoffeeById(intId) != null){
                coffees.add(intId);
            }
            else
            {
                System.out.println("Invalid ID");
            }
        }
        return coffees;
    }


}
