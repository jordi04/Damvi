import java.util.Scanner;
public class JordiRoca0405 {
    /*
     * Fes un programa en Java que vagi llegint valors fins que s’introdueixi un nombre negatiu.
     *  En aquest moment, el programa mostrarà la suma de tots els nombres positius i també informarà de la quantitat de valors que s’han introduït.
     *  Fes-ho amb un bucle do-while.
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        int n = myObj.nextInt();
        int suma = 0;
        int quantitatNombres = 0;
        do {
            suma += n;
            quantitatNombres++;
            n = myObj.nextInt();
        } while(n >=0);
        
        System.out.println("La suma dels nombres és = " + suma);
        System.out.println("S'han introduït " + quantitatNombres + " nombres");
    }
}
