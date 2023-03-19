package si.um.feri.jee.sample.services;

import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

public class Opazovalec implements OpazovalecInterface{

    @Override
    public void obvestiNovo(Pacient pacient, Zdravnik noviZdravnik) {
        System.out.println("Obvesti novo: " + noviZdravnik.getIme() + " " + noviZdravnik.getPriimek());
        MailSender.send(pacient.getEmail(), "Novi zdravnik", "Novi zdravnik, ki vam je bil dodeljen je: " + noviZdravnik.getIme() + " " + noviZdravnik.getPriimek());
    }

    @Override
    public void obvestiStaro(Pacient pacient, Zdravnik stariZdravnik) {
        System.out.println("Obvesti staro: " + stariZdravnik.getIme() + " " + stariZdravnik.getPriimek());
        MailSender.send(pacient.getEmail(), "Odstranitev zdravnika", "Zdravnik, ki vam je bil dodeljen je bil odstranjen: " + stariZdravnik.getIme() + " " + stariZdravnik.getPriimek());
    }
}
