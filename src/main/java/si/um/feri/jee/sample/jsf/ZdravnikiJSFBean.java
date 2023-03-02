package si.um.feri.jee.sample.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.dao.ZdravnikMemoryDao;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("zdravnikBean")
@SessionScoped
public class ZdravnikiJSFBean implements Serializable {

    Logger log = Logger.getLogger(ZdravnikiJSFBean.class.toString());

    private ZdravnikDao dao = new ZdravnikMemoryDao();
    private Zdravnik selectedZdravnik = new Zdravnik();
    private String selectedEmail;

    {
        Zdravnik ena = new Zdravnik("PRVI", "JE", "NAJ@", 5);
        Zdravnik dva = new Zdravnik("DRUGI", "NE", "GE@", 10);
        Zdravnik tri = new Zdravnik("TRETJI", "LM", "ZU@", 15);

        dao.save(ena);
        dao.save(dva);
        dao.save(tri);
    }

    public List<Zdravnik> getAllZdravniki() throws Exception {
        this.selectedZdravnik = new Zdravnik();
        return dao.getAll();
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
