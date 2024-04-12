import java.util.ArrayList;

public class Personatge {
    private String nom;
    private int vida;
    private int nivell;
    private ArrayList<Objecte> objectes;

    //Constructor
    public Personatge(String nom, int vida, int nivell) {
        this.nom = nom;
        this.vida = vida;
        this.nivell = nivell;
        this.objectes = new ArrayList<>();
    }

    //Setters i getters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    //Mètodes per afegir i eliminar objectes
    public void afegirObjecte(Objecte objecte) {
        objectes.add(objecte);
        objecte.afegirPropietari(this);
    }

    public void eliminarObjecte(Objecte objecte) {
        objectes.remove(objecte);
        objecte.eliminarPropietari(this);
    }

    //Mètode per mostrar els objectes del personatge
    public void mostrarObjectes() {
        System.out.println("Objectes de " + nom + ":");
        for (Objecte obj : objectes) {
            System.out.println(obj);
        }
    }

    //Sobreescriptura del mètode toString()
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Personatge: ").append(nom).append("\n");
        stringBuilder.append("Grau de salut: ").append(vida).append("\n");
        stringBuilder.append("Nivell: ").append(nivell).append("\n");
        stringBuilder.append("Objectes: \n");
        for (Objecte obj : objectes) {
            stringBuilder.append(obj).append("\n");
        }
        return stringBuilder.toString();
    }
}
