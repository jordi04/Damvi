import java.util.Scanner;
import java.util.ArrayList;
// PROJECTE EUROVISIÓN

class Pais{
    String nom;
    ArrayList<Integer> puntuacions;

    //matriu de les puntuacions i al país al qui ha votat cada puntuació
    int[][] votacions = {{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}, {6, -1}, {7, -1}, {8, -1}, {10, -1}, {12, -1}};
     
}

public class projecteEurovision { // Això és la classe MAIN
    /*preguntar al usuari si vol volver a fer las puntuacions amb els mateixos paisos
    l'usuari posa l'input
    si l'usuari posa la lletra s el programa continuara, si no s'acabara*/
    // MÈTODE MAIN
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        final int N_PAISSOS = 26, N_VOTS = 10;
        Integer numEdicio = 0;
        int opcio = 0;
        Pais[] paissos = new Pais[N_PAISSOS]; // Vector dels 26 paissos
        Pais[] paissosOrdenats = new Pais[N_PAISSOS];
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
            paissosOrdenats[i] = pais_aux;
        }
        nextAny(numEdicio, N_PAISSOS,  N_VOTS, ordenat, historialPuntuacions, paissos, paissosOrdenats, nomsPaissos);
        numEdicio++;
        boolean continuar = true;
        
        while (continuar){      
            System.out.println();

            System.out.printf("----Benvingut a Eurovisió, selecciona una opció---- \n1. Llista dels paisos de millor a pitjor\n2. Historial de puntuacions dels paissos de totes les edicions\n3. Per afegir un any nou\n" + //
                    "4. Mostrar les votacions que ha fet un país a la darrera edició\n5. Mostrar tots els votants d'un país a la darrera edició\n0. Sortir \n");
            opcio = input.nextInt();
            
            switch (opcio){
                case 1: // Escull un país i et mostra a quí ha votat A LA DARRERA EDICIÓ
                    rankingPaissosDarreraEdicio(paissosOrdenats);
                    break;
                case 2: // Fa un print de totes les puntuacions de totes les edicions
                    printHistorial(historialPuntuacions, numEdicio, paissosOrdenats);
                    break;
                case 3: // Afegir una nova edició amb totes les dades
                    nextAny(numEdicio, N_PAISSOS,  N_VOTS, ordenat, historialPuntuacions, paissos , paissosOrdenats, nomsPaissos);
                    numEdicio++;
                    break;
                case 4:
                    rankingPaissosDarreraEdicio(paissos);
                    mostrarVotsPerPais(paissos);
                    break;
                case 5: 
                    //mostra tots els paissos que han votat a un país
                    rankingPaissosDarreraEdicio(paissos);
                    mostrarVotantsPais(paissos);
                    break;
                case 6:
                    for (int i = 0; i < paissos.length; i++){
                        System.out.println(paissos[i].nom);
                    }

                    System.out.println("Ordenats \n");

                    for (int i = 0; i < paissosOrdenats.length; i++){
                        System.out.println(paissosOrdenats[i].nom);
                    }
                    break;
                case 0: // Sortir
                    System.out.println("S'ha seleccionat sortir.");
                    continuar = false;
                    break;
                default: 
                    System.out.printf("Opció no vàlida.");
            }
            if (continuar) {
                        String patron =
                "⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠀⣠⣤⣤⣤⣤⣴⣿⣿⣿⣿⣿⣿⡟⠛⠛⣿⣿⣿⣿⣿⣿\n" +
                "⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⠟⢹⣿⣿⣿⣿⡇⠀⠀⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⠟⠁⠀⠸⠿⠿⠿⠿⠃⠀⢀⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣷⣄⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣷⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿";
  
                System.out.printf("\nPress Enter to continue \n%s", patron);
                if (input.hasNextLine()) {
                    input.nextLine(); // Consume the input
                }
                input.nextLine();
            }
        }
        
        
        

        //Aquí comença el loop
        
    System.out.printf("S'ha acabat el programa de EuroVisió gracies per jugar\nSe finí");
    }











    public static void nextAny(Integer numEdicio, int N_PAISSOS, int N_VOTS, boolean ordenat, ArrayList<ArrayList<Pais>> historialPuntuacions, Pais[] paissos, Pais[] paissosOrdenats, String[] nomsPaissos) { 
        Scanner input = new Scanner(System.in); 
        for (int i = 0; i < N_PAISSOS; i++) { 
                //Pas 1: (Torn d'un país) seleccionar aleatoriament les puntuacions
                votarRandom(paissos[i], i, N_VOTS, paissos, numEdicio); 
            }
            
            for (int i = 0; i < N_PAISSOS; i++) { //Inicialitzam les puntuacions a 0
                paissos[i].puntuacions.add(0);
            }
            //Pas 2: Ordenar les puntuacions
            for (int i = 0; i < N_PAISSOS; i++) { //Inicialitzam les puntuacions a 0
                paissosOrdenats[i] = paissos[i];
            }
            ordenarPunts(N_PAISSOS, numEdicio, paissosOrdenats); // Ordenam els paissos per puntuacions

            //Emmagatzemar dades a la matriu
            ArrayList<Pais> auxList = new ArrayList<>();
            for (int i = 0; i < N_PAISSOS; i++) {
                auxList.add(paissosOrdenats[i]);
            }
            historialPuntuacions.add(auxList);
            //Imprimim historial
            printHistorial(historialPuntuacions, numEdicio, paissosOrdenats);
    }

    //Ordena els paissos per puntuacions al vector paissos
    public static void ordenarPunts(final int N_PAISSOS, Integer numEdicio, Pais[] paissosOrdenats){
        int num1 = 1;
        boolean ordenat = false;
        while (!ordenat) {
            ordenat = true;
            for (int j=0; j < N_PAISSOS-num1; j++) {
                if (paissosOrdenats[j].puntuacions.get(numEdicio) < paissosOrdenats[j+1].puntuacions.get(numEdicio)) {
                    //System.out.println("LLEGIU AIXÒ: " + paissos[j].puntuacions.get(numEdicio));
                    Pais paisAux = paissosOrdenats[j];
                    paissosOrdenats[j] = paissosOrdenats[j+1];
                    paissosOrdenats[j+1] = paisAux; 
                    ordenat = false;
                }
            }
            num1++;
        }  
    }
    

    //Escull a quins paissos votar i assigna una puntuació aleatoria a cada un d'ells 
    public static void votarRandom(Pais paisVotant, int n_paisvotant, final int N_VOTS, Pais[] paissos, Integer numEdicio) {
        int i, j, pais_random;
        boolean es_pot_votar, vot_fet;
        System.out.println(paisVotant.nom);
        for (i = 0; i < N_VOTS; i++) {
            vot_fet = false;
            while (!vot_fet) { //per realitzar 1 vot
                es_pot_votar = true;
                pais_random = (int) (Math.random() * 26);
                
                //és un for
                j = 0;
                boolean run = true;
                while (run) {
                    if ((paisVotant.votacions[j][1] == pais_random) || (pais_random == n_paisvotant)) {
                        es_pot_votar = false;
                        run = false;
                    }
                    j++;
                    if (j == N_VOTS) run = false;  
                }
                if (es_pot_votar) {
                    paisVotant.votacions[i][1] = pais_random;
                    int currentScore = paissos[pais_random].puntuacions.get(numEdicio); // Recompte de paissos
                    paissos[pais_random].puntuacions.set(numEdicio, currentScore + paisVotant.votacions[i][0]);
                    //System.out.println(paisVotant.votacions[i][1]); //per comprovar que es voten als mateixos paissos
                    vot_fet = true;
                }
                
            }
        }
    }

