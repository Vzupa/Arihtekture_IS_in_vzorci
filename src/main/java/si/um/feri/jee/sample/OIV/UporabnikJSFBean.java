package si.um.feri.jee.sample.OIV;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("uporabnikBean")
@SessionScoped
public class UporabnikJSFBean implements Serializable {

    @EJB
    private UporabnikDao uporabnikDao;
    private String uporabniskoIme;
    private String geslo;


    public String login(){
        Uporabnik uporabnik = uporabnikDao.find(this.uporabniskoIme);

        if (uporabnik != null && uporabnik.login(this.geslo)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login successful!", null));
            return "all";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", null));
        return "none";
    }

    public String register(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration successful!", null));

        Uporabnik uporabnik = new Uporabnik(this.uporabniskoIme, this.geslo);
        uporabnikDao.save(uporabnik);

        return "register.xhtml";
    }

    public String getUporabniskoIme() {
        return uporabniskoIme;
    }

    public void setUporabniskoIme(String uporabniskoIme) {
        this.uporabniskoIme = uporabniskoIme;
    }

    public String getGeslo() {
        return geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }
}
