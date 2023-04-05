package si.um.feri.jee.sample.OIV;

import jakarta.ejb.Local;

@Local
public interface UporabnikDao {
    Uporabnik find(String uporabniskoIme);
    void save(Uporabnik uporabnik);
    void delete(String uporabniskoIme);
}
