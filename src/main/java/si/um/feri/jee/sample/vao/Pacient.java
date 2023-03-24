package si.um.feri.jee.sample.vao;

import si.um.feri.jee.sample.services.Opazovalec;
import si.um.feri.jee.sample.services.OpazovalecInterface;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Pacient implements Serializable {

    private String ime;
    private String priimek;
    private String email;
    private LocalDate rojstniDatum;
    private String posebnosti;
    private Zdravnik zdravnik;
    private List<OpazovalecInterface> opazovalci;


    public Pacient() {
        this("", "", "", null, "", null);
    }

    public Pacient(String ime, String priimek, String email, LocalDate rojstniDatum, String posebnosti, Zdravnik zdravnik) {
        this(ime, priimek, email, rojstniDatum, posebnosti);
        this.zdravnik = zdravnik;
    }

    public Pacient(String ime, String priimek, String email, LocalDate rojstniDatum, String posebnosti) {
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.rojstniDatum = rojstniDatum;
        this.posebnosti = posebnosti;
        this.zdravnik = null;
        this.opazovalci = new ArrayList<>();
        this.dodajOpazovalca(new Opazovalec());
    }

    public void dodajOpazovalca(OpazovalecInterface opazovalec) {
        this.opazovalci.add(opazovalec);
    }

    public void odstraniOpazovalca(OpazovalecInterface opazovalec) {
        this.opazovalci.remove(opazovalec);
    }


    private void obestiDodajanjeZdravnika(Zdravnik noviZdravnik) {
        for (OpazovalecInterface opazovalec : this.opazovalci) {
            opazovalec.obvestiNovo(this, noviZdravnik);
        }
    }

    private void obestiOdstranjevanjeZdravnika(Zdravnik stariZdravnik) {
        for (OpazovalecInterface opazovalec : this.opazovalci) {
            opazovalec.obvestiStaro(this, stariZdravnik);
        }
    }

    public void setZdravnik(Zdravnik noviZdravnik, Zdravnik stariZdravnik) {
        //star zdravnik more bit, ker se ponavadi kliče iz new Pacient, kateremu še ni bil dodeljen zdravnik
        if (stariZdravnik != null) {
            if(!Objects.equals(stariZdravnik.getEmail(), ""))
                this.obestiOdstranjevanjeZdravnika(stariZdravnik);
        }
        this.obestiDodajanjeZdravnika(noviZdravnik);
        this.zdravnik = noviZdravnik;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRojstniDatum() {
        return rojstniDatum;
    }

    public void setRojstniDatum(LocalDate rojstniDatum) {
        this.rojstniDatum = rojstniDatum;
    }

    public String getPosebnosti() {
        return posebnosti;
    }

    public void setPosebnosti(String posebnosti) {
        this.posebnosti = posebnosti;
    }

    public Zdravnik getZdravnik() {
        return zdravnik;
    }

    public List<OpazovalecInterface> getOpazovalci() {
        return opazovalci;
    }

    public void setOpazovalci(List<OpazovalecInterface> opazovalci) {
        this.opazovalci = opazovalci;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", email='" + email + '\'' +
                ", rojstniDatum=" + rojstniDatum +
                ", posebnosti='" + posebnosti + '\'' +
                '}';
    }
}
