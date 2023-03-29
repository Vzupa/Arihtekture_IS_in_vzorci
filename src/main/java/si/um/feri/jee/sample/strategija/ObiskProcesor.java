package si.um.feri.jee.sample.strategija;

import si.um.feri.jee.sample.vao.Obisk;

import java.util.logging.Logger;

public class ObiskProcesor {
    private Obisk obisk;
    private PosliEmailStrategija posliEmailStrategija;
    Logger log = Logger.getLogger(ObiskProcesor.class.toString());


    public ObiskProcesor(Obisk obisk) {
        this.obisk = obisk;
        this.posliEmailStrategija = new PosljiNic();
    }

    public void zakljuciObisk(String pacientovMail) {
        String vsebina = "Pozdravljeni, \nobisk je zakljucen. \n";

        if(!obisk.getPosebnosti().equals("")) {
            posliEmailStrategija = new PosljiPosebnosti();
            vsebina += "Posebnosti: " + obisk.getPosebnosti() + "\n";
        }

        if(!obisk.getPredpisanaZdravila().equals("")) {
            posliEmailStrategija = new PosljiPosebnostiZdravila();
            vsebina += "Predpisana zdravila: " + obisk.getPredpisanaZdravila() + "\n";

        }

        vsebina += "Lep pozdrav, \n" +
                "Vas zdravnik \n" + obisk.getZdravnik().toString();

        log.info(String.valueOf(posliEmailStrategija.getClass()));
        posliEmailStrategija.posliEmail(pacientovMail, "obisk " + obisk.getDatum(), vsebina);
    }

}
