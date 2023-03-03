package si.um.feri.jee.sample.dao;


import jakarta.enterprise.context.SessionScoped;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ZdravnikMemoryDao implements ZdravnikDao {

    Logger log= Logger.getLogger(ZdravnikMemoryDao.class.toString());

    private List<Zdravnik> zdravniki= Collections.synchronizedList(new ArrayList<Zdravnik>());

    private ZdravnikMemoryDao(){}
    private static ZdravnikMemoryDao instanca = null;
    public static synchronized ZdravnikMemoryDao getInstance() {
        if (instanca == null)
            instanca = new ZdravnikMemoryDao();
        return instanca;
    }

    @Override
    public List<Zdravnik> getAll() {
        log.info("DAO zdravniki: get all");
        return zdravniki;
    }

    @Override
    public Zdravnik find(String email)  {
        log.info("DAO zdravniki: finding "+email);
        for (Zdravnik o : zdravniki)
            if (o.getEmail().equals(email))
                return o;
        return null;
    }

    @Override
    public void save(Zdravnik o)  {
        log.info("DAO: saving "+o);
        if(find(o.getEmail())!=null) {
            log.info("DAO: editing "+o);
            delete(o.getEmail());
        }
        zdravniki.add(o);
    }

    @Override
    public void delete(String email) {
        log.info("Deleting: " + email);
        Zdravnik zaDelete = null;
        for (Zdravnik zdravnik : zdravniki){
            if(zdravnik.getEmail().equals(email))
                zaDelete = zdravnik;
        }

        if(zaDelete != null)
            zdravniki.remove(zaDelete);
    }
}
