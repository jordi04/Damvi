import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;
    String nickname;
    String nomJugador;
    int edat;
    String rol;
    ArrayList <String> habilitats = new ArrayList<String>();
    int puntsElo;

    public Jugador() {

    }

    public Jugador(String nickname, String nomJugador, int edat, String rol, ArrayList<String> habilitat, int puntsElo) {
        this.nickname = nickname;
        this.nomJugador = nomJugador;
        this.edat = edat;
        this.rol = rol;
        this.habilitats = habilitat;
        this.puntsElo = puntsElo;
    }


    

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNomJugador() {
        return nomJugador;
    }

    public void setNomJugador(String nomJugador) {
        this.nomJugador = nomJugador;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ArrayList<String> getHabilitats() {
        return habilitats;
    }

    public void setHabilitats(ArrayList<String> habilitat) {
        this.habilitats = habilitat;
    }

    public int getPuntsElo() {
        return puntsElo;
    }

    public void setPuntsElo(int puntsElo) {
        this.puntsElo = puntsElo;
    }

    //altres
    @Override
    public String toString() {
        return "";
    }
}
