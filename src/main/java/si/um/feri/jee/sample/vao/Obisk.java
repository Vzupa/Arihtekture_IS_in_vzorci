package si.um.feri.jee.sample.vao;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Obisk implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Zdravnik zdravnik;
    private LocalDate datum;
    private String posebnosti;
    private String predpisanaZdravila;

    public Obisk() {
        this(null, "", "");
    }

    public Obisk(Zdravnik zdravnik, String posebnosti, String predpisanaZdravila) {
        this.zdravnik = zdravnik;
        this.posebnosti = posebnosti;
        this.predpisanaZdravila = predpisanaZdravila;
        this.datum = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zdravnik getZdravnik() {
        return zdravnik;
    }

    public void setZdravnik(Zdravnik zdravnik) {
        this.zdravnik = zdravnik;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getPosebnosti() {
        return posebnosti;
    }

    public void setPosebnosti(String posebnosti) {
        this.posebnosti = posebnosti;
    }

    public String getPredpisanaZdravila() {
        return predpisanaZdravila;
    }

    public void setPredpisanaZdravila(String predpisanaZdravila) {
        this.predpisanaZdravila = predpisanaZdravila;
    }
}
