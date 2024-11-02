package Presentation;

import java.util.Scanner;

import Controller.ClientController;
import Controller.CoffeeController;
import Controller.FoodController;
import Models.Admin;
import Controller.AdminController;
import Models.Client;
import Models.Coffee;
import Models.Food;
import Utils.FoodType;
import Utils.Role;
import Utils.MilkType;

public class AdminUI {
    private final AdminController adminController;
    private final ClientController clientController;
    private final CoffeeController coffeeController;
    private final FoodController foodController;
    private final Scanner scanner;

    public AdminUI(AdminController adminController, ClientController clientController, CoffeeController coffeeController, FoodController foodController, Scanner scanner) {
        this.adminController = adminController;
        this.clientController = clientController;
        this.coffeeController = coffeeController;
        this.foodController = foodController;
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
                     4. Exit
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
                    adminController.listAllAdmins();
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
                     3. Back to main menu
                     """);
            System.out.print("Choose an option: ");
            String clientOption = scanner.nextLine();

            switch (clientOption) {
                case "1":
                    clientController.listAllClients();
                    break;

                case "2":
                    addClient(scanner);
                    break;

                case "3":
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
                     3. View all coffee items
                     4. Add coffee item
                     5. Back to main menu
                     """);
            System.out.print("Choose an option: ");
            String foodOption = scanner.nextLine();

            switch (foodOption) {
                case "1":
                    foodController.listAllFoods();
                    break;

                case "2":
                    addFood(scanner);
                    break;

                case "3":
                    coffeeController.listAllCoffees();
                    break;
                case "4":
                    addCoffee(scanner);
                    break;
                case "5":
                    foodLoop = false;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

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
            adminController.addAdmin(admin);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numbers for ID and age.");
        }
    }


    private void updateAdmin(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the Admin to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Retrieve the existing Admin
            Admin existingAdmin = adminController.getAdminById(id);
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
            adminController.updateAdmin(updatedAdmin);
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

    private void deleteAdmin(Scanner scanner) {
        try {
            System.out.print("Enter the ID of the Admin to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Admin adminToDelete = adminController.getAdminById(id);

            if (adminToDelete != null) {
                adminController.deleteAdmin(adminToDelete);  // Pass the Admin object to delete
                System.out.println("Admin with ID " + id + " has been deleted.");
            } else {
                System.out.println("Admin with ID " + id + " not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for ID.");
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
        foodController.addFood(food);
        System.out.println("Food added successfully");

    }

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
        coffeeController.addCoffee(coffee);


    }



}
