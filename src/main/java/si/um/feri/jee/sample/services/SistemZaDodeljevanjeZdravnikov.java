package si.um.feri.jee.sample.services;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import si.um.feri.jee.sample.dao.PacientDao;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;
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
        //Ta del se klice prek drugega projekta, ker na onem niam zdravnikov/pacientov
        Zdravnik noviZdravnik = zdravnikDao.find(zdravnikov_mail);
        Pacient pacient = pacientDao.find(pacientov_mail);
        Zdravnik stariZdravnik = pacient.getZdravnik();

        Pacient pacient1 = preveriRazpolozljivost(noviZdravnik, pacient, stariZdravnik);
    }

    @Override
    public Pacient preveriRazpolozljivost(Zdravnik zdravnik, Pacient pacient, Zdravnik starZdravnik) {
        Zdravnik nulti = zdravnikDao.find("");
        int steviloPacientov = pacientDao.getSteviloPacientov(zdravnik, nulti);

        if (zdravnik.getKvota() > steviloPacientov) {
            MailSender.send(zdravnik.getEmail(), "Nov pacient", "Dodeljen vam je bil nov pacient/ka, z e-naslovom: " + pacient.getEmail());
            MailSender.send(pacient.getEmail(), "Uspesna registracija k zdravniku", "Uspesno vam je bil dodeljen zdravnik, z e-naslovom " + zdravnik.getEmail() + ".");
            pacient.setZdravnik(zdravnik, starZdravnik);
        } else {
            pacient.setZdravnik(nulti, starZdravnik);

            if (zdravnik.getEmail().equals(""))
                MailSender.send(pacient.getEmail(), "Niste izbrali zdravnika", "Zdravnika niste izbrali in ste zato neopredeljeni.");
            else
                MailSender.send(pacient.getEmail(), "Neuspesna registracija k zdravniku", "Zal je zdravnik, z e-naslovom " + zdravnik.getEmail() + ", že dosegel kvoto.");
        }
        log.info("noviZdravnik: " +pacient.getZdravnik().toString());
        return pacient;
    }

    @Override
    public Pacient najdiObjekt(String zdravnikovMail, Pacient pacient, Zdravnik starZdravnik){
        // Vmesni, ker sem spremenil iz zdravnika v PacientBeanu v samo njegov mail
        return preveriRazpolozljivost(zdravnikDao.find(zdravnikovMail), pacient, starZdravnik);
    }

}
