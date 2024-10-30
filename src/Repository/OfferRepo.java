package Repository;

import Models.Offer;

import java.util.List;

public class OfferRepo implements IRepository<Offer> {
    @Override
    public void create(Offer entity) {

    }

    @Override
    public Offer read(int id) {
        return null;
    }

    @Override
    public void update(int id, Offer entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Offer> getAll() {
        return List.of();
    }
}
