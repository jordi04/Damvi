public class Objecte {
    private String nom;
    private String descripcio;
    private int abundancia;

    //Constructor
    public Objecte(String nom, String descripcio, int abundancia) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.abundancia = abundancia;
    }

    //Setters i getters
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

    //Sobreescriptura del mètode toString()
    @Override
    public String toString() {
        return "Objecte: " + nom + "\nDescripció: " + descripcio + "\nAbundància: " + abundancia;
    }
}
