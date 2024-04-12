import java.util.ArrayList;

public class Personatge {
    private String nom;
    private int vida;
    private int nivell;
    //Un personatge pot tenir més d'un bojecte, dins aquesta ArrayList, de fet, en pot tenir tants 
    //com vulgui
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

    //Mètode per afegir un objecte a la col·lecció
    public void afegirObjecte(Objecte objecte) {
        objectes.add(objecte);
    }

    //Sobreescriptura del mètode toString()
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Personatge: ").append(nom).append("\n");
        stringBuilder.append("Grau de salut: ").append(vida).append("\n");
        stringBuilder.append("Nivell dins del lloc: ").append(nivell).append("\n");
        stringBuilder.append("Objectes: \n");
        for (Objecte obj : objectes) {
            stringBuilder.append(obj).append("\n");
        }
        return stringBuilder.toString();
    }
}
