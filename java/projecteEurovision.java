import java.util.Scanner;
import java.util.ArrayList;
// PROJECTE EUROVISIÓN

class Pais{
    String nom;
    ArrayList<Integer> puntuacions;

    //matriu de les puntuacions i al país al qui ha votat cada puntuació
    int[][] votacions = {{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}, {6, -1}, {7, -1}, {8, -1}, {10, -1}, {12, -1}};
     
} // OPCIÓ 1: Posar vector bidimensional aquí

// !!!!! ATENCIÓ !!!!!! POSEU COMENTARIS AL COSTAT DE CADA COSA PER SABER QUÈ FAN TIPO EN EL MAIN POSAR // main, el programa principal, necesita X coses

public class projecteEurovision { // Això és la classe MAIN
    public static boolean continua() { //preguntar al usuari si vol volver a fer las puntuacions amb els mateixos paisos
        Scanner input = new Scanner(System.in); //L'he convertit en local, m'han dit que en segundo ho prefereix
        boolean continuacio = false;
        System.out.print("\nvols volver a fer las puntuacions amb els mateixos paisos? ");
        String usuario = input.nextLine();
        if (usuario.toLowerCase().charAt(0) == 's') {
            continuacio = true;
        }
        System.out.printf("o\33c");
        return continuacio;
    }
    
    public static void ordenarPunts(final int N_PAISSOS, int numEdicio, Pais[] paissos){
        int num1 = 1;
        boolean ordenat = false;
        while (!ordenat) { // (== false) es el mateix que (!) davant
            ordenat = true;
            for (int j=0; j < N_PAISSOS-num1; j++) {
                if (paissos[j].puntuacions.get(numEdicio) < paissos[j+1].puntuacions.get(numEdicio)) {
                    Pais paisAux = paissos[j];
                    paissos[j] = paissos[j+1];
                    paissos[j+1] = paisAux; 
                    ordenat = false;
                }
            }
            num1++;
        }
    }

    public static void recompteVots(Pais paisVotant, Pais[] paissos, int numEdicio) {
        for (int i = 0; i < 10; i++) {
            int votsIndex = paisVotant.votacions[i][1];
            if (votsIndex != -1) {
                // Ensure that the index is valid
                if (votsIndex >= 0 && votsIndex < paissos.length) {
                    int currentScore = paissos[votsIndex].puntuacions.get(numEdicio);
                    paissos[votsIndex].puntuacions.set(numEdicio, (currentScore + paisVotant.votacions[i][0]));

                } else {
                    System.out.println("Invalid index: " + votsIndex);
                }
            }
        }
    }
    

    public static void votarRandom(Pais paisVotant, int n_paisvotant, final int N_VOTS) {
        int i, j, pais_random;
        boolean es_pot_votar, vot_fet;
        for (i = 0; i < N_VOTS; i++) {
            es_pot_votar = false;
            vot_fet = false;
            while (!vot_fet) { //per realitzar 1 vot
                pais_random = (int) (Math.random() * 26);
                //System.out.println(pais_random + " pais random");
                
                //és un for
                j = 0;
                while (!es_pot_votar) {
                    if ((paisVotant.votacions[j][1] == pais_random) || (paisVotant.votacions[j][1] == n_paisvotant)) {
                        es_pot_votar = true;
                        //System.out.println("Ja votat or " + paisVotant.votacions[j][1] + " és igual a " + pais_random + " o " + n_paisvotant);
                        //System.out.println(es_pot_votar);
                    }
                    j++;
                    if (j == N_VOTS-1) es_pot_votar = true;
                }

                paisVotant.votacions[i][1] = pais_random;
                //System.out.println("Ha votat: " + paisVotant.votacions[i][1]);
                vot_fet = true;
            }
        }
    }
    public static void printHistorial(ArrayList<ArrayList<Pais>> historialPuntuacions, int numEdicio, Pais[] paissos) {
        int i;
        do {
            for (i = 0; i < numEdicio; i++) {
                System.out.printf("EUROVISIÓ EDICIÓ %d\n",i);// PROBLEMA
                ordenarPunts(paissos.length, i, paissos);
                for (int j = 0; j < 26; j++){
                    System.out.println("El pais "+ historialPuntuacions.get(i).get(j).nom + " ha obtingut " + historialPuntuacions.get(i).get(j).puntuacions.get(i) + " vots");
                }
                System.out.println();
            }
        } while (i < numEdicio);
    }

