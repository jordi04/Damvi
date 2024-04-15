import java.io.Serializable;
import java.util.ArrayList;

public class Equip implements Serializable {
    private static final long serialVersionUID = 1L;
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
    
    @Override
    public String toString() {
        String aux = nomEquip;
        for (int i = 0; i < membres.size(); i++) {
            aux += "\n Jugador " + (i+1) + "\n" + membres.get(i).toString() + "\n";
        }
        return aux;
    }
}
