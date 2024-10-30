package Repository;

import Models.Coffee;

import java.util.List;

public class CoffeeRepo implements IRepository<Coffee> {

    @Override
    public void create(Coffee entity) {

    }

    @Override
    public Coffee read(int id) {
        return null;
    }

    @Override
    public void update(int id, Coffee entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Coffee> getAll() {
        return List.of();
    }
}
