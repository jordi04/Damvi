import java.util.ArrayList;

public class Personatge {
    private String nom;
    private int vida;
    private int nivellDinsDelLloc;
    private ArrayList<Objecte> objectes;

    //Constructor
    public Personatge(String nom, int vida, int nivellDinsDelLloc) {
        this.nom = nom;
        this.vida = vida;
        this.nivellDinsDelLloc = nivellDinsDelLloc;
        this.objectes = new ArrayList<>();
    }

    //Setters i getters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getvida() {
        return vida;
    }

    public void setvida(int vida) {
        this.vida = vida;
    }

    public int getNivellDinsDelLloc() {
        return nivellDinsDelLloc;
    }

    public void setNivellDinsDelLloc(int nivellDinsDelLloc) {
        this.nivellDinsDelLloc = nivellDinsDelLloc;
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
        stringBuilder.append("Nivell dins del lloc: ").append(nivellDinsDelLloc).append("\n");
        stringBuilder.append("Objectes: \n");
        for (Objecte obj : objectes) {
            stringBuilder.append(obj).append("\n");
        }
        return stringBuilder.toString();
    }
}
