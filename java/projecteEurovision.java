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
    /*preguntar al usuari si vol volver a fer las puntuacions amb els mateixos paisos
    l'usuari posa l'input
    si l'usuari posa la lletra s el programa continuara, si no s'acabara*/

    public static void nextAny(Integer numEdicio, int N_PAISSOS, int N_VOTS, boolean ordenat, ArrayList<ArrayList<Pais>> historialPuntuacions, Pais[] paissos, String[] nomsPaissos) { 
        Scanner input = new Scanner(System.in); 
        for (int i = 0; i < N_PAISSOS; i++) { 
                //System.out.printf("Es el torn de %s\n", paissos[i].nom); (se ha quitado para hacer pruebas en caso de que lo necesitemos simplemente dice de quien es el turno )

                //Pas 1: (Torn d'un país) seleccionar aleatoriament les puntuacions
                votarRandom(paissos[i], i, N_VOTS); 
                
                /*for (int j = 0; j < N_VOTS; j++){
                    System.out.printf("%s ha votat a %s amb %d punts", paissos[i].nom, paissos[paissos[i].votacions[j][1]].nom, paissos[i].votacions[j][0]);
                    System.out.println();
                }(borrado para hacer pruebas en caso de hacer falta da los votos que da cada pais )*/  
                
            }
            
            for (int i = 0; i < N_PAISSOS; i++) { //Sumam totes les votacions dels paissos
                //paissos[i].votacions = {{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}, {6, -1}, {7, -1}, {8, -1}, {10, -1}, {12, -1}};
                paissos[i].puntuacions.add(0);
            }
        
            //sumar any
            numEdicio++;
            
            for (int i = 0; i < N_PAISSOS; i++) { //Sumam totes les votacions dels paissos
                recompteVots(paissos[i], paissos, numEdicio);
            }
            //Pas 2: Ordenar les puntuacions
            
            ordenarPunts(N_PAISSOS, numEdicio, paissos); // ORDENAR PUNTS AQUÍ
            
            /*System.out.println();
            for (int i = 0; i < N_PAISSOS; i++) { //Sumam totes les votacions dels paissos
                System.out.println(paissos[i].nom + " té " + paissos[i].puntuacions.get(numEdicio) + " vots");
            }*/
            //Emmagatzemar dades a la matriu
            ArrayList<Pais> auxList = new ArrayList<>();
            for (int i = 0; i < N_PAISSOS; i++) {
                auxList.add(paissos[i]);
            }
            historialPuntuacions.add(auxList);
            //Imprimim historial
            printHistorial(historialPuntuacions, numEdicio, paissos);
            System.out.printf("\nPress Enter to continue");
            input.nextLine();
            input.nextLine();
            
    }
    /*
    public static boolean continua() {
        Scanner input = new Scanner(System.in); 
        boolean continuacio = false;
        System.out.print("\nVols tornar al menú y afegir un any nou? \nS(Si)/N(No) -->  "); 
        String usuario = input.nextLine();
        if (usuario.toLowerCase().charAt(0) == 's') { 
            continuacio = true;
        }
        System.out.printf("o\33c");
        
        return continuacio;
    }
    */
    /*ordenar els paisos
    metodo bombolla dels paisos
    si el seguent numero es major que el seleccionat els intercambiara
        es guarda el numero seleccionat
        el numero seguente es guardara on estaba el numero seleccionat
        el numero seleccionat es pondra on estaba el seguent numero anteriorment
    una vegada tots el numeros estan ordenats es deixara de fer aquest while
    */
    public static void ordenarPunts(final int N_PAISSOS, Integer numEdicio, Pais[] paissos){
        int num1 = 1;
        boolean ordenat = false;
        while (!ordenat) {
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
    /*
    recompte de vots dels paisos
    */ 
    public static void recompteVots(Pais paisVotant, Pais[] paissos, Integer numEdicio) {
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


    public static void printHistorial(ArrayList<ArrayList<Pais>> historialPuntuacions, Integer numEdicio, Pais[] paissos) {
        int i;
        do {
            for (i = 0; i <= numEdicio; i++) {
                System.out.printf("EUROVISIÓ EDICIÓ %d\n",i);// PROBLEMA
                ordenarPunts(paissos.length, i, paissos);
                for (int j = 0; j < 26; j++){
                    System.out.println("El pais "+ historialPuntuacions.get(i).get(j).nom + " ha obtingut " + historialPuntuacions.get(i).get(j).puntuacions.get(i) + " vots");
                }
                System.out.println();
            }
        } while (i < numEdicio);
    }




//CASE 1

//Esto hace que el Case 1 tenga un sub menu para saber las votaciones de cada uno 
    public static void mostrarVotsPerPais(ArrayList<ArrayList<Pais>> historialPuntuacions, Integer numEdicio, Pais[] paissos) {
        Scanner input = new Scanner(System.in);
        int paisSeleccionat, puntuacio, votsIndex;
        String nomPaisVotat = "";
        
        System.out.println("Paisos i els seus vots:");
        for (int i = 0; i < paissos.length; i++) {
            System.out.printf("%d. %s\n", i + 1, paissos[i].nom);
        }
    
        System.out.print("Selecciona el número d'un país per veure els seus vots: ");
        paisSeleccionat = input.nextInt() -1;
    
        if ((paisSeleccionat >= 0) && (paisSeleccionat < paissos.length)) { 
            System.out.printf("Vots de %s:\n", paissos[paisSeleccionat].nom);
            for (int j = 0; j <= numEdicio; j++){ //Xapuza tremenda numEdicio-1
                for (int i = 0; i < paissos[paisSeleccionat].votacions.length; i++) {
                    votsIndex = paissos[paisSeleccionat].votacions[i][1];
                    puntuacio = paissos[paisSeleccionat].votacions[i][0];
                    if (votsIndex != -1){
                        nomPaisVotat = paissos[votsIndex].nom;

                        
                    }
            //Problema no funciona del todo bien
                    //System.out.println("El pais "+ historialPuntuacions.get(j).get(paisSeleccionat).nom + " ha sigut votat amb " + historialPuntuacions.get(j).get(paisSeleccionat).puntuacions.get(j) + " vots");
                    System.out.printf("\tVot %d: %s amb %d vots\n", i + 1, nomPaisVotat, puntuacio);
                }
            }
        } else {
            System.out.println("Selecció no vàlida.");
        }
    }
    










    



    
    













// MÈTODE MAIN
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        final int N_PAISSOS = 26, N_VOTS = 10;
        Integer numEdicio = -1;
        int opcio = 0;
        Pais[] paissos = new Pais[N_PAISSOS]; // Vector dels 26 paissos
        boolean ordenat = false;

        //Matriu per guardar l'historial de totes les edicions de Eurovisió anteriors
        ArrayList<ArrayList<Pais>> historialPuntuacions = new ArrayList<>();
        //Inserir noms país  
        String[] nomsPaissos = {"Albània", "Alemanya", "Armènia", "Austràlia", "Àustria", "l'Azerbaidjan", "Bèlgica", "Xipre", "Croàcia", "República Txeca", "Dinamarca", "Eslovènia", "Espanya", "Estònia", "Finlàndia", "França", "Geòrgia", "Grècia", "Irlanda", "Islàndia", "Palestina", "Itàlia", "Letònia", "Lituània", "Malta", "Moldàvia"}; 
        
        

        for (int i = 0; i < 26; i++) {
            //possiblement no fa falta sigui aux
            Pais pais_aux = new Pais();
            //Inicialitzam la array de puntuacions
            ArrayList<Integer> puntuacionsAux = new ArrayList<>();
            pais_aux.puntuacions = puntuacionsAux; // PQ PAIS AUXILIAR?!?!?!?!?!!!!??!?!!?!?!?!?!?!?!?!?!?!?!??!?!?!?!?!!??!?
            pais_aux.puntuacions.add(0);
            pais_aux.nom = nomsPaissos[i]; // Inserir noms dels països a la classe
            paissos[i] = pais_aux;
        }
        nextAny(numEdicio, N_PAISSOS,  N_VOTS, ordenat, historialPuntuacions, paissos, nomsPaissos);
        boolean continuar = true;
        
        while (continuar){      
            System.out.println();
            do {
                System.out.printf("o\33c----Benvingut a Eurovisió, selecciona una opció---- \n1. Llista dels paisos de millor a pitjor\n2. Historial de vots d'un país \n3. Per afegir un any nou \n0. Sortir \n");
                opcio = input.nextInt();
            } while ((opcio < 0) || (opcio > 3));
            
            switch (opcio){
                case 1: // Escull un país i et mostra a quí ha votat
                    /*for (int i = 0; i < paissos.length; i++){
                        System.out.printf("%d. %s\n",i+1, paissos[i].nom);
                    }*/
                    mostrarVotsPerPais(historialPuntuacions,numEdicio, paissos);
                    
                    break;

                case 2: // Fa un print de totes les puntuacions de totes les edicions
                    
                    printHistorial(historialPuntuacions, numEdicio, paissos);
                    break;

                case 3: // Afegir una nova edició amb totes les dades
                    nextAny(numEdicio, N_PAISSOS,  N_VOTS, ordenat, historialPuntuacions, paissos, nomsPaissos);
                    break;
                    
                case 0: // Sortir
                    System.out.println("S'ha seleccionat sortir.");
                    continuar = false;
                    break;

                default: 
                    System.out.printf("Opció no vàlida.");
            }
            if (continuar) {
                System.out.printf("\nPress Enter to continue");
                input.nextLine();
                input.nextLine();
            }
        }
        
        
        

        //Aquí comença el loop
        
    System.out.printf("S'ha acabat el programa de EuroVisió gracies per jugar\nSe finí");
    }
} 



