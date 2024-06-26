import java.util.Scanner;
import java.util.ArrayList;
// PROJECTE EUROVISIÓN

class Pais{
    String nom;
    int puntuacio = 0;

    //matriu de les puntuacions i al país al qui ha votat cada puntuació
    int[][] votacions = {{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}, {6, -1}, {7, -1}, {8, -1}, {10, -1}, {12, -1}};
     
} // OPCIÓ 1: Posar vector bidimensional aquí

class Any{
    int any;
    int[] puntuacio;
}
// !!!!! ATENCIÓ !!!!!! POSEU COMENTARIS AL COSTAT DE CADA COSA PER SABER QUÈ FAN TIPO EN EL MAIN POSAR // main, el programa principal, necesita X coses

public class projecte { // Això és el MAIN
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

    public static void recompteVots(Pais paisVotant, Pais[] paissos) { //Calcula la puntuació d'un païs en concret (torna void perquè es guarda la puntuació dins de cada Païs)
        for (int i = 0; i < 10; i++) {
            //paisVotant.votacions[i][1] és el país al qual ha votat 
            //paisVotant.votacions[i][0] és la puntuació a sumar al país votat
            paissos[paisVotant.votacions[i][1]].puntuacio += paisVotant.votacions[i][0];
        }
    }

    public static void votarRandom(Pais paisVotant, Pais[] paissos){ // Fa que un païs voti a tots els altres.
        int i, j, pais_random;
        boolean ja_votat, vot_fet;
        for (i = 0; i < 10; i++){
            ja_votat = false;
            vot_fet = false;
             do {
                pais_random = (int)(Math.random()*26)+1;
                for (j = 0; j < 10; j++){
                    if (paisVotant.votacions[1][j] != -1){
                        ja_votat = true;
                    }
                }
                if (!ja_votat){
                    paisVotant.votacions[i][1] = pais_random; //jr he canviat [1][i] per [i][1] 
                    // Aquí poso la quantitat votada.
                }

            } while (!vot_fet);
        }
    }
    
    public static void main(String[] args) {
        final int N_PAISSOS = 26;
        
        Pais[] paissos = new Pais[N_PAISSOS];
        
        //Inserir noms país  
        String[] nomsPaissos = {"Albània", "Alemanya", "Armènia", "Austràlia", "Àustria", "l'Azerbaidjan", "Bèlgica", "Xipre", "Croàcia", "República Txeca", "Dinamarca", "Eslovènia", "Espanya", "Estònia", "Finlàndia", "França", "Geòrgia", "Grècia", "Irlanda", "Islàndia", "Palestina", "Itàlia", "Letònia", "Lituània", "Malta", "Moldàvia"}; 
        
        //Aquí comença el loop
        do {
            //sumar any

            for (int i = 0; i < N_PAISSOS; i++) {
                System.out.printf("Es el torn de %s ", paissos[i].nom);

                //Pas 1: (Torn d'un país) seleccionar aleatoriament les puntuacions 
                votarRandom(paissos[i], paissos);
                
                //repetir 26 vegades
            }
            //Pas 2
            for (int i = 0; i < N_PAISSOS; i++) { //Sumam totes les votacions dels paissos
                recompteVots(paissos[i], paissos);
            }
            //Emmagatzemar dades matriu

        } while (continua());
    
    }
} 
