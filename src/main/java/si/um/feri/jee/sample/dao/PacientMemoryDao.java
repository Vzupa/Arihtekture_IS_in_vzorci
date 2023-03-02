package si.um.feri.jee.sample.dao;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import si.um.feri.jee.sample.vao.Pacient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@SessionScoped
public class PacientMemoryDao implements PacientDao, Serializable {

    Logger log= Logger.getLogger(PacientMemoryDao.class.toString());

    private List<Pacient> pacienti= Collections.synchronizedList(new ArrayList<Pacient>());

    @Override
    public List<Pacient> getAll() {
        log.info("DAO pacienti: get all");
        return pacienti;
    }

    @Override
    public Pacient find(String email)  {
        log.info("DAO pacienti: finding "+email);
        for (Pacient o : pacienti)
            if (o.getEmail().equals(email))
                return o;
        return null;
    }

    @Override
    public void save(Pacient o)  {
        log.info("DAO: saving "+o);
        if(find(o.getEmail())!=null) {
            log.info("DAO: editing "+o);
            delete(o.getEmail());
        }
        pacienti.add(o);
    }

    @Override
    public void delete(String email){
        log.info("Deleting: " + email);
        Pacient zaDelete = null;
        for (Pacient pacient : pacienti){
            if(pacient.getEmail().equals(email))
                zaDelete = pacient;
        }

        if(zaDelete != null)
            pacienti.remove(zaDelete);
    }
}
