package si.um.feri.jee.sample.OIV;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Entity
public class Uporabnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String uporabniskoIme;
    private String heshiranoGeslo;
    private String salt;


    public Uporabnik() {}

    public Uporabnik(String uporabniskoIme, String geslo) {
        this.uporabniskoIme = uporabniskoIme;
        this.salt = generirajSalt();
        this.heshiranoGeslo = heshirajGeslo(geslo);
    }

    private String heshirajGeslo(String geslo){
        String saltiranoGeslo = this.salt + geslo;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(saltiranoGeslo.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generirajSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return bytesToHex(salt);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public boolean login(String geslo){
        String heshiranoGeslo = heshirajGeslo(geslo);
        return heshiranoGeslo.equals(this.heshiranoGeslo);
    }


    public String getUporabniskoIme() {
        return uporabniskoIme;
    }

    public void setUporabniskoIme(String uporabniskoIme) {
        this.uporabniskoIme = uporabniskoIme;
    }

    public String getHeshiranoGeslo() {
        return heshiranoGeslo;
    }

    public void setHeshiranoGeslo(String heshiranoGeslo) {
        this.heshiranoGeslo = heshiranoGeslo;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
