package si.um.feri.jee.sample.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.dto.ZdravnikDto;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/zdravniki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZdravnikResource {

    @EJB
    private ZdravnikDao zdravnikDao;

    @GET
    public Collection<ZdravnikDto> getVsiZdravniki() {
        List<Zdravnik> zdravniki = zdravnikDao.getAll();
        List<ZdravnikDto> zdravnikiDto = new ArrayList<>();

        for (Zdravnik zdravnik : zdravniki) {
            zdravnikiDto.add(new ZdravnikDto(zdravnik));
        }

        return zdravnikiDto;
    }

}