public static void printHistorial(ArrayList<ArrayList<Pais>> historialPuntuacions, Integer numEdicio, Pais[] paissosOrdenats) {
    System.out.println("Històric de votacions:");

    for (int i = 0; i < historialPuntuacions.size(); i++) {
        System.out.printf("EUROVISIÓ EDICIÓ %d\n", i + 1);

        // Ordenar puntuaciones antes de mostrarlas
        ordenarPunts(paissosOrdenats.length, i, paissosOrdenats);

        for (int j = 0; j < paissosOrdenats.length; j++) {
            Pais pais = paissosOrdenats[j];
            System.out.printf("%s: %d vots\n", pais.nom, pais.puntuacions.get(i));
        }

        System.out.println();
    }
}

    //Case 1 del menú, imprimeix el ranking dels paissos de la darrera edició, també s'utilitza al Case 4,
    public static void rankingPaissosDarreraEdicio(Pais[] paissos) {
        
        
        System.out.println("Paissos i els seus vots:");
        for (int i = 0; i < paissos.length; i++) {
            System.out.printf("%d. %s\n", i + 1, paissos[i].nom);
        }
    }

    //Case 4 del menú, imprimeix tots els 10 paissos que un país ha votat
    public static void mostrarVotsPerPais(Pais[] paissos) {
        Scanner input = new Scanner(System.in);
        int paisSeleccionat, puntuacio, votsIndex;
        String nomPaisVotat = "";
        System.out.print("Selecciona el número d'un país per veure els seus vots: ");
        paisSeleccionat = input.nextInt() -1;
    
        if ((paisSeleccionat >= 0) && (paisSeleccionat < paissos.length)) { 
            System.out.printf("Vots de %s:\n", paissos[paisSeleccionat].nom);
            System.out.printf("\t DARRERA EDICIÓ\n");
            for (int i = 0; i < paissos[paisSeleccionat].votacions.length; i++) {
                votsIndex = paissos[paisSeleccionat].votacions[i][1];
                puntuacio = paissos[paisSeleccionat].votacions[i][0];
                if (votsIndex != -1){
                    nomPaisVotat = paissos[votsIndex].nom;
                    System.out.printf("\tVot %d: %s amb %d vots\n", i + 1, nomPaisVotat, puntuacio);
                }
                System.out.println();
            }
        } else {
            System.out.println("Selecció no vàlida.");
        }
    }
    
    public static void mostrarVotantsPais(Pais[] paissos) {
        Scanner input = new Scanner(System.in);
        int paisSeleccionat, puntuacio, votsIndex;
        String nomPaisVotant = "";
        System.out.print("Selecciona el número d'un país per veure els seus vots: ");
        paisSeleccionat = input.nextInt() -1;
    
        if ((paisSeleccionat >= 0) && (paisSeleccionat < paissos.length)) { 
            System.out.printf("Vots de %s:\n", paissos[paisSeleccionat].nom);
            System.out.printf("\t DARRERA EDICIÓ\n" + paissos.length);

            for (int j = 0; j < paissos.length; j++) {
                for (int i = 0; i < paissos[j].votacions.length; i++) {
                    votsIndex = paissos[j].votacions[i][1];
                    puntuacio = paissos[j].votacions[i][0];
                    if (votsIndex == paisSeleccionat){
                        nomPaisVotant = paissos[j].nom;
                        System.out.printf("\t%s ha votat a %s amb %d vots\n",nomPaisVotant, paissos[paisSeleccionat].nom, puntuacio);
                    }
                }
            }
            
        } else {
            System.out.println("Selecció no vàlida.");
        }
    }
} 



