package si.um.feri.jee.sample.dao;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PacientMemoryDao implements PacientDao{

    @PersistenceContext
    EntityManager em;
    Logger log= Logger.getLogger(PacientMemoryDao.class.toString());

    //Odstranjeno, ker smo se povezali na bazo
//    private List<Pacient> pacienti= Collections.synchronizedList(new ArrayList<>());

    //Odstranjeno, ker uporabljamo vse prek EJB-a
//    private static  PacientMemoryDao instanca = null;
//    public static synchronized PacientMemoryDao getInstance() {
//        if (instanca == null)
//            instanca = new PacientMemoryDao();
//        return instanca;
//    }

    @Override
    public List<Pacient> getAll() {
        log.info("DAO pacienti: get all");
        return em.createQuery("select p from Pacient p", Pacient.class).getResultList();
    }

    @Override
    public Pacient find(String email)  {
        log.info("DAO pacienti: finding "+email);
        try {
            return em.createQuery("select p from Pacient p where p.email = :email", Pacient.class)
                    .setParameter("email", email).getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public void save(Pacient o)  {
        log.info("DAO: saving "+o);
        Pacient pacient = find(o.getEmail());

        if(pacient != null) {
            log.info("DAO: editing "+o);
            em.remove(pacient);
            em.persist(o);
        }
        else {
            em.persist(o);
        }
    }

    @Override
    public void delete(String email){
        log.info("Deleting: " + email);
        Pacient zaDelete = find(email);

        if(zaDelete != null)
            em.remove(zaDelete);
    }

    @Override
    public int getSteviloPacientov(Zdravnik zdravnik){
        List<Pacient> pacienti = getAll();

        int steviloPacientov = 0;

        for (Pacient pacient : pacienti){
            if (pacient.getZdravnik().getEmail().equals(zdravnik.getEmail()))
                steviloPacientov++;
        }

        return steviloPacientov;
    }
}
