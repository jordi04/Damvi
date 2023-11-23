import java.util.Scanner;
/*
Escriu un programa en java que emmagatzemi en un vector els 50 primers números de Fibonacci. 
Una vegada calculats, el programa demanarà a l’usuari que introdueixi un número i dirà si és o no és un dels 50 primers números de Fibonacci.
*/
public class JordiRoca0509 {
    public static void main(String[] args) {
        long[] vector = new long[50];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 50; ++i){
            if (i < 2) {
                vector[i] = 1;
            }
            else vector[i] = vector[i-1] + vector[i-2];
        }
        System.out.print("Introdueix un nombre que pugui formar part de la sèrie de fibonacci (dels primers 50 elements): ");
        long numeroUser = scanner.nextLong();
        System.out.println("Comprovant si forma part de la sèrie... ");
        int i = 0;
        while (i < 50) {
            if (numeroUser == vector[i]) {
                System.out.println("Sí, el nombre introduït forma part de la sèrie");
                i = 50; //Ho he fet per optimitzar el cas en que el nombre introduït sigui 1, així no sortirà el text dues vegades
            } 
            else if (i == 49) System.out.println("El nombre introduït, no forma part de la sèrie");
            i++;
        } 
    }
}
