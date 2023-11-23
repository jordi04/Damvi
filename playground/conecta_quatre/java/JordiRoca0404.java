import java.util.Scanner;

public class JordiRoca0404 {
    /*
     * Fes un programa en Java que vagi llegint valors fins que s’introdueixi un nombre negatiu.
     *  En aquest moment, el programa mostrarà la suma de tots els nombres positius.
     *  Fes-ho primer amb un bucle while i a continuació amb un do...while.
    */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        int n = myObj.nextInt();
        int sum = 0;
        /*
        while(n >= 0){
            sum += n;
            n = myObj.nextInt();
        }
        */
        do {
            sum += n;
            n = myObj.nextInt();
        } while(n >=0);
        
        System.out.println("La suma dels nombres és = " + sum);
    }
}
