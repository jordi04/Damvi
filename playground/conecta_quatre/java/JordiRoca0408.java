import java.util.Scanner;

public class JordiRoca0408 {
    /*
     * Fes un programa que demani un per teclat un nombre n 
     * i calculi el producte dels n primers nombres naturals. 
     * Fes-ho amb un bucle while; a continuació fes un altre 
     * programa que faci el mateix però amb un bucle do-while.
     * Exemple: si l’usuari introdueix un 5 el programa mostrarà un 120.
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        int n = myObj.nextInt();
        int sum = 1;
        
        /* DESCOMENTA PER PROVAR-HO AMB WHILE\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
         * while(n > 1){
            sum *= n;
            n--;
        }
        */
        do {
            sum *= n;
            n--;
        } while(n > 1);

        System.out.println(sum);
        System.out.println("Fi del programa");
    }
}
