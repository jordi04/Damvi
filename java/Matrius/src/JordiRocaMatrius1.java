public class JordiRocaMatrius1 {
    public static void main(String[] args) {
        // Definir el tamany de la matriu
        int files = 5;
        int columnes = 5;

        // Inicialitzar la matriu
        int[][] matriu = new int[files][columnes];

        // Inicialitzar tots els elements de la matriu a 0
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                matriu[i][j] = 0;
            }
        }

        // Mostrar el contingut de la matriu
        System.out.println("Contingut de la matriu:");
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }

        // Generar posicions aleatòries
        int fila1 = (int) (Math.random() * files);
        int columna1 = (int) (Math.random() * columnes);
        int fila2 = (int) (Math.random() * files);
        int columna2 = (int) (Math.random() * columnes);

        // Generar valors aleatoris
        int valor1 = (int) (Math.random() * 10);
        int valor2 = (int) (Math.random() * 10);

        // Assignar els valors aleatoris a les posicions aleatòries
        matriu[fila1][columna1] = valor1;
        matriu[fila2][columna2] = valor2;

        // Mostrar les coordenades on s'han introduït els nous valors
        System.out.println("Nous valors introduïts:");
        System.out.println("Valor " + valor1 + " a fila " + fila1 + ", columna " + columna1);
        System.out.println("Valor " + valor2 + " a fila " + fila2 + ", columna " + columna2);

        // Mostrar el contingut de la matriu amb els nous elements introduïts
        System.out.println("Contingut de la matriu amb els nous elements:");
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }
    }
}
