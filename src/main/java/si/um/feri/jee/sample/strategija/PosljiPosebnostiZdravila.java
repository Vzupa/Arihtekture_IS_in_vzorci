package si.um.feri.jee.sample.strategija;

import si.um.feri.jee.sample.services.MailSender;

import java.util.logging.Logger;

public class PosljiPosebnostiZdravila implements PosliEmailStrategija {
    Logger log = Logger.getLogger(PosljiPosebnostiZdravila.class.toString());

    @Override
    public void posliEmail(String email, String naslov, String vsebina) {
        log.info("Poslji posebnosti zdravila: " + email);
        MailSender.send(email, naslov, vsebina);
    }
}
