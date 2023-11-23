// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
/*

Fer una primera versió del joc dels vaixells modificat de forma que els 20 vaixells (valor constant)
només ocupin una posició cadascun en la matriu de 10x10 elements (valors constants) que representarà el
"camp de batalla"
a) Inicialment la matriu haurà d'estar inicialitzada a valors 'neutres' per representar un camp buit
b) El programa assignarà posicions als vaixells de forma aleatòria
c) A partir d'aquest moment, el programa entrarà en un bucle que demanarà unes coordenades a l'usuari.
Depenent de si en aquesta posició hi ha un vaixell o no, donarà la resposta adequada a l'usuari, i en qualsevol dels
dos casos marcarà la posició: amb un valor 0 si ha encertat en un vaixell, o un valor 1 si ha tocat aigua (o una
codificació semblant). A continuació mostrarà per pantalla la situació del camp de batalla, amb totes les posicions on
hagi disparat l'usuari, i mostrant si hi havia un vaixell o un tret a l'aigua. Naturalment, la matriu amb els vaixells
original no s'ha de mostar a l'usuari, sinó que treballarem amb una matriu auxiliar per emmagatzemar els trets i els
vaixells enfonsats.
d) El joc acabarà quan l'usuari ho decideixi o quan hagi enfonsat tots els vaixells. En aquest últim cas, el programa
treurà un missatge de felicitació cap a l'usuari.
 */

import java.util.Scanner;

public class Main {
    private static final int FILES = 10;
    private static final int COLUMNES = 10;
    private static final int NUM_VAIXELLS = 20;

    public static void main(String[] args) {
        char[][] campBatalla = new char[COLUMNES][FILES];
        char[][] trets = new char[COLUMNES][FILES];
        int vaixellsEnfonsats = 0;

        // Inicialitzar el camp de batalla i els trets
        for (int i = 0; i < COLUMNES; i++) {
            for (int j = 0; j < FILES; j++) {
                campBatalla[i][j] = '-';
                trets[i][j] = '-';
            }
        }

        // Colocar els vaixells de forma aleatòria
        int numVaixells = NUM_VAIXELLS;
        while (numVaixells > 0) {
            int fila = (int) (Math.random() * COLUMNES);
            int columna = (int) (Math.random() * FILES);
            if (campBatalla[fila][columna] != 'V') { //SI NO EXISTEIX UN VAIXELL EN AQUESTA POSICIÓ
                campBatalla[fila][columna] = 'V'; //ASSIGNA UN VAIXELL EN AQUESTA POSICIÓ ALEATORIA
                numVaixells--;
            }
        }

        // Joc
        Scanner scanner = new Scanner(System.in);
        boolean finalitzat = false;
        while (!finalitzat) {
            // Mostrar camp de batalla
            System.out.println("Camp de batalla:");
            for (int i = 0; i < COLUMNES; i++) {
                for (int j = 0; j < FILES; j++) {
                    if (trets[i][j] != '-') {
                        System.out.print(trets[i][j] + " "); //MOSTRA ELS TRETS
                    } else {
                        System.out.print("- "); //MOSTRA LES CASELLES BUIDES
                    }
                }
                System.out.println();
            }
            // Demanar coordenades a l'usuari
            System.out.print("Introdueix fila (0-9): ");
            int fila = scanner.nextInt();
            System.out.print("Introdueix columna (0-9): ");
            int columna = scanner.nextInt();
            if (fila < 0 || fila >= COLUMNES || columna < 0 || columna >= FILES || trets[fila][columna] != '-') { //PER PREVENIR ERRORS HE UTILITZAT UN CONTINUE PER ANAR A LA SEGÜENT ITERACIÓ
                System.out.println("\nCoordenades invàlides!");
                System.out.println("Revisa que no hagis disparant anteriorment a aquesta cordenada \ni que els nombres inserits estan dins l'interval [0,9] \n");
                continue;
            }
            // Comprovar si ha encertat un vaixell o ha tocat aigua
            if (campBatalla[fila][columna] == 'V') {
                System.out.println("Has encertat un vaixell!");
                trets[fila][columna] = 'X'; //REGISTRA EN AQUESTA POSICIÓ QUE HA FERIT A UN VAIXELL
                campBatalla[fila][columna] = '-';
                vaixellsEnfonsats++;
                if (vaixellsEnfonsats == NUM_VAIXELLS) {
                    System.out.println("Felicitats, has enfonsat tots els vaixells! Has Guanyat!!!"); //S'HA ACABAT LA PARTIDA
                    finalitzat = true;
                }
            } else {
                System.out.println("Has tocat aigua!");
                trets[fila][columna] = 'O'; //REGISTRA EN AQUESTA POSICIÓ QUE HA TOCAT AIGUA
            }
        }
    }
}