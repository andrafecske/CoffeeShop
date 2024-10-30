package Repository;

import Models.Product;

import java.util.List;

public class ProductRepo implements IRepository<Product> {
    @Override
    public void create(Product entity) {

    }

    @Override
    public Product read(int id) {
        return null;
    }

    @Override
    public void update(int id, Product entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }
}
