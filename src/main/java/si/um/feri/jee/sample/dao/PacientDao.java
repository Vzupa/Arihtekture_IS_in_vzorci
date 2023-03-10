package si.um.feri.jee.sample.dao;

import jakarta.ejb.Local;
import si.um.feri.jee.sample.vao.Pacient;

import java.util.List;

@Local
public interface PacientDao {
    List<Pacient> getAll();
    Pacient find(String email);
    void save(Pacient pacient);
    void delete(String email);
}
