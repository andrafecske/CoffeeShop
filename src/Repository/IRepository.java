package Repository;

import java.util.List;


public interface IRepository<T> {
    void create(T entity);
    T read(Integer id);
    void update(Integer id, T entity);
    void delete(Integer id);
    List<T> getAll();
}
