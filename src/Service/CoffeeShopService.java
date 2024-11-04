package Service;

import Models.Admin;
import Models.Client;
import Repository.IRepository;
import Utils.Role;

import java.util.List;

public class CoffeeShopService {
    private final IRepository<Admin> adminRepo;
    private final IRepository<Client> clientRepo;

    //admin service

    public CoffeeShopService(IRepository<Admin> adminRepo, IRepository<Client> clientRepo) {
        this.adminRepo = adminRepo;
        this.clientRepo = clientRepo;
        initializeRepositories();
    }
    private void initializeRepositories() {
        Admin admin1 = new Admin(1, 21, "Sara", Role.Manager);
        Admin admin2 = new Admin(2, 30, "Sara", Role.Manager);
        adminRepo.create(admin1);
        adminRepo.create(admin2);

        Client client1 = new Client(1, 21,"Maria Nastase");
        Client client2 = new Client(2, 22,"Luana Eram");
        clientRepo.create(client1);
        clientRepo.create(client2);
    }

    public void addAdmin(Admin admin) {
        if(admin == null) {
            System.out.println("Admin is null");
            return;
        }

        adminRepo.create(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepo.getAll();
    }

    public void updateAdmin(Admin admin) {
        if(admin == null){
            System.out.println("Admin is null");
            return;}

        Admin exists = adminRepo.read(admin.getId());
        if (exists != null) {
            adminRepo.update(admin.getId(), admin);
        } else {
            System.out.println("Admin not found");
        }
    }

    public void deleteAdmin(Admin admin) {
        if(admin == null){
            System.out.println("Admin is null");
            return;}

        Admin exists = adminRepo.read(admin.getId());
        if (exists != null) {
            adminRepo.delete(admin.getId());
        }else{
            System.out.println("Admin not found");
        }
    }

    public Admin getAdminById(Integer adminId) {
        return adminRepo.read(adminId);
    }

    //Client service


}
