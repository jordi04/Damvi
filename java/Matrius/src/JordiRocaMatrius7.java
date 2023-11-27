import java.util.Scanner;

public class JordiRocaMatrius7 {
    /*
    Escriu un programa en Java que vagi omplint una matriu d’enters M, de dimensió n x m, sol·licitant a l’usuari els
    valors d’n, m i M[i][j]. Deuràs, per tant, preveure una mida màxima per la matriu i comprovar que els valors n i m
    introduïts per l’usuari no el sobrepassen. Una vegada introduïdes les dades en la matriu, el programa ha de dir si
    la matriu és creixent.

    Una matriu M és creixent si M[i][j] ≤ M[i][j+1] i M[i][j] ≤ M[i+1][j]

    El programa ha de presentar com a resultat la pròpia matriu i dir si és o no és creixent. Per exemple: per a n=2,
    m=3 i la següent matriu

    | 1 2 3 |
    | 2 3 4 |

    El programa presentarà la següent informació:

    Dóna’m el nombre de files: 2
    Dóna’m el nombre de columnes: 3
    Matriu de 2x3:
    Element (0,0): 1
    Element (0,1): 2
    Element (0,2): 3
    Element (1,0): 2
    Element (1,1): 3
    Element (1,2): 4

    1 2 3
    2 3 4

    La matriu és creixent.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Definim matriu
        int[][] matriu = new int[10][10];
        int n = matriu.length + 1;
        int m = matriu.length + 1;

        //Agafam n
        while (n > matriu.length){
            System.out.print("Insereix un nombre n de files de la matriu: ");
            n = input.nextInt();
            System.out.println();
        }
        //Agafam m
        while (m > matriu.length) {
            System.out.print("Insereix un nombre m de columnes de la matriu: ");
            m = input.nextInt();
            System.out.println();
        }
        System.out.println("Matriu de "+ n + "x" + m +":");

        //Inserim les dades a la matriu
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Element ("+ i + "," + j + "): ");
                matriu[i][j] = input.nextInt();
                System.out.println();
            }
        }
        boolean creixent = true; //Per comprovar si és creixent
        for (int i = 0; i < n -1; i++) {
            //n i m -1 degut a que la matriu es més gran que la matriu de l'usuari
            //i pot causar l'error de comptar el valor zero predeterminat que esta al cosat dels altres
            for (int j = 0; j < m -1; j++) {
                if (!((matriu[i][j] <= matriu[i][j+1]) && (matriu[i][j] <= matriu[i+1][j]))){
                    creixent = false;
                } //Si no s'executa mai aquest codi vol dir que la matriu és creixent
            }
        }
        //Imprimim el resultat final
        if (creixent) System.out.println("La matriu és creixent");
        else System.out.println("La matriu no és creixent");
    }
}