package si.um.feri.jee.sample.vao;

import java.util.ArrayList;

public class Zdravnik {

    private String ime;
    private String priimek;
    private String email;
    private int kvota;
    private ArrayList<Pacient> pacienti;

    public Zdravnik(){
        this("", "", "", 0);
    }

    public Zdravnik(String ime, String priimek, String email, int kvota){
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.kvota = kvota;
        this.pacienti = new ArrayList<>();
    }

    public ArrayList<Pacient> getPacienti() {
        return pacienti;
    }

    public void setPacienti(Pacient pacient) {
        this.pacienti.add(pacient);
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
        String zaNazaj = "Zdravnik{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", email='" + email + '\'' +
                ", kvota=" + kvota +
                '}';
        for(Pacient pacient: pacienti){
            zaNazaj += pacient.toString();
        }
        zaNazaj += "}";

        return zaNazaj;
    }
}
