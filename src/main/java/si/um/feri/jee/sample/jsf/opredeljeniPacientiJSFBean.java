package si.um.feri.jee.sample.jsf;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.sample.dao.*;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

@Named("opredeljeniBean")
@SessionScoped
public class opredeljeniPacientiJSFBean implements Serializable {

	Logger log = Logger.getLogger(opredeljeniPacientiJSFBean.class.toString());

	@EJB
	private PacientDao pacientDao;

	@EJB
	private ZdravnikDao zdravnikDao;

	private Integer neopredeljeni;

	public Map<Zdravnik, List> narediListo(){
		ArrayList<Pacient> pacienti = new ArrayList<>(pacientDao.getAll());
		ArrayList<Zdravnik> zdravniki = new ArrayList<>(zdravnikDao.getAll());

		Map<Zdravnik, List> relacija = new HashMap<>();
		this.neopredeljeni = 0;

		for(Zdravnik zdravnik : zdravniki){
			List<Pacient> njegovi = new ArrayList<>();
			for(Pacient pacient : pacienti){
				if(pacient.getZdravnik() == zdravnik){
					njegovi.add(pacient);

					log.info("Zdravnikov majl: " + zdravnik.getEmail());
					if(Objects.equals(zdravnik.getEmail(), "") || Objects.equals(zdravnik.getEmail(), "null"))
						this.neopredeljeni++;
				}
			}
			relacija.put(zdravnik, njegovi);
		}

		return relacija;
	}

	public void hm(){}

	@PostConstruct
	public void narediTestne(){
		log.info("Dodajam testne podatke");

		Zdravnik nic = new Zdravnik("", "", "", 0);
		Zdravnik ena = new Zdravnik("Ana", "Novak", "Ana.Novak@lmao.lmao", 5);
		Zdravnik dva = new Zdravnik("Boris", "Kovacic", "Boric.Kovacic@lmao.lmao", 10);
		Zdravnik tri = new Zdravnik("Cilka", "Horvar", "Cilka.Horvar@lmao.lmao", 15);
		Zdravnik stiri = new Zdravnik("David", "Kotnik", "David.Kotnik@lmao.lmao", 8);
		Zdravnik pet = new Zdravnik("Eva", "Kolman", "Eva.Kolman@lmao.lmao", 12);

		Pacient enaP = new Pacient("Janez", "Novak", "Janez.Novak@lmao.lmao", LocalDate.parse("1990-10-01"), "", ena);
		Pacient dvaP = new Pacient("Maja", "Kovacic", "Maja.Kovacic@lmao.lmao", LocalDate.parse("1992-05-15"), "", dva);
		Pacient triP = new Pacient("Luka", "Horvar", "Luka.Horvar@lmao.lmao", LocalDate.parse("1995-11-20"), "", tri);
		Pacient stiriP = new Pacient("Nina", "Kotnik", "Nina.Kotnik@lmao.lmao", LocalDate.parse("1991-04-13"), "", stiri);
		Pacient petP = new Pacient("Oskar", "Kolman", "Oskar.Kolman@lmao.lmao", LocalDate.parse("1993-07-25"), "", pet);

		Pacient enaP2 = new Pacient("Peter", "Horvat", "Peter.Horvat@lmao.lmao", LocalDate.parse("1985-03-10"), "", ena);
		Pacient enaP3 = new Pacient("Barbara", "Koren", "Barbara.Koren@lmao.lmao", LocalDate.parse("1998-08-08"), "", ena);
		Pacient enaP4 = new Pacient("Tina", "Lah", "Tina.Lah@lmao.lmao", LocalDate.parse("1980-12-27"), "", ena);

		Pacient stiriP2 = new Pacient("Matic", "Hribar", "Matic.Hribar@lmao.lmao", LocalDate.parse("1975-01-30"), "", stiri);
		Pacient stiriP3 = new Pacient("Urska", "Potocnik", "Urska.Potocnik@lmao.lmao", LocalDate.parse("1999-06-14"), "", stiri);

		zdravnikDao.save(nic);
		zdravnikDao.save(ena);
		zdravnikDao.save(dva);
		zdravnikDao.save(tri);
		zdravnikDao.save(stiri);
		zdravnikDao.save(pet);

		pacientDao.save(enaP);
		pacientDao.save(dvaP);
		pacientDao.save(triP);
		pacientDao.save(stiriP);
		pacientDao.save(petP);
		pacientDao.save(enaP2);
		pacientDao.save(enaP3);
		pacientDao.save(enaP4);
		pacientDao.save(stiriP2);
		pacientDao.save(stiriP3);
	}

	public Integer getNeopredeljeni() {
		return this.neopredeljeni;
	}

}
