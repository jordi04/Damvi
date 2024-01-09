import java.util.Scanner;
import java.util.ArrayList;

class Pais {
    String nom;
    int puntuacio = 0;
    int[][] votacions = { { 1, -1 }, { 2, -1 }, { 3, -1 }, { 4, -1 }, { 5, -1 }, { 6, -1 }, { 7, -1 }, { 8, -1 },
            { 10, -1 }, { 12, -1 } };
}

public class projecteGPT {
    public static boolean continua() {
        Scanner input = new Scanner(System.in);
        boolean continuacio = false;
        System.out.print("Vols tornar a fer les puntuacions amb els mateixos països? ");
        String usuario = input.nextLine();
        if (usuario.toLowerCase().charAt(0) == 's') {
            continuacio = true;
        }
        return continuacio;
    }

    public static void recompteVots(Pais paisVotant, Pais[] paissos) {
        for (int i = 0; i < 10; i++) {
            paissos[paisVotant.votacions[i][1]].puntuacio += paisVotant.votacions[i][0];
        }
    }

    public static void votarRandom(Pais paisVotant, int n_paisvotant, final int N_VOTS) {
        int pais_random;
        boolean ja_votat, vot_fet;
        for (int i = 0; i < N_VOTS; i++) {
            ja_votat = false;
            vot_fet = false;
            do {
                pais_random = (int) (Math.random() * 26);
                for (int j = 0; j < N_VOTS; j++) {
                    if ((paisVotant.votacions[j][1] == pais_random) || (paisVotant.votacions[j][1] == n_paisvotant)) {
                        ja_votat = true;
                    }
                }
                if (!ja_votat) {
                    paisVotant.votacions[i][1] = pais_random;
                    paisVotant.votacions[i][0] = (int) (Math.random() * 8 + 1); // Assign random points
                    vot_fet = true;
                }
            } while (!vot_fet);
        }
    }

    public static void main(String[] args) {
        final int N_PAISSOS = 26, N_VOTS = 10;
        int numEdicio = 0;
        Pais[] paissos = new Pais[N_PAISSOS];
        ArrayList<ArrayList<Integer>> historialPuntuacions = new ArrayList<>();

        for (int i = 0; i < N_PAISSOS; i++) {
            Pais pais_aux = new Pais();
            pais_aux.nom = nomsPaissos[i];
            paissos[i] = pais_aux;
        }

        do {
            numEdicio++;
            historialPuntuacions.add(new ArrayList<>()); // Initialize inner ArrayList for the current edition

            for (int i = 0; i < N_PAISSOS; i++) {
                System.out.printf("És el torn de %s%n", paissos[i].nom);
                votarRandom(paissos[i], i, N_VOTS);

                for (int j = 0; j < N_VOTS; j++) {
                    System.out.printf("%s ha votat a %s amb %d punts%n", paissos[i].nom, paissos[paissos[i].votacions[j][1]].nom,
                            paissos[i].votacions[j][0]);
                }
            }

            for (int i = 0; i < N_PAISSOS; i++) {
                recompteVots(paissos[i], paissos);
            }

            for (int i = 0; i < N_PAISSOS; i++) {
                historialPuntuacions.get(numEdicio - 1).add(paissos[i].puntuacio);
            }

        } while (continua());
    }
}
