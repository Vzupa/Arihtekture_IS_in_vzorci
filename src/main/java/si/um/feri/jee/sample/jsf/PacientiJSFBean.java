package si.um.feri.jee.sample.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import si.um.feri.jee.sample.dao.PacientDao;
import si.um.feri.jee.sample.services.SistemZaDodeljevanjeZdravnikovEJB;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("pacientBean")
@SessionScoped
public class PacientiJSFBean implements Serializable {

    Logger log = Logger.getLogger(PacientiJSFBean.class.toString());

    @EJB
    private PacientDao dao;
    private Pacient selectedPacient = new Pacient();
    @EJB
    private SistemZaDodeljevanjeZdravnikovEJB sistemZaDodeljevanjeZdravnikov;
    private Zdravnik izbranZdravnik;
    private String selectedEmail;


    public List<Pacient> getAllPacienti() throws Exception {
        this.selectedPacient = new Pacient();
        return dao.getAll();
    }

    public String savePacient() throws Exception {
        log.info("klice se");
        Pacient newPacient = new Pacient();
        newPacient.setIme(selectedPacient.getIme());
        newPacient.setPriimek(selectedPacient.getPriimek());
        newPacient.setEmail(selectedPacient.getEmail());
        newPacient.setRojstniDatum(selectedPacient.getRojstniDatum());
        newPacient.setPosebnosti(selectedPacient.getPosebnosti());
        log.info("naredo novega");

        //newPacient se nia zdravnika, zato najdem prek prejsnega pa poslem not, pa returnat morem newPacient, ker se mi ni hoto updejtat
        Pacient starPacient = dao.find(selectedPacient.getEmail());
        Zdravnik starZdravnik = null;
        if (starPacient != null) {
            starZdravnik = starPacient.getZdravnik();
        }
        newPacient = sistemZaDodeljevanjeZdravnikov.preveriRazpolozljivost(izbranZdravnik, newPacient, starZdravnik);

        log.info("dodal zdravnika");
        dao.save(newPacient);
        log.info("New patient saved: " + newPacient);
        selectedPacient = new Pacient();
        return "all";
    }

    public Pacient getNewPacient() {
        return selectedPacient;
    }

    public Pacient getSelectedPacient(){
        return selectedPacient;
    }

    public void getSelectedPacient(Pacient selectedPacient){
        this.selectedPacient = selectedPacient;
    }

    public void setSelectedEmail(String email) throws Exception{
        selectedEmail = email;
        selectedPacient = dao.find(selectedEmail);
        if(selectedPacient == null)
            selectedPacient = new Pacient();
    }

    public String getSelectedEmail(){
        return selectedEmail;
    }

    public void deletePacient(Pacient pacient)throws Exception{
        dao.delete(pacient.getEmail());
    }

    public void setSelectedPacient(Pacient selectedPacient) {
        this.selectedPacient = selectedPacient;
    }

    public Zdravnik getIzbranZdravnik() {
        return izbranZdravnik;
    }

    public void setIzbranZdravnik(Zdravnik izbranZdravnik) {
        log.info("izbran zdravnik: " + izbranZdravnik.getEmail());
        this.izbranZdravnik = izbranZdravnik;
    }

    public void spremeniZdravnika(Zdravnik zdravnik){
        this.izbranZdravnik = zdravnik;
    }

}
