package Presentation;

import Controller.*;
import Models.*;
import Utils.Role;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class ClientUI {

    private final CoffeeShopController coffeeShopController;
    private final Scanner scanner;
    private Integer id; //id of the client
    public ClientUI(CoffeeShopController coffeeShopController, Scanner scanner) {
        this.coffeeShopController = coffeeShopController;
        this.scanner = scanner;
    }

    public void start(Integer id){
        boolean continueLoop = true;
        this.id = id;

        while(continueLoop){
            System.out.println("""
                    Coffee Shop
                    
                   
                    1. View Menu
                    2. Create Order
                    3. Update Order
                    4. Delete Order
                    5. View my points
                    6. Claim offers
                    7. View your orders
                    8. Sort orders by price
                    9. Exit
                    
                    """);
            System.out.println("Choose an option: ");
            String option = scanner.nextLine();

            switch(option){
                case "1":
                    System.out.println("Foods in the menu:");
                     coffeeShopController.listAllFoods();
                     System.out.println("Coffee menu:");
                     coffeeShopController.listAllCoffees();
                     break;

                case"2":
                    List<Integer> foods = orderFood();
                    System.out.println(foods);
                    List<Integer> coffees = orderCoffee();
                    System.out.println(coffees);
                    Order order = coffeeShopController.addOrder(id, foods, coffees);
                    System.out.println("Order added successfully!" + order);

                    break;

                case "3":
                    updateOrder(scanner);
                    break;

                case "4":
                    deleteOrder(scanner);
                    break;

                case "5":
                    viewPoints();
                    break;

                case "6":
                    viewPoints();
                    coffeeShopController.listAllOffers();
                    System.out.println("Here are the available offers, enter ID of the one you want to use:");
                    int offerID = Integer.parseInt(scanner.nextLine());
                    coffeeShopController.addOfferOrder(offerID, id);
                    viewPoints();
                    break;

                case"7":
                    viewOrders();
                    break;

                case"8":
                    System.out.println("Your orders sorted by price:");
                    List<Order> orders = coffeeShopController.sortClientOrdersByPrice(id);
                    for(Order order1 : orders){
                        System.out.println(order1);
                    }
                    break;

                case "9":
                    continueLoop = false;
                    break;

            }
        }
    }

    /**
     * Allows the client to order food items from the coffee shop menu.
     * The method repeatedly lists all available foods and prompts the client
     * to enter the ID of the food they would like to order. The client can
     * add multiple food items to their order. The client can stop ordering
     * by pressing Enter without entering a food ID.
     *
     * @return A list of food IDs that the client has selected to order.
     */
    public List<Integer> orderFood(){
        List<Integer> foods = new ArrayList<>();
        while(true){
            coffeeShopController.listAllFoods();
            System.out.println("What food would you like to order? Enter the ID or press enter if you would like to stop ordering");
            String id = scanner.nextLine();
            if(id.isEmpty())
                break;
            Integer intId = Integer.parseInt(id);

            if(coffeeShopController.getFoodById(intId) != null){
                foods.add(intId);
            }
            else
            {
                System.out.println("Invalid ID");
            }

        }
        return foods;
    }

    /**
     * Allows the client to order coffee items from the coffee shop menu.
     * The method repeatedly lists all available coffees and prompts the client
     * to enter the ID of the coffee they would like to order. The client can
     * add multiple coffee items to their order. The client can stop ordering
     * by pressing Enter without entering a coffee ID.
     *
     * @return A list of coffee IDs that the client has selected to order.
     */
    public List<Integer> orderCoffee(){
        List<Integer> coffees = new ArrayList<>();
        while(true){
            coffeeShopController.listAllCoffees();
            System.out.println("What coffee would you like to order? Enter the ID or press enter if you would like to stop ordering");
            String id = scanner.nextLine();
            if(id.isEmpty())
                break;
            Integer intId = Integer.parseInt(id);
            if(coffeeShopController.getCoffeeById(intId) != null){
                coffees.add(intId);
            }
            else
            {
                System.out.println("Invalid ID");
            }
        }
        return coffees;
    }

    /**
     * Allows the client to delete an existing order by entering the order ID.
     * The method retrieves the order from the coffee shop controller by ID
     * and deletes it. If the order is found, it will be deleted; otherwise,
     * an error message will be displayed.
     *
     * @param scanner The scanner object used to read input from the client.
     */
    private void deleteOrder(Scanner scanner){
        try {
            System.out.print("Enter the ID of the Order to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Order orderToDelete = coffeeShopController.getOrderById(id);

            if (orderToDelete != null) {
                coffeeShopController.deleteOrder(orderToDelete, orderToDelete.getClientID());  // Pass the Admin object to delete
                System.out.println("Order with ID " + id + " has been deleted.");
            } else {
                System.out.println("Order with ID " + id + " not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for ID.");
        }
    }

    /**
     * Allows the client to update an existing order by providing the order ID.
     * The method displays the current products in the order, and then prompts
     * the client to add or remove foods and coffees from the order.
     *
     * It ensures that only valid food and coffee IDs are added or removed.
     * After making changes, the order is updated and displayed.
     *
     * @param scanner The scanner object used to read input from the client.
     */
    private void updateOrder(Scanner scanner){
        try {
            System.out.print("Enter the ID of the Order to update: ");
            viewOrders();
            int id = Integer.parseInt(scanner.nextLine());

            // Retrieve the existing Admin
            Order existingOrder = coffeeShopController.getOrderById(id);
            if (existingOrder == null) {
                System.out.println("Order with ID " + id + " not found.");
                return;
            }

            // Prompt for Age
            System.out.println("Current Products in Order: " + existingOrder.getProducts());
            System.out.println("Foods: "+ coffeeShopController.getFoods(existingOrder));
            System.out.println("Coffee: "+ coffeeShopController.getCoffees(existingOrder));

            System.out.print("Enter new Foods (comma-separated IDs), or press Enter to keep the existing Foods: ");
            String foodInput = scanner.nextLine();

            List<Food> additionalFoods;
            if (foodInput.isEmpty()) {
                System.out.println("No new foods added");// Keep existing products
            } else {
                additionalFoods = new ArrayList<>();
                String[] productIds = foodInput.split(",");
                for (String productId : productIds) {
                    try {
                        int productIdInt = Integer.parseInt(productId.trim());
                        Food food = coffeeShopController.getFoodById(productIdInt);
                        if (food != null) {
                            additionalFoods.add(food);
                            System.out.println("Item successfully added");
                        } else {
                            System.out.println("Food with ID " + productIdInt + " not found. Skipping.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid product ID: " + productId + ". Skipping.");
                    }

                }
                if(!additionalFoods.isEmpty()) {
                    existingOrder.getProducts().addAll(additionalFoods);
                }
            }

            System.out.print("Enter new Coffees (comma-separated IDs), or press Enter to keep the existing Coffees: ");
            String coffeeInput = scanner.nextLine();

            List<Coffee> additionalCoffees;
            if (coffeeInput.isEmpty()) {
                System.out.println("No new coffees added");// Keep existing products
            } else {
                additionalCoffees = new ArrayList<>();
                String[] productIds = coffeeInput.split(",");
                for (String productId : productIds) {
                    try {
                        int productIdInt = Integer.parseInt(productId.trim());
                        Coffee coffee = coffeeShopController.getCoffeeById(productIdInt);
                        if (coffee != null) {
                            additionalCoffees.add(coffee);
                            System.out.println("Item successfully added");
                        } else {
                            System.out.println("Coffee with ID " + productIdInt + " not found. Skipping.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid product ID: " + productId + ". Skipping.");
                    }
                }
             if(!additionalCoffees.isEmpty()){
                    existingOrder.getProducts().addAll(additionalCoffees);
                }
            }


            System.out.print("Enter the IDs of Foods to remove (comma-separated), or press Enter to skip: ");
            String foodRemoveInput = scanner.nextLine();
            if (!foodRemoveInput.isEmpty()) {
                String[] foodIds = foodRemoveInput.split(",");
                for (String foodId : foodIds) {
                    try {
                        int foodIdInt = Integer.parseInt(foodId.trim());
                        boolean removed = coffeeShopController.removeFoodById(foodIdInt, existingOrder);
                        if (removed) {
                            System.out.println("Food with ID " + foodIdInt + " removed.");
                        } else {
                            System.out.println("Food with ID " + foodIdInt + " not found in order. Skipping.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Food ID: " + foodId + ". Skipping.");
                    }
                }
            }

            // Enter and Remove Coffees
            System.out.print("Enter the IDs of Coffees to remove (comma-separated), or press Enter to skip: ");
            String coffeeRemoveInput = scanner.nextLine();
            if (!coffeeRemoveInput.isEmpty()) {
                String[] coffeeIds = coffeeRemoveInput.split(",");
                for (String coffeeId : coffeeIds) {
                    try {
                        int coffeeIdInt = Integer.parseInt(coffeeId.trim());
                        boolean removed = coffeeShopController.removeCoffeeById(coffeeIdInt, existingOrder);
                        if (removed) {
                            System.out.println("Coffee with ID " + coffeeIdInt + " removed.");
                        } else {
                            System.out.println("Coffee with ID " + coffeeIdInt + " not found in order. Skipping.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Coffee ID: " + coffeeId + ". Skipping.");
                    }
                }
            }


            coffeeShopController.updateOrder(existingOrder, existingOrder.getClientID());
            System.out.println("Order updated successfully.");
            System.out.println(existingOrder);


        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input.");
        }


        }

    /**
     * Displays the current points of the client.
     *
     * This method calls the controller's `viewPoints` method, passing the current
     * client's ID, to retrieve and display the number of points the client has earned.
     */
        public void viewPoints(){
        coffeeShopController.viewPoints(id);
        }

    /**
     * Displays all the orders placed by the current client.
     * The method retrieves the list of all orders and filters them based on the
     * client's ID, showing only the orders that belong to the client.
     *
     * It prints each order in the console.
     */
        public void viewOrders(){
            List<Order> orders = coffeeShopController.getAllOrders();
            for(Order order : orders){
                if(order.getClientID().equals(id))
                    System.out.println(order);
            }
        }


}



