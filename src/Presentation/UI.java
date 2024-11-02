package Presentation;

import java.util.Scanner;
import Models.Admin;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.AdminService;
import Controller.Controller;
import Utils.Role;

public class UI {
    private final Controller controller;

    public UI(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("""
                     Coffee Shop
                     
                     1. View admins
                     2. Add admin
                     3. Update admin
                     4. Delete admin
                     5. Exit
                     
                     """);
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
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
                    System.out.println("Exiting program...");
                    continueLoop = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
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
            controller.addAdmin(admin);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numbers for ID and age.");
        }
    }


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



}
