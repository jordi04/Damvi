import java.util.Scanner;
 class JordiRocaMatrius5 {
    /*
    Implementa un programa en Java que llegeixi del teclat les dades de dues matrius de mida 4x4, A i B,
    de valors enters. El programa ha de dir si la matriu A és major que la matriu B. Direm que és major
    si cadascun dels components d’A és major que el component que ocupa la mateixa posició en la matriu B.
    */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] A = new int[4][4];
        int[][] B = new int[4][4];

        System.out.println("A continuació insereix 16 valors per a cada matriu");
        //Omplim Matriu A
        System.out.println("Matriu A: ");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.print("Insereix un valor: ");
                A[i][j] = input.nextInt();
                System.out.println();
            }
        }
        //Omplim matriu B
        System.out.println("Matriu B: ");
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                System.out.print("Insereix un valor: ");
                B[i][j] = input.nextInt();
                System.out.println();
            }
        }

        //Comparació
        boolean major = true;
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (!(A[i][j] > B[i][j])) major = false;
            }
        }
        if (major) System.out.println("La matriu A és major que la matriu B");
        else System.out.println("La matriu A no és major que la matriu B");


    }
}
