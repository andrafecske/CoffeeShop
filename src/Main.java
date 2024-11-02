import Controller.AdminController;
import Controller.ClientController;
import Models.Admin;
import Models.Client;
import Presentation.AdminUI;
import Presentation.ClientUI;
import Presentation.UI;
import Repository.InMemoryRepository;
import Service.AdminService;
import Service.ClientService;

public class Main {
    public static void main(String[] args) {
        // Create the repository
        InMemoryRepository<Admin> adminRepo = new InMemoryRepository<>();
        InMemoryRepository<Client> clientRepo = new InMemoryRepository<>();

        // Set up the service with the repository
        AdminService adminService = new AdminService(adminRepo);
        ClientService clientService = new ClientService(clientRepo, adminRepo);

        // Create the controller with the service
        AdminController adminController = new AdminController(adminService);
        ClientController clientController = new ClientController(clientService);

        // Initialize the UI with the controller
        AdminUI adminUi = new AdminUI(adminController, clientController);
        ClientUI clientUi = new ClientUI(clientController);

        // Initialize and start the main UI for login
        UI mainUI = new UI(adminController, clientController, adminUi, clientUi);
        mainUI.start();
    }
}
