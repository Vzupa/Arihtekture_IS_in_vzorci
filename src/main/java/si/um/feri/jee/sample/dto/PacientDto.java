package si.um.feri.jee.sample.dto;

import jakarta.persistence.ManyToOne;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.io.Serializable;
import java.time.LocalDate;

public class PacientDto implements Serializable {

    private String ime;
    private String priimek;
    private String email;
    private LocalDate rojstniDatum;
    private String posebnosti;
    private Zdravnik zdravnik;

    public PacientDto(Pacient pacient) {
        this.ime = pacient.getIme();
        this.priimek = pacient.getPriimek();
        this.email = pacient.getEmail();
        this.rojstniDatum = pacient.getRojstniDatum();
        this.posebnosti = pacient.getPosebnosti();
        this.zdravnik = pacient.getZdravnik();
    }

    public String getIme() {
        return ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRojstniDatum() {
        return rojstniDatum;
    }

    public String getPosebnosti() {
        return posebnosti;
    }

    public Zdravnik getZdravnik() {
        return zdravnik;
    }
}
