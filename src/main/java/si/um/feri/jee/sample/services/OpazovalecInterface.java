package si.um.feri.jee.sample.services;

import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.io.Serializable;

public interface OpazovalecInterface extends Serializable {
    //More bit Serializable, ker se bo ta interface uporabljal v EJB
    void obvestiNovo(Pacient pacient, Zdravnik nov_Zdravnik);
    void obvestiStaro(Pacient pacient, Zdravnik star_Zdravnik);
}
