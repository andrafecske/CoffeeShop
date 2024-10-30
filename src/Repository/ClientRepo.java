package Repository;

import Models.Client;

import java.util.List;

public class ClientRepo implements IRepository<Client> {

    @Override
    public void create(Client entity) {

    }

    @Override
    public Client read(int id) {
        return null;
    }

    @Override
    public void update(int id, Client entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Client> getAll() {
        return List.of();
    }
}
