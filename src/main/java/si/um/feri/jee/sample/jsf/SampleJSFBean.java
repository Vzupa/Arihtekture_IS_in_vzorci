//package si.um.feri.jee.sample.jsf;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.logging.Logger;
//
//import jakarta.enterprise.context.SessionScoped;
//import jakarta.inject.Named;
//import si.um.feri.jee.sample.dao.PacientDao;
//import si.um.feri.jee.sample.dao.PacientMemoryDao;
//import si.um.feri.jee.sample.dao.ZdravnikDao;
//import si.um.feri.jee.sample.dao.ZdravnikMemoryDao;
//import si.um.feri.jee.sample.vao.Pacient;
//import si.um.feri.jee.sample.vao.Zdravnik;
//
//@Named("sample")
//@SessionScoped
//public class SampleJSFBean implements Serializable {
//
//	Logger log = Logger.getLogger(SampleJSFBean.class.toString());
//	private PacientDao pacientDao = new PacientMemoryDao();
//	private ZdravnikDao zdravnikDao = new ZdravnikMemoryDao();
//
//	public void dodajTestnePodatke(){
//		log.info("dodaja klicana");
//		Zdravnik zdravnik1 = new Zdravnik("Prvi", "Zdravnik", "Prvi.Zdravnik@gmail.com", 5);
//		Zdravnik zdravnik2 = new Zdravnik("Drugi", "Zdravnik", "Drugi.Zdravnik@gmail.com", 10);
//		Zdravnik zdravnik3 = new Zdravnik("Tretji", "Zdravnik", "Tretji.Zdravnik@gmail.com", 15);
//
//		Pacient pacient1 = new Pacient("Prvi", "Pacient", "Prvi.Pacient@gmail.com", LocalDate.parse("1990-02-28"), "nope");
//		Pacient pacient2 = new Pacient("Drugi", "Pacient", "Drugi.Pacient@gmail.com", LocalDate.parse("1995-06-15"), "nope");
//		Pacient pacient3 = new Pacient("Tretji", "Pacient", "Tretji.Pacient@gmail.com", LocalDate.parse("1985-12-03"), "nope");
//		Pacient pacient4 = new Pacient("Četrti", "Pacient", "Cetrti.Pacient@gmail.com", LocalDate.parse("2000-09-22"), "nope");
//		Pacient pacient5 = new Pacient("Peti", "Pacient", "Peti.Pacient@gmail.com", LocalDate.parse("1975-04-01"), "nope");
//		Pacient pacient6 = new Pacient("Šesti", "Pacient", "Sesti.Pacient@gmail.com", LocalDate.parse("1999-11-11"), "nope");
//		Pacient pacient7 = new Pacient("Sedmi", "Pacient", "Sedmi.Pacient@gmail.com", LocalDate.parse("1988-07-25"), "nope");
//		Pacient pacient8 = new Pacient("Osmi", "Pacient", "Osmi.Pacient@gmail.com", LocalDate.parse("1992-01-17"), "nope");
//		Pacient pacient9 = new Pacient("Deveti", "Pacient", "Deveti.Pacient@gmail.com", LocalDate.parse("1970-10-12"), "nope");
//		Pacient pacient10 = new Pacient("Deseti", "Pacient", "Deseti.Pacient@gmail.com", LocalDate.parse("1983-03-07"), "nope");
//
//		zdravnik1.getPacienti().add(pacient1);
//		zdravnik1.getPacienti().add(pacient2);
//		zdravnik1.getPacienti().add(pacient3);
//		zdravnik1.getPacienti().add(pacient4);
//
//		zdravnik2.getPacienti().add(pacient5);
//		zdravnik2.getPacienti().add(pacient6);
//		zdravnik2.getPacienti().add(pacient7);
//		zdravnik2.getPacienti().add(pacient8);
//
//		zdravnik3.getPacienti().add(pacient9);
//		zdravnik3.getPacienti().add(pacient10);
//
//		pacientDao.save(pacient1);
//		pacientDao.save(pacient2);
//		pacientDao.save(pacient3);
//		pacientDao.save(pacient4);
//		pacientDao.save(pacient5);
//		pacientDao.save(pacient6);
//		pacientDao.save(pacient7);
//		pacientDao.save(pacient8);
//		pacientDao.save(pacient9);
//		pacientDao.save(pacient10);
//
//		zdravnikDao.save(zdravnik1);
//		zdravnikDao.save(zdravnik2);
//		zdravnikDao.save(zdravnik3);
//
//	}
//
//}
