public class Lladre extends Personatge {
    private boolean sigil;

    //Constructor
    public Lladre(String nom, int vida, int nivellDinsDelLloc, boolean sigil) {
        super(nom, vida, nivellDinsDelLloc);
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
