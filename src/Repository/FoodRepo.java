package Repository;

import Models.Food;

import java.util.List;

public class FoodRepo implements IRepository<Food> {

    @Override
    public void create(Food entity) {

    }

    @Override
    public Food read(int id) {
        return null;
    }

    @Override
    public void update(int id, Food entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Food> getAll() {
        return List.of();
    }
}
