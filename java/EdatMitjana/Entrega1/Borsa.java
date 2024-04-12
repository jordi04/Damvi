public class Borsa {
    private String denominacio;
    private double valorDeTancamentPrevi;
    private double preuActual;

    public Borsa(String denominacio) {
        this.denominacio = denominacio;
    }

    public double getPercentatgeDeCanvi() {
        return ((preuActual - valorDeTancamentPrevi) / valorDeTancamentPrevi) * 100;
    }

    public static void main(String[] args) {
        Borsa borsa = new Borsa("Exemple Inc.");
        borsa.valorDeTancamentPrevi = 34.5;
        borsa.preuActual = 34.35;

        double percentatgeCanvi = borsa.getPercentatgeDeCanvi();
        System.out.println("Percentatge de canvi: " + percentatgeCanvi + "%");
    }
}
