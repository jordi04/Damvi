public class Personatge {
    private String nom;
    private int vida;
    private int nivell;
    private Inventari inventari;

    //Constructor
    public Personatge(String nom, int vida, int nivell) {
        this.nom = nom;
        this.vida = vida;
        this.nivell = nivell;
        this.inventari = new Inventari();
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

    public Inventari getInventari() {
        return inventari;
    }

    //Sobreescriptura del mètode toString()
    @Override
    public String toString() {
        return "Personatge: " + nom + "\nGrau de salut: " + vida + "\nNivell dins del lloc: " + nivell + "\nInventari: " + inventari;
    }
}
