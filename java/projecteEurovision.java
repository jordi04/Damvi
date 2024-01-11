import java.util.Scanner;
import java.util.ArrayList;
// PROJECTE EUROVISIÓN

class Pais{
    String nom;
    int puntuacio = 0;

    //matriu de les puntuacions i al país al qui ha votat cada puntuació
    int[][] votacions = {{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}, {6, -1}, {7, -1}, {8, -1}, {10, -1}, {12, -1}};
    //int[][] votacions = {{1, 2, 3, 4, 5, 6, 7, 8, 10, 12}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
     
} // OPCIÓ 1: Posar vector bidimensional aquí

// !!!!! ATENCIÓ !!!!!! POSEU COMENTARIS AL COSTAT DE CADA COSA PER SABER QUÈ FAN TIPO EN EL MAIN POSAR // main, el programa principal, necesita X coses

public class projecteEurovision { // Això és el MAIN
    public static boolean continua() { //preguntar al usuari si vol volver a fer las puntuacions amb els mateixos paisos
        Scanner input = new Scanner(System.in); //L'he convertit en local, m'han dit que en segundo ho prefereix
        boolean continuacio = false;
        System.out.print("vols volver a fer las puntuacions amb els mateixos paisos? ");
        String usuario = input.nextLine();
        if (usuario.toLowerCase().charAt(0) == 's') {
            continuacio = true;
        }
        return continuacio;
    }

    public static void recompteVots(Pais paisVotant, Pais[] paissos) {
        for (int i = 0; i < 10; i++) {
            int votsIndex = paisVotant.votacions[i][1];
            if (votsIndex != -1) {
                // Ensure that the index is valid
                if (votsIndex >= 0 && votsIndex < paissos.length) {
                    paissos[votsIndex].puntuacio += paisVotant.votacions[i][0];
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
                System.out.println(pais_random + " pais random");
                
                //és un for
                j = 0;
                while (!es_pot_votar) {
                    if ((paisVotant.votacions[j][1] == pais_random) || (paisVotant.votacions[j][1] == n_paisvotant)) {
                        es_pot_votar = true;
                        System.out.println("Ja votat or " + paisVotant.votacions[j][1] + " és igual a " + pais_random + " o " + n_paisvotant);
                        System.out.println(es_pot_votar);
                    }
                    j++;
                    if (j == N_VOTS-1) es_pot_votar = true;
                }

                paisVotant.votacions[i][1] = pais_random;
                System.out.println("Ha votat: " + paisVotant.votacions[i][1]);
                vot_fet = true;
            }
        }
    }
    
    public static void main(String[] args) {
        final int N_PAISSOS = 26, N_VOTS = 10;
        int numEdicio = 0;
        Pais[] paissos = new Pais[N_PAISSOS];

        //Matriu per guardar l'historial de totes les edicions de Eurovisió anteriors
        ArrayList<ArrayList<Integer>> historialPuntuacions = new ArrayList<>();
        //Inserir noms país  
        String[] nomsPaissos = {"Albània", "Alemanya", "Armènia", "Austràlia", "Àustria", "l'Azerbaidjan", "Bèlgica", "Xipre", "Croàcia", "República Txeca", "Dinamarca", "Eslovènia", "Espanya", "Estònia", "Finlàndia", "França", "Geòrgia", "Grècia", "Irlanda", "Islàndia", "Palestina", "Itàlia", "Letònia", "Lituània", "Malta", "Moldàvia"}; 
        for (int i = 0; i < 26; i++) {
            Pais pais_aux = new Pais();
            pais_aux.nom = nomsPaissos[i];
            paissos[i] = pais_aux;
        }
        //Aquí comença el loop
        do {
            for (int i = 0; i < N_PAISSOS; i++) { //Sumam totes les votacions dels paissos
                paissos[i].puntuacio = 0;
                //paissos[i].votacions = {{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}, {6, -1}, {7, -1}, {8, -1}, {10, -1}, {12, -1}};
            }
            //sumar any
            numEdicio++;

            historialPuntuacions.add(new ArrayList<>());
            //votarRandom(paissos[2], 2, N_VOTS);
            
            for (int i = 0; i < N_PAISSOS; i++) {
                System.out.printf("Es el torn de %s ", paissos[i].nom);

                //Pas 1: (Torn d'un país) seleccionar aleatoriament les puntuacions
                votarRandom(paissos[i], i, N_VOTS); 

                System.out.println("cum");
                for (int j = 0; j < N_VOTS; j++){
                    
                    System.out.printf("%s ha votat a %s amb %d punts", nomsPaissos[i], nomsPaissos[paissos[i].votacions[j][1]], paissos[i].votacions[j][0]);
                    System.out.println();
                }
                System.out.println(i+ " nombre país");
                
                //repetir 26 vegades
            }
            //Pas 2
            for (int i = 0; i < N_PAISSOS; i++) { //Sumam totes les votacions dels paissos
                recompteVots(paissos[i], paissos);
                System.out.println(paissos[i].nom + " té " + paissos[i].puntuacio);
            }
            //Emmagatzemar dades matriu
            /*
            for (int i = 0; i < N_PAISSOS; i++) {
                historialPuntuacions.get(numEdicio).add(paissos[i].puntuacio);
            }*/
            

        } while (continua());
    
    }
} 
