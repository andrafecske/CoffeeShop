package Presentation;

import Controller.ClientController;
import Models.Client;

import java.util.Scanner;

public class ClientUI {

    private final ClientController clientController;

    public ClientUI(ClientController clientController) {
        this.clientController = clientController;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while(continueLoop){
            System.out.println("""
                    Coffee Shop
                    
                    1. View Clients
                    2. Add Client
                    3. Exit
                    
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
                    continueLoop = false;

            }
        }
        scanner.close();
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
