package Presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.*;
import Models.*;
import Utils.FoodType;
import Utils.Role;
import Utils.MilkType;

    public class AdminUI {
        private final CoffeeShopController controller;
        private final Scanner scanner;

        public AdminUI(CoffeeShopController controller, Scanner scanner) {
            this.controller = controller;
            this.scanner = scanner;
        }

        public void start() {
            boolean continueLoop = true;

            while (continueLoop) {
                System.out.println("""
                     Coffee Shop Management System
                     
                     1. Admin Management
                     2. Client Management
                     3. Food Management
                     4. View all orders ever
                     5. Offer Management
                     6. Exit
                     """);
                System.out.print("Choose a category: ");
                String mainOption = scanner.nextLine();

                switch (mainOption) {
                    case "1":
                        manageAdmins(scanner);
                        break;

                    case "2":
                        manageClients(scanner);
                        break;

                    case "3":
                        manageFood(scanner);
                        break;

                    case "4":
                        viewOrders();
                        break;

                    case "5":
                        manageOffers(scanner);
                        break;

                    case "6":
                        continueLoop = false;
                        System.out.println("Exiting... Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        // Admin Management Operations
        private void manageAdmins(Scanner scanner) {
            boolean adminLoop = true;
            while (adminLoop) {
                System.out.println("""
                     Admin Management
                     
                     1. View all admins
                     2. Add admin
                     3. Update admin
                     4. Delete admin
                     5. Back to main menu
                     """);
                System.out.print("Choose an option: ");
                String adminOption = scanner.nextLine();

                switch (adminOption) {
                    case "1":
                        controller.listAllAdmins();
                        break;

                    case "2":
                        addAdmin(scanner);
                        break;

                    case "3":
                        updateAdmin(scanner);
                        break;

                    case "4":
                        deleteAdmin(scanner);
                        break;

                    case "5":
                        adminLoop = false;
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        // Client Management Operations
        private void manageClients(Scanner scanner) {
            boolean clientLoop = true;
            while (clientLoop) {
                System.out.println("""
                     Client Management
                     
                     1. View all clients
                     2. Add client
                     3. Update client
                     4. Delete client
                     5. Back to main menu
                     """);
                System.out.print("Choose an option: ");
                String clientOption = scanner.nextLine();

                switch (clientOption) {
                    case "1":
                        controller.listAllClients();
                        break;

                    case "2":
                        addClient(scanner);
                        break;

                    case "3":
                        updateClient(scanner);
                        break;

                    case "4":
                        deleteClient(scanner);
                        break;

                    case "5":
                        clientLoop = false;
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        // Food Management Operations
        private void manageFood(Scanner scanner) {
            boolean foodLoop = true;
            while (foodLoop) {
                System.out.println("""
                     Food Management
                     
                     1. View all food items
                     2. Add food item
                     3. Update food item
                     4. Delete food item
                     5. View all coffee items
                     6. Add coffee item
                     7. Update coffee item
                     8. Delete coffee item
                     9. Back to main menu
                     """);
                System.out.print("Choose an option: ");
                String foodOption = scanner.nextLine();

                switch (foodOption) {
                    case "1":
                        controller.listAllFoods();
                        break;

                    case "2":
                        addFood(scanner);
                        break;

                    case "3":
                        updateFood(scanner);
                        break;

                    case "4":
                        deleteFood(scanner);
                        break;

                    case "5":
                        controller.listAllCoffees();
                        break;
                    case "6":
                        addCoffee(scanner);
                        break;
                    case "7":
                        updateCoffee(scanner);
                        break;
                    case "8":
                        deleteCoffee(scanner);
                        break;

                    case "9":
                        foodLoop = false;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        private void manageOffers(Scanner scanner) {
            boolean offerLoop = true;
            while (offerLoop) {
                System.out.println("""
                    Offer Management
                    
                    1. View all offers
                    2. Add offer
                    3. Delete offer
                    
                    4. Back to main menu""");

                System.out.print("Choose an option: ");
                String offerOption = scanner.nextLine();

                switch (offerOption) {
                    case "1":
                        viewOffers();
                        break;

                    case "2":
                        List<Integer> foods = offerFood(scanner);
                        System.out.println(foods);
                        List<Integer> coffees = offerCoffee(scanner);
                        System.out.println(coffees);
                        System.out.println("How many points does this offer cost? ");
                        int points = Integer.parseInt(scanner.nextLine());
                        Offer offer = controller.addOffer(foods, coffees, points);
                        System.out.println("Offer added successfully!" + offer);
                        break;

                    case "3":
                        System.out.println("Current active offers: ");
                        viewOffers();
                        deleteOffer(scanner);
                        break;

                    case "4":
                        offerLoop = false;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;

                }
            }
        }

        /**
         * Adds a new admin to the system by prompting the user for necessary details such as ID, age, name, and role.
         * Validates inputs and catches any format issues with ID and age entries.
         *
         * @param scanner The Scanner used for user input.
         */
    private void addAdmin(Scanner scanner) {
        try {
            System.out.print("Enter Admin ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Admin Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Admin Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Admin Role (Manager/Client Manager/Product manager): ");
            String roleInput = scanner.nextLine();
            Role role;

            // Check if input matches a valid role
            if ("Manager".equalsIgnoreCase(roleInput)) {
                role = Role.Manager;
            } else if ("ProductManager".equalsIgnoreCase(roleInput)) {
                role = Role.ProductManager;
            } else {
                role = Role.ClientManager;
            }

            // Create a new Admin and add it using the controller
            Admin admin = new Admin(id, age, name, role);
            controller.addAdmin(admin);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numbers for ID and age.");
        }
    }

        /**
         * Adds a new admin to the system by prompting the user for necessary details such as ID, age, name, and role.
         * Validates inputs and catches any format issues with ID and age entries.
         *
         * @param scanner The Scanner used for user input.
         */
    private void updateAdmin(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the Admin to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Retrieve the existing Admin
            Admin existingAdmin = controller.getAdminById(id);
            if (existingAdmin == null) {
                System.out.println("Admin with ID " + id + " not found.");
                return;
            }

            // Prompt for Age
            System.out.print("Enter new Age (or press Enter to keep " + existingAdmin.getAge() + "): ");
            String ageInput = scanner.nextLine();
            int age;
            if (ageInput.isEmpty()) {
                age = existingAdmin.getAge(); // Keep the existing age
            } else {
                age = Integer.parseInt(ageInput); // Use the new age
            }

            // Prompt for Name
            System.out.print("Enter new Name (or press Enter to keep '" + existingAdmin.getName() + "'): ");
            String nameInput = scanner.nextLine();
            String name;
            if (nameInput.isEmpty()) {
                name = existingAdmin.getName(); // Keep the existing name
            } else {
                name = nameInput; // Use the new name
            }

            // Prompt for Role
            System.out.print("Enter new Role (or press Enter to keep " + existingAdmin.getRole() + "): ");
            String roleInput = scanner.nextLine();
            Role role;
            if (roleInput.isEmpty()) {
                role = existingAdmin.getRole(); // Keep the existing role
            } else {
                role = giveRole(roleInput); // Use the new role
            }

            // Update the Admin
            Admin updatedAdmin = new Admin(id, age, name, role);
            controller.updateAdmin(updatedAdmin);
            System.out.println("Admin updated successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for age.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role input. Please enter a valid role.");
        }
    }


    private Role giveRole(String roleInput) {
        if ("Manager".equalsIgnoreCase(roleInput)) {
            return Role.Manager;
        } else if ("ProductManager".equalsIgnoreCase(roleInput)) {
            return Role.ProductManager;
        } else {
            return Role.ClientManager;
        }
    }

        /**
         * Deletes an existing admin from the system by prompting the user for the admin's ID.
         * If the admin is found, it is removed from the system; otherwise, an appropriate message is displayed.
         * Handles invalid ID input gracefully.
         *
         * @param scanner The Scanner used for user input.
         */
    private void deleteAdmin(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the Admin to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Admin adminToDelete = controller.getAdminById(id);

            if (adminToDelete != null) {
                controller.deleteAdmin(adminToDelete);  // Pass the Admin object to delete
                System.out.println("Admin with ID " + id + " has been deleted.");
            } else {
                System.out.println("Admin with ID " + id + " not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for ID.");
        }
    }

        /**
         * Adds a new client to the system by prompting the user for the client's ID, age, and name.
         * After gathering the required information, it creates a new Client object and adds it to the system.
         *
         * @param scanner The Scanner used for user input.
         */
    private void addClient(Scanner scanner){
        System.out.println("Enter Client ID:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        Client client = new Client(id, age, name);
        controller.addClient(client);
    }

        /**
         * Adds a new food item to the system by prompting the user for the food's ID, name, points, price, and type.
         * Validates the food type input and creates a new Food object, which is then added to the system.
         *
         * @param scanner The Scanner used for user input.
         */
    private void addFood(Scanner scanner){
        System.out.println("Enter Food ID:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Food Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Food Points:");
        int points = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Food price:");
        int price = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter FoodType (SNACK/SANDWICH/DESSERT/MEAL): ");
        String typeInput = scanner.nextLine();
        FoodType type;
        if("SNACK".equalsIgnoreCase(typeInput)) {
            type = FoodType.SNACK;
        }else if("SANDWICH".equalsIgnoreCase(typeInput)) {
            type = FoodType.SANDWICH;
        } else if ("DESSERT".equalsIgnoreCase(typeInput)) {
            type = FoodType.DESSERT;
        } else if ("MEAL".equalsIgnoreCase(typeInput)) {
            type = FoodType.MEAL;
        }
        else{
            System.out.println("Invalid input. Please enter a valid food type.");
            return;
        }

        Food food = new Food(id, price,points,name,type);
        controller.addFood(food);
        System.out.println("Food added successfully");

    }

        /**
         * Adds a new coffee item to the system by prompting the user for the coffee's ID, price, points, name,
         * milk type, and caffeine content. Validates the milk type input and creates a new Coffee object,
         * which is then added to the system.
         *
         * @param scanner The Scanner used for user input.
         */
    private void addCoffee(Scanner scanner){
        System.out.println("Enter Coffee ID:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter price:");
        int price = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Coffee points:");
        int points = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Coffee name:");
        String name = scanner.nextLine();

        System.out.print("Enter Milk Type (WHOLE/SKIM/SOY/ALMOND/OAT/NONE): ");
        String milkTypeInput = scanner.nextLine();
        MilkType milkType;

        if ("WHOLE".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.WHOLE;
        } else if ("SKIM".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.SKIM;
        } else if ("SOY".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.SOY;
        } else if ("ALMOND".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.ALMOND;
        } else if ("OAT".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.OAT;
        } else if ("NONE".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.NONE;
        } else {
            System.out.println("Invalid input. Please enter a valid milk type.");
            return;
        }

        System.out.println("Does it contain caffeine?");
        boolean containsCaffeine = Boolean.parseBoolean(scanner.nextLine());


        Coffee coffee = new Coffee(id, price, points, name, containsCaffeine, milkType);
        controller.addCoffee(coffee);
    }

        /**
         * Deletes an existing coffee item from the system by prompting the user for the coffee's ID.
         * If the coffee item is found, it is removed from the system; otherwise, an appropriate message is displayed.
         * Handles invalid ID input gracefully.
         *
         * @param scanner The Scanner used for user input.
         */
    private void deleteCoffee(Scanner scanner){
        try {
            System.out.print("Enter the ID of the Coffee to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Coffee coffeeToDelete = controller.getCoffeeById(id);

            if (coffeeToDelete != null) {
                controller.deleteCoffee(coffeeToDelete);  // Pass the Admin object to delete
                System.out.println("Coffee with ID " + id + " has been deleted.");
            } else {
                System.out.println("Coffee with ID " + id + " not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for ID.");
        }

    }

        /**
         * Updates the details of an existing client by prompting the user for the client's ID, age, and name.
         * Allows the user to retain the current values by pressing Enter without typing new information.
         * If the client ID is invalid, an appropriate message is displayed.
         *
         * @param scanner The Scanner used for user input.
         */
    private void updateClient(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the Client to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Retrieve the existing Admin
            Client existingClient = controller.getClientById(id);
            if (existingClient == null) {
                System.out.println("Client with ID " + id + " not found.");
                return;
            }

            // Prompt for Age
            System.out.print("Enter new Age (or press Enter to keep " + existingClient.getAge() + "): ");
            String ageInput = scanner.nextLine();
            int age;
            if (ageInput.isEmpty()) {
                age = existingClient.getAge(); // Keep the existing age
            } else {
                age = Integer.parseInt(ageInput); // Use the new age
            }

            // Prompt for Name
            System.out.print("Enter new Name (or press Enter to keep '" + existingClient.getName() + "'): ");
            String nameInput = scanner.nextLine();
            String name;
            if (nameInput.isEmpty()) {
                name = existingClient.getName(); // Keep the existing name
            } else {
                name = nameInput; // Use the new name
            }


            Client updatedClient = new Client(id, age, name);
            controller.updateClient(updatedClient);
            System.out.println("Client updated successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for age.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role input. Please enter a valid role.");
        }
    }

        /**
         * Deletes an existing client from the system by prompting the user for the client's ID.
         * If the client is found, it is removed from the system; otherwise, an appropriate message is displayed.
         * Handles invalid ID input gracefully.
         *
         * @param scanner The Scanner used for user input.
         */
    private void deleteClient(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the Client to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Client clientToDelete = controller.getClientById(id);

            if (clientToDelete != null) {
                controller.deleteClient(clientToDelete);  // Pass the Admin object to delete
                System.out.println("Client with ID " + id + " has been deleted.");
            } else {
                System.out.println("Client with ID " + id + " not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for ID.");
        }
    }

        /**
         * Updates the details of an existing coffee item by prompting the user for the coffee's ID, price, points,
         * name, caffeine content, and milk type. The user can choose to retain the current values by pressing Enter
         * without providing new input. If the coffee item with the given ID is not found, an appropriate message is displayed.
         *
         * @param scanner The Scanner used for user input.
         */
    private void updateCoffee(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the coffee to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Retrieve the existing Admin
            Coffee existingCoffee = controller.getCoffeeById(id);
            if (existingCoffee == null) {
                System.out.println("Coffee with ID " + id + " not found.");
                return;
            }

            // Prompt for Age
            System.out.print("Enter new price(or press Enter to keep " + existingCoffee.getPrice() + "): ");
            String priceInput = scanner.nextLine();
            int price;
            if (priceInput.isEmpty()) {
                price = existingCoffee.getPrice(); // Keep the existing age
            } else {
                price = Integer.parseInt(priceInput); // Use the new age
            }

            System.out.print("Enter new number of points(or press Enter to keep " + existingCoffee.getPoints() + ")points: ");
            String pointsInput = scanner.nextLine();
            int points;
            if (pointsInput.isEmpty()) {
                points = existingCoffee.getPoints(); // Keep the existing age
            } else {
                points = Integer.parseInt(pointsInput); // Use the new age
            }

            // Prompt for Name
            System.out.print("Enter new Name (or press Enter to keep '" + existingCoffee.getName() + "'): ");
            String nameInput = scanner.nextLine();
            String name;
            if (nameInput.isEmpty()) {
                name = existingCoffee.getName(); // Keep the existing name
            } else {
                name = nameInput; // Use the new name
            }

            System.out.print("Does it have caffeine? true/false (or press Enter to keep '" + existingCoffee.getHasCaffeine() + "'): ");
            String hasCaffeine = scanner.nextLine();
            boolean containsCaffeine = Boolean.parseBoolean(hasCaffeine);
//            if (hasCaffeine == "yes")
//                existingCoffee.setHasCaffeine(true);
//            else
//                existingCoffee.setHasCaffeine(false);

            System.out.print("Enter new MilkType (or press Enter to keep '" + existingCoffee.getMilkType() + "'): ");
            String milkTypeInput = scanner.nextLine();
            MilkType milkType = (MilkType) existingCoffee.getMilkType();
            if ("WHOLE".equalsIgnoreCase(milkTypeInput)) {
                milkType = MilkType.WHOLE;
            } else if ("SKIM".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.SKIM;
        } else if ("SOY".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.SOY;
        } else if ("ALMOND".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.ALMOND;
        } else if ("OAT".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.OAT;
        } else if ("NONE".equalsIgnoreCase(milkTypeInput)) {
            milkType = MilkType.NONE;
        } else {
            System.out.println("Invalid input. Please enter a valid milk type.");
            return;
        }


            Coffee updatedCoffee = new Coffee(id,price,points,name,containsCaffeine,milkType);
            controller.updateCoffee(updatedCoffee);
            System.out.println("Coffee updated successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for price or points.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

        /**
         * Deletes an existing food item from the system by prompting the user for the food's ID.
         * If the food item is found, it is removed from the system; otherwise, an appropriate message is displayed.
         * Handles invalid ID input gracefully.
         *
         * @param scanner The Scanner used for user input.
         */
    private void deleteFood(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the Food to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Food foodToDelete = controller.getFoodById(id);

            if (foodToDelete != null) {
                controller.deleteFood(foodToDelete);  // Pass the Admin object to delete
                System.out.println("Food with ID " + id + " has been deleted.");
            } else {
                System.out.println("Food with ID " + id + " not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for ID.");
        }
    }

        /**
         * Updates an existing food item in the system by prompting the user for the food's ID and new values.
         * If the food item is found, its details can be updated; otherwise, an error message is displayed.
         * Handles invalid input for price, points, and food type, ensuring valid data is provided before updating.
         *
         * @param scanner The Scanner used for user input.
         */
    private void updateFood(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the food to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Retrieve the existing Admin
            Food existingFood = controller.getFoodById(id);
            if (existingFood == null) {
                System.out.println("Food with ID " + id + " not found.");
                return;
            }

            // Prompt for Age
            System.out.print("Enter new price(or press Enter to keep " + existingFood.getPrice() + "): ");
            String priceInput = scanner.nextLine();
            int price;
            if (priceInput.isEmpty()) {
                price = existingFood.getPrice(); // Keep the existing age
            } else {
                price = Integer.parseInt(priceInput); // Use the new age
            }

            System.out.print("Enter new number of points(or press Enter to keep " + existingFood.getPoints() + ")points: ");
            String pointsInput = scanner.nextLine();
            int points;
            if (pointsInput.isEmpty()) {
                points = existingFood.getPoints(); // Keep the existing age
            } else {
                points = Integer.parseInt(pointsInput); // Use the new age
            }

            // Prompt for Name
            System.out.print("Enter new Name (or press Enter to keep '" + existingFood.getName() + "'): ");
            String nameInput = scanner.nextLine();
            String name;
            if (nameInput.isEmpty()) {
                name = existingFood.getName(); // Keep the existing name
            } else {
                name = nameInput; // Use the new name
            }

            System.out.print("Enter FoodType (SNACK/SANDWICH/DESSERT/MEAL) (or press Enter to keep '" + existingFood.getFoodType() + "'): ");
            String typeInput = scanner.nextLine();
            FoodType type;
                try {
                    type = FoodType.valueOf(typeInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please enter a valid food type (SNACK, SANDWICH, DESSERT, MEAL).");
                    return;
                }



            // Update the Admin
            Food updatedFood = new Food(id, price, points,name, type);
            controller.updateFood(updatedFood);
            System.out.println("Food updated successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for price or points.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void viewOrders(){
        controller.viewOrders();
    }

    public void viewOffers(){
        controller.listAllOffers();
    }

        /**
         * Allows the user to select food items to add to an offer by entering their IDs.
         * The user can continue adding foods until they press Enter without entering an ID.
         * After each input, the method checks if the food ID exists, and if valid, adds it to the list.
         *
         * @param scanner The Scanner used to read user input.
         * @return A list of food IDs that the user selected for the offer.
         */
    public List<Integer> offerFood(Scanner scanner) {
        List<Integer> foods = new ArrayList<>();
        while(true){
            controller.listAllFoods();
            System.out.println("What food would you like to add to the offer? Enter the ID or press enter if you would like to stop adding");
            String id = scanner.nextLine();
            if(id.isEmpty())
                break;
            Integer intId = Integer.parseInt(id);

            if(controller.getFoodById(intId) != null){
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
         * Allows the user to select coffee items to add to an offer by entering their IDs.
         * The user can continue adding coffees until they press Enter without entering an ID.
         * After each input, the method checks if the coffee ID exists, and if valid, adds it to the list.
         *
         * @param scanner The Scanner used to read user input.
         * @return A list of coffee IDs that the user selected for the offer.
         */
    public List<Integer> offerCoffee(Scanner scanner) {
        List<Integer> coffees = new ArrayList<>();
        while(true){
            controller.listAllCoffees();
            System.out.println("What coffee would you like to add to the offer? Enter the ID or press enter if you would like to stop adding");
            String id = scanner.nextLine();
            if(id.isEmpty())
                break;
            Integer intId = Integer.parseInt(id);
            if(controller.getCoffeeById(intId) != null){
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
         * Deletes an offer based on the offer ID provided by the user.
         * Prompts the user to enter the ID of the offer to delete. If the offer exists,
         * it is deleted. If the offer ID does not exist, an error message is displayed.
         *
         * @param scanner The Scanner object used to read user input.
         */
    private void deleteOffer(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the Offer to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Offer offerToDelete = controller.getOfferById(id);

            if (offerToDelete != null) {
                controller.deleteOffer(offerToDelete);  // Pass the Admin object to delete
                System.out.println("Offer with ID " + id + " has been deleted.");
            } else {
                System.out.println("Offer with ID " + id + " not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for ID.");
        }
    }


    public void startFoodManager(){
        boolean continueLoop = true;

        while(continueLoop){
            System.out.println("""
                     Coffee Shop Management System
                     1. Food Management
                     2. View all orders ever
                     3. Exit
                     """);
            System.out.print("Choose a category: ");
            String mainOption = scanner.nextLine();
            switch (mainOption) {
                case "1":
                    manageFood(scanner);
                    break;
                case "2":
                    viewOrders();
                    break;
                case "3":
                    continueLoop = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

    }

    public void startClientManager() {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("""
                    Coffee Shop Management System
                    1. Client management
                    2. View all orders ever
                    3. Exit
                    """);
            System.out.print("Choose a category: ");
            String mainOption = scanner.nextLine();
            switch (mainOption) {
                case "1":
                    manageClients(scanner);
                    break;
                case "2":
                    viewOrders();
                    break;
                case "3":
                    continueLoop = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

}





