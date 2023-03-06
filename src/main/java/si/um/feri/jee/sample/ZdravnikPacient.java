package si.um.feri.jee.sample;

import si.um.feri.jee.sample.dao.PacientMemoryDao;
import si.um.feri.jee.sample.dao.ZdravnikMemoryDao;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ZdravnikPacient {

    Logger log = Logger.getLogger(ZdravnikPacient.class.toString());

    private PacientMemoryDao pacientDao = PacientMemoryDao.getInstance();

    private ZdravnikMemoryDao zdravnikDao = ZdravnikMemoryDao.getInstance();

    public void preveriKvoto(Zdravnik zdravnik, Pacient pacient){
        int stevilo = this.prestejPaciente(zdravnik);
        Zdravnik nulti = zdravnikDao.find("");
        log.info("KVOTA: " + zdravnik.getKvota() + ", stevilo: " + stevilo);

        if(zdravnik.getKvota() > stevilo){
            //poslji sporocilo zdravniku in pacientu
            pacient.setZdravnik(zdravnik);
            log.info("DODANO");
        }
        else {
            //poslji sporocilo samo pacientu
            log.info("NI DODANO");
            pacient.setZdravnik(nulti);
        }

    }

    public int prestejPaciente(Zdravnik zdravnik){
        ArrayList<Pacient> pacienti = new ArrayList<>(pacientDao.getAll());

        int stevilo = 0;

        for (Pacient pacient : pacienti){
            if(pacient.getZdravnik().equals(null))
                continue;

            if (pacient.getZdravnik().getEmail().equals(zdravnik.getEmail()))
                stevilo ++;
        }

        return stevilo;
    }

}
