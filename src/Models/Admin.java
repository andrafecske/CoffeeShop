package Models;

import Utils.Role;

public class Admin extends Person {
    Role role;

    public Admin(Integer ID, int age, String name, Role role) {
        super(ID, age, name);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: " + role;
    }
}
