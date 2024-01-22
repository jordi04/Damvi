import java.util.ArrayList;
import java.util.Scanner;

class Pais {
    String nom;
    ArrayList<Integer> puntuacions;
    int[][] votacions = {{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}, {6, -1}, {7, -1}, {8, -1}, {10, -1}, {12, -1}};
}

public class projecteEurovisio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int N_PAISSOS = 26, N_VOTS = 10;
        int numEdicio = 0;
        Pais[] paissos = new Pais[N_PAISSOS];
        boolean continuar = true;

        ArrayList<ArrayList<Pais>> historialPuntuacions = new ArrayList<>();

        initializeCountries(paissos);

        do {
            System.out.println("\n----Benvingut a Eurovisió, selecciona una opció----");
            System.out.println("1. Llista dels països de millor a pitjor");
            System.out.println("2. Historial de vots d'un país");
            System.out.println("3. Afegir un any nou");
            System.out.println("0. Sortir");
            int opcio = input.nextInt();

            switch (opcio) {
                case 1:
                    mostrarVotsPerPais(historialPuntuacions, numEdicio, paissos);
                    break;

                case 2:
                    printHistorial(historialPuntuacions, numEdicio, paissos);
                    break;

                case 3:
                    nextAny(numEdicio, N_PAISSOS, N_VOTS, historialPuntuacions, paissos);
                    numEdicio++;
                    break;

                case 0:
                    System.out.println("S'ha seleccionat sortir.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }

            if (continuar) {
                System.out.println("\nPress Enter to continue");
                input.nextLine(); // Consume the newline character
                input.nextLine();
            }
        } while (continuar);

        System.out.println("S'ha acabat el programa de EuroVisió gràcies per jugar. Fins aviat!");
    }

    private static void initializeCountries(Pais[] paissos) {
        String[] nomsPaissos = {"Albània", "Alemanya", "Armènia", "Austràlia", "Àustria", "l'Azerbaidjan", "Bèlgica", "Xipre", "Croàcia", "República Txeca", "Dinamarca", "Eslovènia", "Espanya", "Estònia", "Finlàndia", "França", "Geòrgia", "Grècia", "Irlanda", "Islàndia", "Palestina", "Itàlia", "Letònia", "Lituània", "Malta", "Moldàvia"};

        for (int i = 0; i < paissos.length; i++) {
            Pais pais = new Pais();
            pais.puntuacions = new ArrayList<>();
            pais.puntuacions.add(0);
            pais.nom = nomsPaissos[i];
            paissos[i] = pais;
        }
    }

    private static void nextAny(int numEdicio, int N_PAISSOS, int N_VOTS, ArrayList<ArrayList<Pais>> historialPuntuacions, Pais[] paissos) {
        for (Pais pais : paissos) {
            votarRandom(pais, N_PAISSOS);
        }

        for (Pais pais : paissos) {
            pais.puntuacions.add(0);
        }

        for (Pais pais : paissos) {
            recompteVots(pais, paissos, numEdicio);
        }

        ordenarPunts(paissos, numEdicio);

        ArrayList<Pais> auxList = new ArrayList<>();
        for (Pais pais : paissos) {
            auxList.add(pais);
        }
        historialPuntuacions.add(auxList);

        printHistorial(historialPuntuacions, numEdicio, paissos);
    }

    private static void votarRandom(Pais paisVotant, int N_PAISSOS) {
        int[][] votacions = paisVotant.votacions;
        for (int i = 0; i < N_VOTS; i++) {
            int j, paisRandom;
            boolean esPotVotar, votFet;
            esPotVotar = false;
            votFet = false;

            while (!votFet) {
                paisRandom = (int) (Math.random() * N_PAISSOS);

                j = 0;
                while (!esPotVotar) {
                    if ((votacions[j][1] == paisRandom) || (votacions[j][1] == -1)) {
                        esPotVotar = true;
                    }
                    j++;
                    if (j == N_VOTS - 1) {
                        esPotVotar = true;
                    }
                }

                votacions[i][1] = paisRandom;
                votFet = true;
            }
        }
    }

    private static void recompteVots(Pais paisVotant, Pais[] paissos, int numEdicio) {
        for (int i = 0; i < paisVotant.votacions.length; i++) {
            int votsIndex = paisVotant.votacions[i][1];
            if (votsIndex != -1 && votsIndex < paissos.length) {
                int currentScore = paissos[votsIndex].puntuacions.get(numEdicio);
                paissos[votsIndex].puntuacions.set(numEdicio, currentScore + paisVotant.votacions[i][0]);
            }
        }
    }

    private static void ordenarPunts(Pais[] paissos, int numEdicio) {
        boolean ordenat = false;
        while (!ordenat) {
            ordenat = true;
            for (int j = 0; j < paissos.length - 1; j++) {
                if (paissos[j].puntuacions.get(numEdicio) < paissos[j + 1].puntuacions.get(numEdicio)) {
                    Pais paisAux = paissos[j];
                    paissos[j] = paissos[j + 1];
                    paissos[j + 1] = paisAux;
                    ordenat = false;
                }
            }
        }
    }

    private static void printHistorial(ArrayList<ArrayList<Pais>> historialPuntuacions, int numEdicio, Pais[] paissos) {
        System.out.printf("EUROVISIÓ EDICIÓ %d\n", numEdicio + 1);
        ordenarPunts(paissos, numEdicio);
        for (Pais pais : paissos) {
            System.out.printf("%s té %d vots\n", pais.nom, pais.puntuacions.get(numEdicio));
        }
        System.out.println();
    }

    private static void mostrarVotsPerPais(ArrayList<ArrayList<Pais>> historialPuntuacions, int numEdicio, Pais[] paissos) {
        Scanner input = new Scanner(System.in);
        int paisSeleccionat, puntuacio, votsIndex;
        String nomPaisVotat = "";

        System.out.println("Paisos i els seus vots:");
        for (int i = 0; i < paissos.length; i++) {
            System.out.printf("%d. %s\n", i + 1, paissos[i].nom);
        }

        System.out.print("Selecciona el número d'un país per veure els seus vots: ");
        paisSeleccionat = input.nextInt() - 1;

        if ((paisSeleccionat >= 0) && (paisSeleccionat < paissos.length)) {
            System.out.printf("Vots de %s:\n", paissos[paisSeleccionat].nom);
            for (int j = 0; j <= numEdicio; j++) {
                System.out.printf("\tEDICIÓ %d\n", j);
                for (int i = 0; i < paissos[paisSeleccionat].votacions.length; i++) {
                    votsIndex = paissos[paisSeleccionat].votacions[i][1];
                    puntuacio = paissos[paisSeleccionat].votacions[i][0];
                    if (votsIndex != -1) {
                        nomPaisVotat = paissos[votsIndex].nom;
                    }
                    System.out.printf("\tVot %d: %s amb %d vots\n", i + 1, nomPaisVotat, puntuacio);
                }
                System.out.println();
            }
        } else {
            System.out.println("Selecció no vàlida.");
        }
    }
}
