package si.um.feri.jee.sample.dao;

import java.util.List;

public interface BasicDao<T> {
    List<T> getAll();
    T find(String id);
    void save(T entity);
    void delete(String id);
}
