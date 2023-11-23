import java.util.Scanner;
/*
 Fer un programa que empleni un vector de 6 elements de números aleatoris entre 1 i 49,
 sense repeticions. Després demanarà a l’usuari emplenar un altre vector amb números entre 1 i 49, 
 també sense repeticions. 
 El programa indicarà quants números coincideixen en els dos vectors. 
 Finalment mostrarà ambdós vectors per pantalla.
*/
public class JordiRoca0511 {
    public static void main(String[] args) {
        int[] vectorAl = new int[6];
        int[] vectorUs = new int[6];
        int nombreAleatori, nombreUsuari;
        boolean created = false;
        int count = 0;
        Scanner scanner = new Scanner(System.in); 
        for (int i = 0; i < 6; ++i){ //Cream el vector ALEATORI seguint les normes de la succesió de Fibonacci
            created = false;
            while (!created) { //Es repetirà fins que estiguem segurs que el nombre inserit no existeixi ja en el vector
                nombreAleatori = (int) (Math.random() * 49 + 1);
                for (int j = 0; j < vectorAl.length; j++) { //Iteram per el vector per comprovar que no conté un nombre igual
                    if (vectorAl[j] == nombreAleatori) j = vectorAl.length;
                    else if (j+1 == vectorAl.length) {
                        vectorAl[i] = nombreAleatori; // Assignam el valor al vector
                        created = true; // Sortim del while
                    }
                }
            }
        }
        for (int i = 0; i < 6; ++i){ //Cream el vector USUARI seguint les normes de la succesió de Fibonacci
            created = false;
            while (!created) { //Es repetirà fins que estiguem segurs que el nombre inserit compleix les condicions (no es repeteix i està dins l'interval [1,49])
                System.out.print("Insereix un nombre per afegir al vector: ");
                nombreUsuari = scanner.nextInt();
                System.out.println();
                for (int j = 0; j < vectorUs.length; j++) { //Iteram per el vector per comprovar que no conté un nombre igual
                    if (nombreUsuari < 1 || nombreUsuari > 49) j = vectorUs.length; //Comprova si el nombre és inclós dins l'interval
                    else if (vectorUs[j] == nombreUsuari) j = vectorUs.length; //Feim que es repateixi el while
                    else if (j+1 == vectorUs.length) {
                        vectorUs[i] = nombreUsuari; // Assignam el valor al vector
                        created = true; // Sortim del while
                    }
                }
            }
        }
        
        for (int i = 0; i < 6; ++i) { //COMPARAM ELS DOS VECTORS
            for (int j = 0; j < 6; ++j)
                if (vectorAl[i] == vectorUs[j]) {
                    count++;
                }
        }
        System.out.print("Vector de aleatori: ");
        for (int i = 0; i < 6; ++i) { //IMPRIMIM EL VECTOR ALEATORI
            System.out.printf("%d ", vectorAl[i]);
        }
        System.err.println();
        System.out.print("Vector de l'usuari: ");
        for (int i = 0; i < 6; ++i) { //COMPARAM ELS DOS VECTORS
            System.out.printf("%d ", vectorUs[i]);
        }
        System.err.println();
        System.out.printf("Els vector tenen %d valors en comú \n", count);
        
    }
}
