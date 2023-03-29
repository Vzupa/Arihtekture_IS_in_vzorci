package si.um.feri.jee.sample.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.sample.dao.ObiskDao;
import si.um.feri.jee.sample.dao.PacientDao;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.vao.Obisk;

import java.io.Serializable;
import java.util.logging.Logger;

@Named("obiskBean")
@SessionScoped
public class ObiskJSFBean implements Serializable {

    Logger log = Logger.getLogger(PacientiJSFBean.class.toString());
    @EJB
    private ObiskDao dao;
    @EJB
    private PacientDao pacientDao;
    @EJB
    private ZdravnikDao zdravnikDao;
    private Obisk selectedObisk = new Obisk();
    private String pacientovMail;
    private String zdravnikovMail;


    public String saveObisk() throws Exception{
        Obisk newObisk = new Obisk();
        newObisk.setPosebnosti(selectedObisk.getPosebnosti());
        newObisk.setPredpisanaZdravila(selectedObisk.getPredpisanaZdravila());
        newObisk.setZdravnik(zdravnikDao.find(zdravnikovMail));

        dao.save(newObisk);
        pacientDao.shraniObisk(pacientovMail, newObisk);

        selectedObisk = new Obisk();
        return "all";
    }


    public Obisk getSelectedObisk() {
        return selectedObisk;
    }

    public void setSelectedObisk(Obisk selectedObisk) {
        this.selectedObisk = selectedObisk;
    }

    public String getPacientovMail() {
        return pacientovMail;
    }

    public void setPacientovMail(String pacientovMail) {
        this.pacientovMail = pacientovMail;
    }

    public String getZdravnikovMail() {
        return zdravnikovMail;
    }

    public void setZdravnikovMail(String zdravnikovMail) {
        this.zdravnikovMail = zdravnikovMail;
    }
}
