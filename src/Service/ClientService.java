package Service;

import Models.Admin;
import Models.Client;
import Repository.IRepository;

import java.util.List;

public class ClientService {
    private final IRepository<Client> clientRepo;
    private final IRepository<Admin> adminRepo;

    public ClientService(IRepository<Client> clientRepo, IRepository<Admin> adminRepo ) {
        this.clientRepo = clientRepo;
        this.adminRepo = adminRepo;
        initializeClientRepo();
    }

    private void initializeClientRepo(){
        Client client1 = new Client(1, 21,"Maria Nastase");
        Client client2 = new Client(2, 22,"Luana Eram");
        clientRepo.create(client1);
        clientRepo.create(client2);
    }

    public void addClient(Client client){
        if(client == null){
            System.out.println("Client is null");
            return;
        }
        if(isAdminDuplicate(client)){
            System.out.println("Can't create client, there is already an admin with the same name and id");
        }
        clientRepo.create(client);
        System.out.println("Client added successfully");
    }

    public List<Client> getAllClients(){
        return clientRepo.getAll();
    }

    private boolean isAdminDuplicate(Client client){
        List<Admin> admins = adminRepo.getAll();
        for(Admin admin : admins){
            if(admin.getName().equals(client.getName()) && admin.getId().equals(client.getId())){
                return true;
            }
        }
        return false;
    }

    public Client getClientById(int id){
        return clientRepo.read(id);
    }

}
