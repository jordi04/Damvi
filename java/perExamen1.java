
import java.util.Scanner;

public class perExamen1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a) Àrea lateral del cilindre
        double radi = demanarDouble("Introdueix el radi de la base del cilindre: ");
        double altura = demanarDouble("Introdueix l'altura del cilindre: ");
        double areaLateral = calcularAreaLateral(radi, altura);
        System.out.println("Àrea lateral del cilindre: " + areaLateral);

        // b) Volum del cilindre
        double volum = calcularVolum(radi, altura);
        System.out.println("Volum del cilindre: " + volum);

        // c) Arrel quadrada
        double nombre = demanarDouble("Introdueix un nombre per calcular l'arrel quadrada: ");
        double arrelQuadrada = calcularArrelQuadrada(nombre);
        System.out.println("Arrel quadrada de " + nombre + ": " + arrelQuadrada);

        // d) Quadrats dels 20 primers nombres naturals
        calcularQuadratsPrimers20();

        // e) Conversió entre m/s i km/h
        int opcioConversio = demanarOpcio("Selecciona una opció de conversió:\n1. m/s a km/h\n2. km/h a m/s");
        if (opcioConversio == 1) {
            double metresPerSegon = demanarDouble("Introdueix la velocitat en m/s: ");
            double kmPerHora = convertirMetrosPorSegundoAKilometrosPorHora(metresPerSegon);
            System.out.println(metresPerSegon + " m/s equivalen a " + kmPerHora + " km/h");
        } else if (opcioConversio == 2) {
            double kmPerHora = demanarDouble("Introdueix la velocitat en km/h: ");
            double metresPerSegon = convertirKilometrosPorHoraAMetrosPorSegundo(kmPerHora);
            System.out.println(kmPerHora + " km/h equivalen a " + metresPerSegon + " m/s");
        } else {
            System.out.println("Opció no vàlida.");
        }

        scanner.close();
    }

    // Funció per calcular àrea lateral del cilindre
    public static double calcularAreaLateral(double radi, double altura) {
        return 2 * Math.PI * radi * altura;
    }

    // Funció per calcular volum del cilindre
    public static double calcularVolum(double radi, double altura) {
        return Math.PI * Math.pow(radi, 2) * altura;
    }

    // Funció per calcular arrel quadrada
    public static double calcularArrelQuadrada(double nombre) {
        return Math.sqrt(nombre);
    }

    // Funció per calcular quadrats dels 20 primers nombres naturals
    public static void calcularQuadratsPrimers20() {
        System.out.println("Quadrats dels 20 primers nombres naturals:");
        for (int i = 1; i <= 20; i++) {
            double aux = Math.pow(i, 2);
            String auxString = String.format("%.2f", aux);
            System.out.println(i + ": " + auxString);
        }
    }

    // Funció per convertir m/s a km/h
    public static double convertirMetrosPorSegundoAKilometrosPorHora(double metresPerSegon) {
        return metresPerSegon * 3.6;
    }

    // Funció per convertir km/h a m/s
    public static double convertirKilometrosPorHoraAMetrosPorSegundo(double kmPerHora) {
        return kmPerHora * 0.2778;
    }

    // Funció per demanar un nombre de tipus double a l'usuari
    public static double demanarDouble(String missatge) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(missatge);
        return scanner.nextDouble();
    }

    // Funció per demanar una opció a l'usuari
    public static int demanarOpcio(String missatge) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(missatge);
        return scanner.nextInt();
    }
}

