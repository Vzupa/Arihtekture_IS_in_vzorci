package si.um.feri.jee.sample.vao;

import java.time.LocalDate;

public class Pacient {

    private String ime;
    private String priimek;
    private String email;
    private LocalDate rojstniDatum;
    private String posebnosti;
    private Zdravnik zdravnik;


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

    public void setZdravnik(Zdravnik zdravnik) {
        this.zdravnik = zdravnik;
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
