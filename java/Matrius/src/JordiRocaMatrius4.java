import java.util.Scanner;
public class JordiRocaMatrius4 {
    /*
    Escriu un programa en Java que inicialment sol·licite dos valors enters n i m, que seran les dimensions d’una matriu
     d’enters d'n files i m columnes (atenció, caldrà treballar amb una matriu de mida més gran, i limitar l'àrea de
     treball segons les dades introduïdes per l'usuari); a continuació demanarà a l'usuari cadascun dels valors de la
     matriu. El programa mostrarà un menú que permetrà calcular i mostrar per pantalla:
    la suma de la fila que indiqui l'usuari
    la suma de la columna que indiqui l'usuari
    la suma total de tots els elements de la matriu
    la mitjana dels elements de la matriu.
    Per exemple: per a n=2, m=3 i la següent matriu

    | 1 2 3 |
    | 4 5 6 |

    Depenent de l'opció triada per l'usuari, el programa presentarà la següent informació:
    Suma de la fila 1: 6
    Suma de la fila 2: 15
    Suma de la columna 1: 5
    Suma de la columna 2: 7
    Suma de la columna 3: 9
    Suma total: 21
    Mitjana: 3'5
    */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int suma;
        //Agafa n i m
        System.out.print("Insereix un nombre n de files de la matriu: ");
        int n = input.nextInt();
        System.out.println();
        System.out.print("Insereix un nombre m de columnes de la matriu: ");
        int m = input.nextInt();
        System.out.println();

        //Definim la matriu

        int[][] matriu = new int[n][m];

        //Insereix valors a la matriu
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.println("Insereix un valor de la matriu: ");
                matriu[i][j] = input.nextInt();
            }
        }

        int aux;
        boolean run = true;
        while (run) {
            suma = 0;
            double mitjana = 0;
            System.out.println("Selecciona un opció:\n0) Sumar una fila\n1) Sumar una columna\n" +
                    "2) Sumar tots els elements \n3) Mitjana de tots els elements \nANY) Exit");
            int opcio = input.nextInt();
            switch (opcio) {
                case 0: //Suma de la fila
                    System.out.println("Quina fila vols sumar? Insereix un int");
                    aux = input.nextInt() -1;
                    for (int i = 0; i < m; ++i) {
                        suma += matriu[aux][i];
                    }
                    System.out.println("La suma de la fila és " + suma);
                    break;
                case 1: //Suma de la columna
                    System.out.println("Quina columna vols sumar? Insereix un int");
                    aux = input.nextInt() -1;
                    for (int i = 0; i < n; ++i) {
                        suma += matriu[i][aux];
                    }
                    System.out.println("La suma de la columna és " + suma);
                    break;
                case 2: //Suma de tots els elements
                    for (int i = 0; i < n; ++i) {
                        for (int j = 0; j < m; j++) {
                            suma += matriu[i][j];
                        }
                    }
                    System.out.println("La suma de tots els elements és " + suma);
                    break;
                case 3: //Mitjana
                    for (int i = 0; i < n; ++i) {
                        for (int j = 0; j < m; j++) {
                            mitjana += matriu[i][j];
                        }
                    }
                    mitjana = mitjana/(n*m);
                    System.out.println("La mitjana és " + mitjana);
                    break;
                default: //Exit
                    run = false;
                    break;

            }
        }
    }
}













