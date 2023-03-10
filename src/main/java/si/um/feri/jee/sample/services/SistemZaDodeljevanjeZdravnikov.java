package si.um.feri.jee.sample.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import si.um.feri.jee.sample.dao.PacientDao;
import si.um.feri.jee.sample.dao.PacientMemoryDao;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.dao.ZdravnikMemoryDao;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.ArrayList;
import java.util.logging.Logger;

@Stateless
public class SistemZaDodeljevanjeZdravnikov implements SistemZaDodeljevanjeZdravnikovEJB {

    Logger log = Logger.getLogger(SistemZaDodeljevanjeZdravnikov.class.toString());

    @EJB
    private PacientDao pacientDao;

    @EJB
    private ZdravnikDao zdravnikDao;

    @Override
    public void test(String message) {
        log.info("Test: " + message);
    }

    @Override
    public void najdiObjekta(String zdravnikov_mail, String pacientov_mail) {
        preveriRazpolozljivost(zdravnikDao.find(zdravnikov_mail), pacientDao.find(pacientov_mail));
    }

    @Override
    public void preveriRazpolozljivost(Zdravnik zdravnik, Pacient pacient) {
        int steviloPacientov = this.prestejPaciente(zdravnik);
        Zdravnik nulti = zdravnikDao.find("");

        if (zdravnik.getKvota() > steviloPacientov) {
            MailSender.send(zdravnik.getEmail(), "Nov pacient", "Dodeljen vam je bil nov pacient/ka, z e-naslovom: " + pacient.getEmail());
            MailSender.send(pacient.getEmail(), "Uspesna registracija k zdravniku", "Uspesno vam je bil dodeljen zdravnik, z e-naslovom " + zdravnik.getEmail() + ".");
            pacient.setZdravnik(zdravnik);
        } else {
            pacient.setZdravnik(nulti);

            if (zdravnik.getEmail().equals(""))
                MailSender.send(pacient.getEmail(), "Niste izbrali zdravnika", "Zdravnika niste izbrali in ste zato neopredeljeni.");
            else
                MailSender.send(pacient.getEmail(), "Neuspesna registracija k zdravniku", "Zal je zdravnik, z e-naslovom " + zdravnik.getEmail() + ", že dosegel kvoto.");
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
