public class Magic extends Personatge {
    private String encanteri;

    //Constructor
    public Magic(String nom, int vida, int nivellDinsDelLloc, String encanteri) {
        super(nom, vida, nivellDinsDelLloc);
        this.encanteri = encanteri;
    }

    //Setter i getter únic de Màgic
    public String getEncanteri() {
        return encanteri;
    }

    public void setEncanteri(String encanteri) {
        this.encanteri = encanteri;
    }

    //Sobreescriptura del mètode toString()
    @Override
    public String toString() {
        return super.toString() + "\nEncaanteri: " + encanteri;
    }
}
