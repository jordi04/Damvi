//Guerrer.java
public class Guerrer extends Personatge {
    private String arma;

    //Constructor
    public Guerrer(String nom, int vida, int nivell, String arma) {
        super(nom, vida, nivell);
        this.arma = arma;
    }

    //Setter i getter únic de Guerrer
    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    //Sobreescriptura del mètode toString()
    @Override
    public String toString() {
        return super.toString() + "\nArma: " + arma;
    }
}
