package si.um.feri.jee.sample.services;

import jakarta.ejb.Remote;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.io.Serializable;

@Remote
public interface SistemZaDodeljevanjeZdravnikovEJB extends Serializable {

    void najdiObjekta(String zdravnikov_email, String pacientov_email);

    Pacient preveriRazpolozljivost(Zdravnik zdravnik, Pacient pacient, Zdravnik stariZdravnik);

    void test(String message);

    Pacient najdiObjekt(String zdravnikovMail, Pacient pacient, Zdravnik starZdravnik);
}
