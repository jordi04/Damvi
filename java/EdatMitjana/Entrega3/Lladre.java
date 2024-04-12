public class Lladre extends Personatge {
    private boolean sigil;

    //Constructor
    public Lladre(String nom, int vida, int nivell, boolean sigil) {
        super(nom, vida, nivell);
        this.sigil = sigil;
    }

    //Setter i getter únic de Lladre
    public boolean isSigil() {
        return sigil;
    }

    public void setSigil(boolean sigil) {
        this.sigil = sigil;
    }

    //Sobreescriptura del mètode toString()
    @Override
    public String toString() {
        return super.toString() + "\nSigil: " + sigil;
    }
}
