package Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Models.HasID;

public class InMemoryRepository <T extends HasID> implements IRepository<T> {
    private final Map<Integer,T> map = new HashMap<>();
    @Override
    public void create(T obj) {
        map.putIfAbsent(obj.hashCode(), obj);
    }

    @Override
    public T read(Integer id) {
        return map.get(id);
    }

    @Override
    public void update(Integer id, T obj) {
        map.replace(obj.getId(),obj);
    }

    @Override
    public void delete(Integer id) {
        map.remove(id);
    }

    @Override
    public List<T> getAll() {
        return map.values().stream().toList();
    }
}
