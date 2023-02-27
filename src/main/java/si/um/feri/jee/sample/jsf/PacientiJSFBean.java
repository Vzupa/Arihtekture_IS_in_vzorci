package si.um.feri.jee.sample.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.sample.dao.PacientDao;
import si.um.feri.jee.sample.dao.PacientMemoryDao;
import si.um.feri.jee.sample.vao.Pacient;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("pacient")
@SessionScoped
public class PacientiJSFBean implements Serializable {

    Logger log = Logger.getLogger(PacientiJSFBean.class.toString());

    private PacientDao dao = new PacientMemoryDao();
    private Pacient selectedPacient = new Pacient();
    private String selectedEmail;

    public List<Pacient> getAllPacienti() throws Exception {
        return dao.getAll();
    }

    public String savePacient() throws Exception {
        Pacient newPacient = new Pacient();
        newPacient.setIme(selectedPacient.getIme());
        newPacient.setPriimek(selectedPacient.getPriimek());
        newPacient.setEmail(selectedPacient.getEmail());
        newPacient.setRojstniDatum(selectedPacient.getRojstniDatum());
        newPacient.setPosebnosti(selectedPacient.getPosebnosti());
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

}
