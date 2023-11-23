import java.util.Scanner;

public class JordiRocaMatrius2 {
    public static void main(String[] args) {
        // Definir la mida de la matriu
        int files = 10;
        int columnes = 10;

        // Inicialitzar la matriu
        int[][] matriu = new int[files][columnes];

        // Inicialitzar tots els elements de la matriu a 0
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                matriu[i][j] = 0;
            }
        }

        // Generar 20 posicions aleatòries i assignar valors aleatoris
        for (int k = 0; k < 20; k++) {
            int fila = (int) (Math.random() * files);
            int columna = (int) (Math.random() * columnes);
            int valor = (int) (Math.random() * 10 + 1);
            matriu[fila][columna] = valor;
        }

        // Demanar coordenades a l'usuari i mostrar el valor de la posició indicada
        Scanner scanner = new Scanner(System.in);
        boolean finalitzat = false;
        while (!finalitzat) {
            System.out.print("Introdueix fila (0-9) o -1 per sortir: ");
            int fila = scanner.nextInt();
            if (fila == -1) {
                finalitzat = true;
                continue; //PER EVITAR ERRORS
            }
            System.out.print("Introdueix columna (0-9): ");
            int columna = scanner.nextInt();
            if (fila >= 0 && fila < files && columna >= 0 && columna < columnes) {
                int valor = matriu[fila][columna];
                System.out.println("El valor de la posició [" + fila + "][" + columna + "] és: " + valor);
            } else {
                System.out.println("Coordenades invàlides!");
            }
        }
    }
}

