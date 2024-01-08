import java.util.Scanner;
// PROJECTE EUROVISIÓN

class Pais{
    String nom;
    int puntuacio = 0;
    
} // OPCIÓ 1: Posar vector bidimensional aquí
// !!!!! ATENCIÓ !!!!!! POSEU COMENTARIS AL COSTAT DE CADA COSA PER SABER QUÈ FAN TIPO EN EL MAIN POSAR // main, el programa principal, necesita X coses
public class projecte { // Això és el MAIN
public static Scanner input = new Scanner(System.in);
    public static boolean continua() { //preguntar al usuari si vol fer las puntuacions amb els mateixos paisos
        boolean continuacio = false;
        String usuario = input.nextLine();//chill
        if (usuario.toLowerCase().charAt(0) == 's') {
            continuacio = true;
        }
        return continuacio;
    }
    public static void votarPaisos(int numPaisVotant) { //Funció inutil
        int[] puntuacions = {1, 2, 3, 4, 5, 6, 7, 8, 10, 12};
        int[]
        for(int i = 0; i < 10; i++) {
            int random = (int) (Math.random() + 26);
            while (true) {
                if (random kys)
            }

        }
        
        
    }
    public static void main(String[] args) {
        final int N_PAISSOS = 26;
        
        Pais[] paissos = new Pais[N_PAISSOS];
        //Inserir noms país  
        String[] nomsPaissos = {"Albània", "Alemanya", "Armènia", "Austràlia", "Àustria", "l'Azerbaidjan", "Bèlgica", "Xipre", "Croàcia", "República Txeca", "Dinamarca", "Eslovènia", "Espanya", "Estònia", "Finlàndia", "França", "Geòrgia", "Grècia", "Irlanda", "Islàndia", "Palestina", "Itàlia", "Letònia", "Lituània", "Malta", "Moldàvia"}; 
        
        //Aquí comença el loop
        do {
            
            for (int i = 0; i < N_PAISSOS; i++) {
                printf("Es el torn de %s ", paissos[i].nom);

                //Pas 1: (Torn d'un país) seleccionar aleatoriament les puntuacions 
                
                //Pas 2: (Final torn del país) sumar punts
                //repetir 26 vegades
            }
            //Emmagatzemar dades matriu

        } while (continua());
    
    }
} 
