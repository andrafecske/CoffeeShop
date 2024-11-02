package Controller;

import Models.Client;
import Service.ClientService;

import java.util.List;

public class ClientController {
    private ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public void addClient(Client client) {
        clientService.addClient(client);
        System.out.println("Client added");
    }

    public void listAllClients() {
        List<Client> clients = clientService.getAllClients();

        if(clients.isEmpty()){
            System.out.println("No clients found");
        }
        else{
            System.out.println("Clients found");
            for(Client client : clients){
                System.out.println(client);
            }
        }
    }

    public Client getClientById(int id) {
        return clientService.getClientById(id); // Assumes this method exists in ClientService
    }
}
