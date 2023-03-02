package si.um.feri.jee.sample.jsf;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import si.um.feri.jee.sample.dao.PacientDao;
import si.um.feri.jee.sample.dao.PacientMemoryDao;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.dao.ZdravnikMemoryDao;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

@Named("opredeljeniBean")
@SessionScoped
public class opredeljeniPacientiJSFBean implements Serializable {

	Logger log = Logger.getLogger(opredeljeniPacientiJSFBean.class.toString());

	@Inject
	private PacientMemoryDao pacientDao;

	@Inject
	private ZdravnikMemoryDao zdravnikDao;

	public List<Pacient> getAllPacienti() throws Exception {
		return pacientDao.getAll();
	}



}
