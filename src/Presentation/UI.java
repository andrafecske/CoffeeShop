package Presentation;

import Controller.AdminController;
import Controller.ClientController;
import Models.Admin;
import Models.Client;

import java.util.Scanner;

public class UI {
    private final AdminController adminController;
    private final ClientController clientController;
    private final AdminUI adminUI;
    private final ClientUI clientUI;

    public UI(AdminController adminController, ClientController clientController, AdminUI adminUI, ClientUI clientUI) {
        this.adminController = adminController;
        this.clientController = clientController;
        this.adminUI = adminUI;
        this.clientUI = clientUI;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coffee Shop Log in");

        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter ID:");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a numeric ID.");
            return;
        }

        Admin admin = adminController.getAdminById(id);
        if (admin != null && admin.getName().equalsIgnoreCase(name)) {
            System.out.println("Welcome, Admin " + name + "!");
            adminUI.start();
            return;
        }

        Client client = clientController.getClientById(id);
        if (client != null && client.getName().equalsIgnoreCase(name)) {
            System.out.println("Welcome, Client " + name + "!");
            clientUI.start();
            return;
        }

        System.out.println("Login failed. No admin or client found with the provided name and ID.");

    }
}
