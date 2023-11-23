import java.util.Scanner;

public class JordiRoca0502 {
    public static void main(String[] args) {
        int[] vector = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Generant nombres aleatoris entre 1 i 10 per al vector...");
        int i = 0;
        while (i < 10) {
            // Generem un nombre aleatori entre 1 i 10 i el guardem al vector.
            int valorAleatori = (int) (Math.random() * 10) + 1;
            vector[i] = valorAleatori;
            i++;
        }

        System.out.println("¡Vector generat! Introdueix un nombre entre 1 i 10: ");
        int numero = scanner.nextInt();
        
        boolean trobat = false;
        int j = 0;
        do {
            // Comprovem si el nombre introduït per l'usuari es troba al vector.
            if (vector[j] == numero) {
                trobat = true;
                break;
            }
            j++;
        } while (j < 10);

        System.out.println("Contingut del vector:");
        for (int k = 0; k < 10; k++) {
            System.out.print(vector[k] + " ");
        }

        if (trobat) {
            System.out.println("\n¡El nombre " + numero + " es troba al vector!");
        } else {
            System.out.println("\nEl nombre " + numero + " no es troba al vector.");
        }
    }
}
