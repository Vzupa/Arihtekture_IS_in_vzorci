package si.um.feri.jee.sample.JMS;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.jms.*;
import si.um.feri.jee.sample.dao.PacientDao;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.services.SistemZaDodeljevanjeZdravnikovEJB;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.function.Supplier;
import java.util.logging.Logger;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class AIVMessageDriven implements MessageListener {

    Logger log = Logger.getLogger(AIVMessageDriven.class.toString());

    @EJB
    PacientDao pacientDao;

    @EJB
    ZdravnikDao zdravnikDao;

    @EJB
    private SistemZaDodeljevanjeZdravnikovEJB sistemZaDodeljevanjeZdravnikov;

    public void onMessage(Message message) {
        if (message instanceof MapMessage) {
            MapMessage mapMessage = (MapMessage) message;
            try {
                String zdravnikEmail = mapMessage.getStringProperty("zdravnikEmail");
                String pacientEmail = mapMessage.getStringProperty("pacientEmail");

                Zdravnik zdravnik = zdravnikDao.find(zdravnikEmail);
                Pacient pacient = pacientDao.find(pacientEmail);


                pacient.setZdravnik(zdravnik, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            log.info("Prispelo je neznano sporocilo.");
        }
    }
}
