import java.util.ArrayList;

public class Objecte {
    private String nom;
    private String descripcio;
    private int abundancia;
    private ArrayList<Personatge> propietaris;

    // Constructor
    public Objecte(String nom, String descripcio, int abundancia) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.abundancia = abundancia;
        this.propietaris = new ArrayList<>();
    }

    // Setters i getters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getAbundancia() {
        return abundancia;
    }

    public void setAbundancia(int abundancia) {
        this.abundancia = abundancia;
    }

    // Mètodes per afegir i eliminar propietaris
    public void afegirPropietari(Personatge propietari) {
        propietaris.add(propietari);
    }

    public void eliminarPropietari(Personatge propietari) {
        propietaris.remove(propietari);
    }

    // Sobreescriptura del mètode toString()
    @Override
    public String toString() {
        return "Objecte: " + nom + "\nDescripció: " + descripcio + "\nAbundància: " + abundancia;
    }
}
