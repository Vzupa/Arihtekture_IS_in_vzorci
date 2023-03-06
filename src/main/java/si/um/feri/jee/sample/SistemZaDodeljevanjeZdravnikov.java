package si.um.feri.jee.sample;

import si.um.feri.jee.sample.dao.PacientMemoryDao;
import si.um.feri.jee.sample.dao.ZdravnikMemoryDao;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.ArrayList;
import java.util.logging.Logger;

public class SistemZaDodeljevanjeZdravnikov {

    Logger log = Logger.getLogger(SistemZaDodeljevanjeZdravnikov.class.toString());

    private PacientMemoryDao pacientDao = PacientMemoryDao.getInstance();

    private ZdravnikMemoryDao zdravnikDao = ZdravnikMemoryDao.getInstance();

    public void preveriRazpolozljivost(Zdravnik zdravnik, Pacient pacient){
        int steviloPacientov = this.prestejPaciente(zdravnik);
        Zdravnik nulti = zdravnikDao.find("");

        if(zdravnik.getKvota() > steviloPacientov){
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

        int steviloPacientov = 0;

        for (Pacient pacient : pacienti){
            if(pacient.getZdravnik().equals(null))
                continue;

            if (pacient.getZdravnik().getEmail().equals(zdravnik.getEmail()))
                steviloPacientov ++;
        }

        return steviloPacientov;
    }

}
