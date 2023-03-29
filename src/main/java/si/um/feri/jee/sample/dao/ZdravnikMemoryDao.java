package si.um.feri.jee.sample.dao;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.jee.sample.vao.Zdravnik;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ZdravnikMemoryDao implements ZdravnikDao {

    @PersistenceContext
    EntityManager em;

    Logger log= Logger.getLogger(ZdravnikMemoryDao.class.toString());

    //Odstranjeno, ker smo se povezali na bazo
//    private List<Zdravnik> zdravniki= Collections.synchronizedList(new ArrayList<>());

    //Odstranjeno, ker uporabljamo vse prek EJB-a
//    private static ZdravnikMemoryDao instanca = null;
//    public static synchronized ZdravnikMemoryDao getInstance() {
//        if (instanca == null)
//            instanca = new ZdravnikMemoryDao();
//        return instanca;
//    }

    @Override
    public List<Zdravnik> getAll() {
        log.info("DAO zdravniki: get all");
        return em.createQuery("select z from Zdravnik z", Zdravnik.class).getResultList();
    }

    @Override
    public Zdravnik find(String email)  {
        log.info("DAO zdravniki: finding "+email);
        if(email==null)
            email = "";
        try{
            return em.createQuery("select z from Zdravnik z where z.email = :email", Zdravnik.class)
                    .setParameter("email", email).getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public void save(Zdravnik o)  {
        Zdravnik zdravnik = find(o.getEmail());

        if(zdravnik != null) {
            log.info("DAO: editing " + o);
            em.remove(zdravnik);
            em.persist(o);
        }
        else {
            log.info("DAO: creating " + o);
            em.persist(o);
        }
    }

    @Override
    public void delete(String email) {
        log.info("Deleting: " + email);
        Zdravnik zaDelete = find(email);

        if(zaDelete != null)
            em.remove(zaDelete);
    }

    @Override
    public boolean preveriRazpolozljiost(Zdravnik zdravnik, int steviloPacientov){
        return steviloPacientov < zdravnik.getKvota();
    }
}
