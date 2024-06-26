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
            System.out.printf("o\33c ----Benvingut a Eurovisió, selecciona una opció---- \n1. Llista dels paisos de millor a pitjor\n2. Historial de puntuacions dels paissos de totes les edicions\n3. Per afegir un any nou\n" + //
                    "4. Mostrar les votacions que ha fet un país a la darrera edició\n5. Mostrar tots els votants d'un país a la darrera edició\n" +
                    "6. Mostrar puntuacions i posicions anteriors d'un país\n7. Mostra els païssos amb millor puntuació històrica i el país que més ha guanyat\n" + // 
                    "\n0. Sortir \n");
            opcio = input.nextInt();
            
            switch (opcio){
                /* ESTILITZAT */
                case 1: // Escull un país i et mostra a quí ha votat A LA DARRERA EDICIÓ
                    rankingPaissosDarreraEdicio(paissosOrdenats);
                    break;
                /* ESTILITZAT */
                case 2: // Fa un print de totes les puntuacions de totes les edicions
                    printHistorial(historialPuntuacions, numEdicio, paissosOrdenats);
                    break;
                /* ESTILITZAT */
                case 3: // Afegir una nova edició amb totes les dades
                    nextAny(numEdicio, N_PAISSOS,  N_VOTS, ordenat, historialPuntuacions, paissos , paissosOrdenats, nomsPaissos);
                    numEdicio++;
                    break;
                case 4: // Mostra els paissos per ordre de més votat a menys
                    rankingPaissosDarreraEdicio(paissos);
                    mostrarVotsPerPais(paissos);
                    break;
                case 5: 
                    //mostra tots els paissos que han votat a un país
                    rankingPaissosDarreraEdicio(paissos);
                    mostrarVotantsPais(paissos);
                    break;

                case 6: 
                    rankingPaissosDarreraEdicio(paissos);
                    int paisSeleccionat = seleccionaUnPais();
                    mostrarPuntuacionsAnteriorsPais(paisSeleccionat, historialPuntuacions, paissos);
                    break;
                case 7:
                    //mostrar els paissos que més vegades han guanyat
                    //mostrar els paissos que més punts han aconseguit de totes les edicions ivvan es totntu
                    millorsPaissos(paissos, historialPuntuacions);
                    break;
                
                case 0: // Sortir
                    System.out.println("S'ha seleccionat sortir.");
                    continuar = false;
                    break;
                default: 
                    System.out.printf("Opció no vàlida.");
            }
            if (continuar) {
                System.out.printf("\nPress Enter to continue ↵\n");
                if (input.hasNextLine()) {
                    input.nextLine(); // Consume the input
                }
                input.nextLine();
            }
        }
        
        
        

        //Aquí comença el loop
        
    System.out.printf("S'ha acabat el programa de EuroVisió gracies per jugar\nSe finí");
    }

    public static void millorsPaissos(Pais[] paissos, ArrayList<ArrayList<Pais>> historialPuntuacions) {
        int paisIndexPuntuacioMesAlta = 0, paisIndexMesGuanyador = 0;
        int sumaPuntuacionsMesAlta = 0, mesVegadesGuanyador = 0;
        int sumaPuntuacions = 0;
        int vegadesGuanyador = 0;
        for (int i = 0; i < paissos[i].puntuacions.size()-1; i++) { //itera les edicions
            sumaPuntuacions = 0;
            vegadesGuanyador = 0;
            for (int indexPais = 0; indexPais < paissos.length; indexPais++) {
                boolean found = false;
                int j = -1;
                while (!found) {
                    j++;
                    if (historialPuntuacions.get(i).get(j).nom == paissos[indexPais].nom) {
                        found = true;
                    }
                }
                sumaPuntuacions += historialPuntuacions.get(i).get(j).puntuacions.get(i);
                
                if (j == 0) vegadesGuanyador++;
                System.out.println(sumaPuntuacions + " cum " + vegadesGuanyador);
            }

            if (sumaPuntuacions > sumaPuntuacionsMesAlta) { //Asigna el nou país amb la puntuació més alta
                sumaPuntuacionsMesAlta = sumaPuntuacions;
                paisIndexPuntuacioMesAlta = i;
            }
            
            if (vegadesGuanyador > mesVegadesGuanyador) { //Asigna el nou país que més vegades ha guanyat
                mesVegadesGuanyador = vegadesGuanyador;
                paisIndexMesGuanyador = i;
            }
        }
        System.out.println("El país que ha guanyat més cops ha estat: " +  paissos[paisIndexMesGuanyador].nom + //
        "\n\nEl país amb la puntuació més alta al llarg de totes les edicions és: " + paissos[paisIndexMesGuanyador].nom + 
        " amb " + mesVegadesGuanyador + " punts en total");
    }

    public static int seleccionaUnPais() {
        Scanner input = new Scanner(System.in);
        System.out.print("Selecciona el número d'un país per veure les seves anteriors puntuacions: ");
        return input.nextInt() -1;
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

    //AMPLIACIÓ 1
    // Desempata en ordenar punts, per si tenen el mateix número de punts que hi hagi un guanyador fixe
    // Desempata en ordenar punts, per si tenen el mateix número de punts que hi hagi un guanyador fixe
    public static boolean desempatGuanya(int numPais1, final int N_PAISSOS, Integer numEdicio, Pais[] paissosOrdenats){
        boolean guanyanumPais = false, ordenat = false; 
        int recompte1 = 0, recompte2 = 0, votsIndex, numPais2 = numPais1+1, max = 0, valorDelVot = 9;

        //Primera condició (Guanya el que més vots tengui és a dir, més païssos l'hagin votat)
        recompte1 = 0;
        recompte2 = 0;
        for (int j = 0; j < paissosOrdenats.length; j++) { // RECORD DE DESEMPAT EN EL  (12 iguals, 10 iguals, 8 iguals, 7 iguals) I TRIPLE EMPAT6
            for (int i = 0; i < paissosOrdenats[j].votacions.length; i++) {
                votsIndex = paissosOrdenats[j].votacions[i][1];

                if (votsIndex == numPais1){
                    recompte1++;
                }
                else if (votsIndex == numPais2){
                    recompte2++;
                }
            }
        }

        //En principi funciona, ho comprovaré més extensament
        if (recompte1 < recompte2) {
            guanyanumPais = false;
            return guanyanumPais;
        }
        else if (recompte1 > recompte2) {
            guanyanumPais = true;
            return guanyanumPais;
        }
        //continua si són iguals
        
        while (!ordenat && max != 10){
            //Segona condició
            recompte1 = 0;
            recompte2 = 0;
            for (int j = 0; j < paissosOrdenats.length; j++) { // RECORD DE DESEMPAT EN EL  (12 iguals, 10 iguals, 8 iguals, 7 iguals) I TRIPLE EMPAT6
                for (int i = 0; i < paissosOrdenats[j].votacions.length; i++) {
                    
                    votsIndex = paissosOrdenats[j].votacions[i][1]; //pais a qui vota
                    int puntsVotats  = paissosOrdenats[j].votacions[i][0];
                    //System.out.println(votsIndex);
                    if (votsIndex == numPais1 && puntsVotats == paissosOrdenats[j].votacions[valorDelVot][0]){
                        recompte1++;
                    }
                    else if (votsIndex == numPais2 && puntsVotats == paissosOrdenats[j].votacions[valorDelVot][0]){
                        recompte2++;
                    }
                }
                //no entenc perquè hi ha aquest for, és exactament l'anterior, l'if es pot ficar a l'altre
            }
            max++;
            valorDelVot--;
        }
        if (recompte1 < recompte2) {
            guanyanumPais = true;
            return guanyanumPais;
        }
        guanyanumPais = false;
        return guanyanumPais;
    }


    
    //Ordena els paissos per puntuacions al vector paissos
    public static void ordenarPunts(final int N_PAISSOS, Integer numEdicio, Pais[] paissosOrdenats){
        int num1 = 1;
        boolean ordenat = false;
        Pais paisAux;
        while (!ordenat) {
            ordenat = true;
            for (int j=0; j < N_PAISSOS-num1; j++) {
                if (paissosOrdenats[j].puntuacions.get(numEdicio) < paissosOrdenats[j+1].puntuacions.get(numEdicio)) {
                    //System.out.println("LLEGIU AIXÒ: " + paissos[j].puntuacions.get(numEdicio));
                    paisAux = paissosOrdenats[j];
                    paissosOrdenats[j] = paissosOrdenats[j+1];
                    paissosOrdenats[j+1] = paisAux; 
                    ordenat = false;
                }
                else if (paissosOrdenats[j].puntuacions.get(numEdicio) == paissosOrdenats[j+1].puntuacions.get(numEdicio)){
                    if (desempatGuanya(j, N_PAISSOS, numEdicio, paissosOrdenats)){ //Si hi ha triple empat tenim problema
                        paisAux = paissosOrdenats[j];
                        paissosOrdenats[j] = paissosOrdenats[j+1];
                        paissosOrdenats[j+1] = paisAux; 
                        ordenat = false;
                    }
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
            System.out.printf("\t              --------EUROVISIÓ EDICIÓ %d--------\n", i + 1);

            // Ordenar puntuaciones antes de mostrarlas
            ordenarPunts(paissosOrdenats.length, i, paissosOrdenats);
            System.out.printf("\t _______________________________________________________________\n");
            for (int j = 0; j < paissosOrdenats.length-13; j++) { // -13 perquè és la meitat i així no hem de fer (int) / 2...
                Pais pais = paissosOrdenats[j];
                Pais pais2 = paissosOrdenats[j+13]; // +13 per fer la segona columna
                System.out.printf("\t| %-18s: %3d punts | %-18s: %3d punts |\n", pais.nom, pais.puntuacions.get(i), pais2.nom, pais2.puntuacions.get(i));
                System.out.printf("\t|_______________________________|_______________________________|\n");
            }
            
            System.out.println();
        }
    }


    //Case 1 del menú, imprimeix el ranking dels paissos de la darrera edició, també s'utilitza al Case 4,
    public static void rankingPaissosDarreraEdicio(Pais[] paissos) {
       int nyu = 13;
       System.out.printf("\t          --------Paissos i els seus vots--------\n");
       System.out.printf("\t _________________________________________________\n");
        for (int i = 0; i < paissos.length-13; i++) {
            System.out.printf("\t| %2d. %-18s | %2d. %-18s |\n", i + 1, paissos[i].nom, nyu + 1, paissos[nyu].nom);
            System.out.printf("\t|________________________|________________________|\n");
            nyu++;
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
            System.out.printf("\t Vots de %s:\n", paissos[paisSeleccionat].nom);
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
    
    public static void mostrarPuntuacionsAnteriorsPais(int paisSeleccionat, ArrayList<ArrayList<Pais>> historialPuntuacions, Pais[] paissos) {
        
        for (int i = 0; i < paissos[i].puntuacions.size()-1; i++) {
            System.out.println();
            boolean found = false;
            int j = 0;
            while (!found) {
                if (historialPuntuacions.get(i).get(j).nom == paissos[paisSeleccionat].nom) {
                    System.out.println("Edició "+ (i+1) + ":\n" + "Puntuació: "+ paissos[i].puntuacions.get(i) + "\nPosició: " + (j+1) + " de " + historialPuntuacions.get(i).size());
                    found = true;
                }
                j++;
            }
        }
    }

} 


