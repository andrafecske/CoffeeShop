package Repository;

import Models.Admin;

import java.util.List;

public class AdminRepo implements IRepository<Admin> {

    @Override
    public void create(Admin entity) {

    }

    @Override
    public Admin read(int id) {
        return null;
    }

    @Override
    public void update(int id, Admin entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Admin> getAll() {
        return List.of();
    }
}
