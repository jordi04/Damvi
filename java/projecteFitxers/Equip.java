import java.io.Serializable;
import java.util.ArrayList;

public class Equip implements Serializable {
    private static final long serialVersionUID = 1L;
    String nomEquip;
    //ArrayList <Estrategia> estrategia = new ArrayList<Estrategia>();
    ArrayList<String> nomEstrategies = new ArrayList<String>();
    ArrayList<String> nomMembres = new ArrayList<String>();
    //ArrayList <Jugador> membres = new ArrayList<Jugador>();

    public Equip() {

    }

    public Equip(String nomEquip, ArrayList<String> nomEstrategies, ArrayList<String> nomMembres) {
        this.nomEquip = nomEquip;
        this.nomEstrategies = nomEstrategies;
        this.nomMembres = nomMembres;
    }

    /*
     Falta eliminar de equip els membres i només deixar la string del seu nom
    */

    public String getNomEquip() {
        return nomEquip;
    }

    public void setNomEquip(String nomEquip) {
        this.nomEquip = nomEquip;
    }

    public ArrayList<String> getEstrategia() {
        return nomEstrategies;
    }

    public void setEstrategia(ArrayList<String> nomEstrategies) {
        this.nomEstrategies = nomEstrategies;
    }

    public ArrayList<String> getMembres() {
        return nomMembres;
    }

    public void setMembres(ArrayList<String> nomMembres) {
        this.nomMembres = nomMembres;
    }
    
    @Override
    public String toString() {
        String aux = nomEquip;
        for (int i = 0; i < nomMembres.size(); i++) {
            aux += "\n Jugador " + (i+1) + "\n" + nomMembres.get(i).toString() + "\n";
        }
        for (int i = 0; i < nomEstrategies.size(); i++) {
            aux += "\n Estratègia " + (i+1) + "\n" + nomEstrategies.get(i).toString() + "\n";

        }
        return aux;
    }
}
