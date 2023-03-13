package si.um.feri.jee.sample.dao;

import jakarta.ejb.Local;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.List;

@Local
public interface ZdravnikDao {
    List<Zdravnik> getAll();
    Zdravnik find(String email);
    void save(Zdravnik zdravnik);
    void delete(String email);
}
