package si.um.feri.jee.sample.converter;

import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.vao.Zdravnik;

@FacesConverter(forClass = Zdravnik.class)
public class ZdravnikConverter implements Converter {

    @EJB
    ZdravnikDao zdravnikDao;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Zdravnik selectedZdravnik = zdravnikDao.find(s);
        return selectedZdravnik;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return null;
        }

        return o.toString();
    }
}
