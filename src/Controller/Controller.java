package Controller;
import Models.Admin;
import Service.*;

import java.util.List;

public class Controller {
    private final AdminService adminService;

    public Controller(AdminService adminService) {
        this.adminService = adminService;
    }

    public void addAdmin(Admin admin) {
        adminService.addAdmin(admin);
        System.out.println("Admin added successfully");
    }

    public void listAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();

        if (admins.isEmpty()) {
            System.out.println("No admins found.");
        } else {
            System.out.println("Admins found:");
            for (Admin admin : admins) {
                System.out.println(admin);
            }
        }
    }

    public void updateAdmin(Admin admin) {
        adminService.updateAdmin(admin);
        System.out.println("Admin updated successfully");
    }

    public void deleteAdmin(Admin admin) {
        adminService.deleteAdmin(admin);
        System.out.println("Admin deleted successfully");
    }

    public Admin getAdminById(Integer id) {
        return adminService.getAdminById(id);
    }
}
