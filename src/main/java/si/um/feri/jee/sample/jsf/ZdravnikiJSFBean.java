package si.um.feri.jee.sample.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.vao.Zdravnik;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named("zdravnikBean")
@SessionScoped
public class ZdravnikiJSFBean implements Serializable {

    Logger log = Logger.getLogger(ZdravnikiJSFBean.class.toString());

    @EJB
    private ZdravnikDao dao;
    private Zdravnik selectedZdravnik = new Zdravnik();
    private String selectedEmail;

    public List<Zdravnik> getAllZdravniki() throws Exception {
        this.selectedZdravnik = new Zdravnik();
        return dao.getAll();
    }

    public List<String> pridobiEnaslove(){
        List<Zdravnik> zdravniki = dao.getAll();
        List<String> emaili = new ArrayList<>();

        for (Zdravnik zdravnik : zdravniki){
            emaili.add(zdravnik.getEmail());
        }

        return emaili;
    }

    public String saveZdravnik() throws Exception {
        Zdravnik newZdravnik = new Zdravnik();
        newZdravnik.setIme(selectedZdravnik.getIme());
        newZdravnik.setPriimek(selectedZdravnik.getPriimek());
        newZdravnik.setEmail(selectedZdravnik.getEmail());
        newZdravnik.setKvota(selectedZdravnik.getKvota());
        dao.save(newZdravnik);
        selectedZdravnik = new Zdravnik();
        return "all";
    }

    public void deleteZdravnik(Zdravnik zdravnik) throws Exception{
        dao.delete(zdravnik.getEmail());
    }

    public Zdravnik getSelectedZdravnik(){
        return selectedZdravnik;
    }

    public void setSelectedZdravnik(Zdravnik selectedZdravnik){
        this.selectedZdravnik = selectedZdravnik;
    }

    public void setSelectedEmail(String selectedEmail) {
        this.selectedEmail = selectedEmail;
        selectedZdravnik = dao.find(selectedEmail);
        if(selectedZdravnik ==null)
            selectedZdravnik = new Zdravnik();
    }

    public String getSelectedEmail() {
        return selectedEmail;
    }

}
