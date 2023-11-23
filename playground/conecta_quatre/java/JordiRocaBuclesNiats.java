import java.util.Scanner;

public class JordiRocaBuclesNiats {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);


        //A
        int n = 1;
        int i = 0;
        while (n <= 6) { //PER A CADA FILA
            i = 0;
            while (i < n) { //PER A CADA COLUMNA QUE IMPRIMIM
                System.out.print("*");
                i++;
            }
            System.out.println("");
            n++;
        }
        System.out.println("");


        //B
        n = 6;
        i = 6;
        while (n > 0) {
            i = n;
            while (i > 0) {
                System.out.print("*");
                i--;
            }
            System.out.println("");
            n--;
        }
        System.out.println("");


        //C
        n = 1;
        i = 6;
        int x = 1;
        while (n <= 6) {
            i = 6;
            while (i >= n) {
                System.out.print(" ");
                i--;
            }
            x = 1;
            while (x <= n) {
                System.out.print("*");
                x++;
            }
            System.out.println("");
            n++;
        }
        System.out.println("");


        //D
        n = 1;
        i = 6;
        while (n <= 6) {
            i = 1;
            while (i <= n) {
                System.out.print(" ");
                i++;
            }
            x = 6;
            while (x >= n) {
                System.out.print("*");
                x--;
            }
            System.out.println("");
            n++;
        }
            
        
        System.out.println("");

        //PYRAMID
        n = 1;
        while (n <= 6) {
            i = 6;
            while (i >= n) {
                System.out.print(" ");
                i--;
            }
            x = 1;
            while (x <= n) {
                System.out.print(" ");
                System.out.print("*");
                x++;
            }
            i = 6;
            while (i >= n) {
                System.out.print(" ");
                i--;
            }
            System.out.println("");
            n++;
            
        }
          

    }
}
