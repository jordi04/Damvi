import java.util.Scanner;
public class JordiRoca0407a {
    /*
        *Fes un programa que demani per teclat un nombre n i mostri
        els n primers nombres naturals en ordre decreixent. 
        Fes-ho amb un bucle while; a continuació fes un altre programa
        que faci el mateix però amb un bucle do-while.
        Exemple: si l’usuari introdueix un 5 el programa mostrarà els nombres 5, 4, 3, 2, 1
    */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        int n = myObj.nextInt();
        
        while(n > 1){
            n--;
            System.out.println(n);
        }
        
        System.out.println("Fi del programa");
    }
}

