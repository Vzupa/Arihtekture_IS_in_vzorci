package si.um.feri.jee.sample.dao;


import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.List;

public interface ZdravnikDao {
    List<Zdravnik> getAll();
    Zdravnik find(String email);
    void save(Zdravnik zdravnik);
    void delete(String email);

}
