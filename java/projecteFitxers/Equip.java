import java.util.ArrayList;

public class Equip {
    String nomEquip;
    ArrayList <Estrategia> estrategia = new ArrayList<Estrategia>();
    ArrayList <Jugador> membres = new ArrayList<Jugador>();

    public Equip() {

    }

    public Equip(String nomEquip, ArrayList<Estrategia> estrategia, ArrayList<Jugador> membres) {
        this.nomEquip = nomEquip;
        this.estrategia = estrategia;
        this.membres = membres;
    }

    public String getNomEquip() {
        return nomEquip;
    }

    public void setNomEquip(String nomEquip) {
        this.nomEquip = nomEquip;
    }

    public ArrayList<Estrategia> getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(ArrayList<Estrategia> estrategia) {
        this.estrategia = estrategia;
    }

    public ArrayList<Jugador> getMembres() {
        return membres;
    }

    public void setMembres(ArrayList<Jugador> membres) {
        this.membres = membres;
    }
    
}
