package si.um.feri.jee.sample.dto;

import si.um.feri.jee.sample.vao.Zdravnik;

import java.io.Serializable;

public class ZdravnikDto implements Serializable {
    private String ime;
    private String priimek;
    private String email;


    public ZdravnikDto(Zdravnik zdravnik) {
        this.ime = zdravnik.getIme();
        this.priimek = zdravnik.getPriimek();
        this.email = zdravnik.getEmail();

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

}
