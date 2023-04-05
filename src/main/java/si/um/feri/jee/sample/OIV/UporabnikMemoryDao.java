package si.um.feri.jee.sample.OIV;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UporabnikMemoryDao implements UporabnikDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Uporabnik find(String uporabniskoIme) {
        try {
            return em.createQuery("select u from Uporabnik u where u.uporabniskoIme = :uporabniskoIme", Uporabnik.class)
                    .setParameter("uporabniskoIme", uporabniskoIme).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void save(Uporabnik uporabnik) {
        Uporabnik uporabnik1 = find(uporabnik.getUporabniskoIme());

        if (uporabnik1 != null) {
            em.remove(uporabnik1);
            em.persist(uporabnik);
        } else {
            em.persist(uporabnik);
        }
    }

    @Override
    public void delete(String uporabniskoIme) {
        Uporabnik uporabnik = find(uporabniskoIme);
        if (uporabnik != null)
            em.remove(uporabnik);
    }
}
