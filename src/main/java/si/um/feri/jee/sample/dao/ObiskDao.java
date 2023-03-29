package si.um.feri.jee.sample.dao;

import jakarta.ejb.Local;
import si.um.feri.jee.sample.vao.Obisk;

import java.util.List;

@Local
public interface ObiskDao {
    List<Obisk> getAll();
    Obisk find(int id);
    void save(Obisk obisk);
    void delete(int id);
}
