import java.util.Scanner;
public class JordiRoca0406 {
    /*
        Fes un programa que demani per teclat un nombre n i mostri els n primers nombres 
        naturals en ordre creixent. Fes-ho primer amb un bucle while; a continuació fes un altre 
        programa que faci el mateix però amb un bucle do-while.
        Exemple: si l’usuari introdueix un 5 
        el programa mostrarà els nombres 1, 2, 3, 4, 5
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        int n = myObj.nextInt();
        int sum = 1;
        
        while(n > 0){
            n--;
            System.out.println(sum);
            sum++;
        }
        
        /* 
        do {
            n--;
            System.out.println(sum);
            sum++;
        } while(n > 0);
        */
        System.out.println("Fi del programa");
    }
}
