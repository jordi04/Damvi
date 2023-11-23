import java.util.Scanner;

public class JordiRoca0503 {
    public static void main(String[] args) {
        int iguals, petits, grans;
        iguals = petits = grans = 0;

        int[] vector = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Generant nombres aleatoris entre 1 i 10 per al vector...");
        for (int i = 0; i < 10; ++i){
            // Generem un nombre aleatori entre 1 i 10 i el guardem al vector.
            int valorAleatori = (int) (Math.random() * 10) + 1;
            vector[i] = valorAleatori;
        }

        System.out.println("¡Vector generat! Introdueix un nombre entre 1 i 10: ");
        int numero = scanner.nextInt();
        
        for(int i = 0; i < 10; ++i){
            if (vector[i] == numero) iguals++;
            else if (vector[i] < numero) petits++;
            else if (vector[i] > numero) grans++;
        }
        
        System.out.println("Hi ha: \n Nombres iguals a " + numero +": " + iguals + "\n Nombres més petits que " + numero +": " + petits + "\n Nombres més grans que " + numero +": " + grans);
        
    }
}
