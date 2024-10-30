package Repository;
import Models.Order;

import java.util.List;

public class OrderRepo implements IRepository< Order >{

    @Override
    public void create(Order entity) {

    }

    @Override
    public Order read(int id) {
        return null;
    }

    @Override
    public void update(int id, Order entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Order> getAll() {
        return List.of();
    }
}
