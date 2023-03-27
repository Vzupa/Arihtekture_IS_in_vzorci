package si.um.feri.jee.sample.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Zdravnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ime;
    private String priimek;
    private String email;
    private int kvota;

    public Zdravnik(){
        this("", "", "", 0);
    }

    public Zdravnik(String ime, String priimek, String email, int kvota){
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.kvota = kvota;
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

    public int getKvota() {
        return kvota;
    }

    public void setKvota(int kvota) {
        this.kvota = kvota;
    }

    @Override
    public String toString() {
        return this.ime + " " + this.priimek + ", " + this.email;
    }
}
