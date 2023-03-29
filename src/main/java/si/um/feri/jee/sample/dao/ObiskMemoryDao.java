package si.um.feri.jee.sample.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.jee.sample.vao.Obisk;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ObiskMemoryDao implements ObiskDao{

    @PersistenceContext
    EntityManager em;

    Logger log= Logger.getLogger(ObiskMemoryDao.class.toString());


    @Override
    public List<Obisk> getAll() {
        log.info("DAO obiski: get all");
        return em.createQuery("select o from Obisk o", Obisk.class).getResultList();
    }

    @Override
    public Obisk find(int id) {
        log.info("DAO obiski: finding " + id);
        try {
            return em.createQuery("select o from Obisk o where o.id = :id", Obisk.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public void save(Obisk o) {
        Obisk obisk1 = find(o.getId());

        if(obisk1 != null) {
            log.info("DAO: editing " + obisk1);
            em.remove(obisk1);
            em.persist(o);
        }
        else {
            log.info("DAO: saving " + o);
            em.persist(o);
        }
    }

    @Override
    public void delete(int id) {
        Obisk obisk = find(id);

        if(obisk != null)
            em.remove(obisk);
    }
}