    public static int menu(ArrayList<ArrayList<Pais>> historialPuntuacions, int numEdicio, Pais[] paissos) {
        Scanner input = new Scanner(System.in);
        int opcio = input.nextInt();
        switch (opcio){
            case 0:
                System.out.printf("prueba");
                printHistorial(historialPuntuacions, numEdicio, paissos);
                break;
            case 1: 
                System.out.printf("prueba");
                break;
            default: 
                return 0;
                
        }

    return 1;
    }












// MÈTODE MAIN
    public static void main(String[] args) { 
        final int N_PAISSOS = 26, N_VOTS = 10;
        int numEdicio = -1, opcio = 0;
        Pais[] paissos = new Pais[N_PAISSOS];
        boolean ordenat = false;

        //Matriu per guardar l'historial de totes les edicions de Eurovisió anteriors
        ArrayList<ArrayList<Pais>> historialPuntuacions = new ArrayList<>();
        //Inserir noms país  
        String[] nomsPaissos = {"Albània", "Alemanya", "Armènia", "Austràlia", "Àustria", "l'Azerbaidjan", "Bèlgica", "Xipre", "Croàcia", "República Txeca", "Dinamarca", "Eslovènia", "Espanya", "Estònia", "Finlàndia", "França", "Geòrgia", "Grècia", "Irlanda", "Islàndia", "Palestina", "Itàlia", "Letònia", "Lituània", "Malta", "Moldàvia"}; 
        for (int i = 0; i < 26; i++) {
            Pais pais_aux = new Pais();
            //Inicialitzam la array de puntuacions
            ArrayList<Integer> puntuacionsAux = new ArrayList<>();
            pais_aux.puntuacions = puntuacionsAux;
            pais_aux.puntuacions.add(0);

            pais_aux.nom = nomsPaissos[i];
            paissos[i] = pais_aux;
        }
        //Aquí comença el loop
        do {
            while (menu(historialPuntuacions, numEdicio, paissos) == 0) {
                
            }
            
            for (int i = 0; i < N_PAISSOS; i++) { //Sumam totes les votacions dels paissos
                //paissos[i].votacions = {{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}, {6, -1}, {7, -1}, {8, -1}, {10, -1}, {12, -1}};
                paissos[i].puntuacions.add(0);
            }
            //sumar any
            numEdicio++;
            
            for (int i = 0; i < N_PAISSOS; i++) {
                System.out.printf("Es el torn de %s ", paissos[i].nom);

                //Pas 1: (Torn d'un país) seleccionar aleatoriament les puntuacions
                votarRandom(paissos[i], i, N_VOTS); 

                for (int j = 0; j < N_VOTS; j++){
                    
                    System.out.printf("%s ha votat a %s amb %d punts", nomsPaissos[i], nomsPaissos[paissos[i].votacions[j][1]], paissos[i].votacions[j][0]);
                    System.out.println();
                }

            }
            for (int i = 0; i < N_PAISSOS; i++) { //Sumam totes les votacions dels paissos
                recompteVots(paissos[i], paissos, numEdicio);
            }
            //Pas 2: Ordenar les puntuacions
            
            ordenarPunts(N_PAISSOS, numEdicio, paissos); // ORDENAR PUNTS AQUÍ
            
            System.out.println();
            for (int i = 0; i < N_PAISSOS; i++) { //Sumam totes les votacions dels paissos
                System.out.println(paissos[i].nom + " té " + paissos[i].puntuacions.get(numEdicio) + " vots");
            }
            //Emmagatzemar dades a la matriu
            ArrayList<Pais> auxList = new ArrayList<>();
            for (int i = 0; i < N_PAISSOS; i++) {
                auxList.add(paissos[i]);
            }
            historialPuntuacions.add(auxList);
            //Imprimim historial
            printHistorial(historialPuntuacions, numEdicio, paissos);
            
        } while (continua());
    System.out.printf("Se finí");
    }
} 
