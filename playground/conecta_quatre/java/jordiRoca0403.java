
import java.util.Scanner;
public class jordiRoca0403 {

    /**
     * @param args the command line arguments
     */
    /*
    Fes un programa en Java que vagi llegint valors fins que s’introdueixi un nombre negatiu.
    En aquest moment, el programa mostrarà per pantalla el major dels nombres introduïts. 
    Fes-ne dues versions: amb un bucle while i a continuació amb un bucle do-while.
    */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        int n = myObj.nextInt();
        int max = -1;
        /* 
        while(n >= 0){
            if (n > max) {
                max = n;
            }
            n = myObj.nextInt();
        }
        */
        // /* DESCOMENTA EL WHILE PER COMPROVAR SI FUNCIONA I COMENTA EL DO WHILE
        do {
            if (n > max) {
                max = n;
            }
            n = myObj.nextInt();
        } while(n>=0);
        // */
        
        if (max == -1) {
            System.out.println("No s'ha introduït cap nombre positiu");
        }
        System.out.println("El nombre més gran introduït és: " + max);
    }
    
}
