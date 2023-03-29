package si.um.feri.jee.sample.strategija;

import si.um.feri.jee.sample.services.MailSender;

import java.util.logging.Logger;

public class PosljiPosebnosti implements PosliEmailStrategija {
    Logger log = Logger.getLogger(PosljiPosebnosti.class.toString());

    @Override
    public void posliEmail(String email, String naslov, String vsebina) {
        log.info("Poslji posebnosti: " + email);
        MailSender.send(email, naslov, vsebina);
    }
}
