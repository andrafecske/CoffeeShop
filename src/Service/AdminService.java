package Service;

import Repository.IRepository;
import Models.*;
import Utils.Role;

import java.util.List;

public class AdminService {
    private final IRepository<Admin> adminRepo;



    public AdminService(IRepository<Admin> adminRepo) {
        this.adminRepo = adminRepo;
        initializeAdminRepo();
    }

    private void initializeAdminRepo() {
        Admin admin1 = new Admin(1, 21, "Sara", Role.Manager);
        Admin admin2 = new Admin(2, 30, "Sara", Role.Manager);
        adminRepo.create(admin1);
        adminRepo.create(admin2);
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

}
