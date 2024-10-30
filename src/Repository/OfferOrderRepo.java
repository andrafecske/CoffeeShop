package Repository;

import Models.OfferOrder;

import java.util.List;

public class OfferOrderRepo implements IRepository <OfferOrder> {
    @Override
    public void create(OfferOrder entity) {

    }

    @Override
    public OfferOrder read(int id) {
        return null;
    }

    @Override
    public void update(int id, OfferOrder entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<OfferOrder> getAll() {
        return List.of();
    }
}
