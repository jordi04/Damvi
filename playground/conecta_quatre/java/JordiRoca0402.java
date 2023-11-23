import java.util.Scanner;

public class JordiRoca0402 {
    /*
     * Fes un programa en Java que vagi llegint valors fins que s’introdueixi un nombre negatiu. 
     * En aquest moment, el programa acabarà mostrant un missatge de finalització del programa. 
     * Fes-ho amb un bucle while.
    */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        int n = myObj.nextInt();
        int max = -1;
        while(n >= 0){
            n = myObj.nextInt();
        }
        System.out.println("Has sortit del programa");
    }
}
