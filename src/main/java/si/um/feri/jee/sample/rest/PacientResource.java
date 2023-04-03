package si.um.feri.jee.sample.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import si.um.feri.jee.sample.dao.PacientDao;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.services.SistemZaDodeljevanjeZdravnikovEJB;
import si.um.feri.jee.sample.strategija.ObiskProcesor;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.Collection;
import java.util.logging.Logger;

@Path("/pacienti")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacientResource {
    Logger log = Logger.getLogger(PacientResource.class.toString());

    @EJB
    private PacientDao pacientDao;

    @EJB
    private SistemZaDodeljevanjeZdravnikovEJB sistemZaDodeljevanjeZdravnikovEJB;

    @GET
    public Collection<Pacient> getVsiPacienti() {
        return pacientDao.getAll();
    }

    @GET
    @Path("/{email}")
    public Pacient getPacient(@PathParam("email") String email) {
        return pacientDao.find(email);
    }

    @POST
    public void dodajPacienta(Pacient pacient) throws Exception{
        pacientDao.save(pacient);
    }

    @PUT
    @Path("/{email}/{zdravnikEmail}")
    public void dodajZdravnika(@PathParam("email") String pacientEmail, @PathParam("zdravnikEmail") String zdravnikEmail) throws Exception{
        sistemZaDodeljevanjeZdravnikovEJB.najdiObjekta(zdravnikEmail, pacientEmail);
    }

}
