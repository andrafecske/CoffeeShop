import Models.Admin;
import Presentation.UI;
import Repository.InMemoryRepository;
import Service.AdminService;
import Controller.Controller;

public class Main {
    public static void main(String[] args) {
        // Create the repository
        InMemoryRepository<Admin> adminRepo = new InMemoryRepository<>();

        // Set up the service with the repository
        AdminService adminService = new AdminService(adminRepo);

        // Create the controller with the service
        Controller controller = new Controller(adminService);

        // Initialize the UI with the controller
        UI ui = new UI(controller);

        // Start the UI loop
        ui.start();
    }
}