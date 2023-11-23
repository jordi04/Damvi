/*
Fes un programa per emplenar un vector de 10 elements de valors enters positius entre 1 i 10.000.
El programa ha de garantir que els elements estan en ordre ascendent, però la condició és que es 
vagi emplenant ja en ordre ascendent, no que s'apliqui un algorisme d'ordenació una vegada ple.

Exemple de seqüència vàlida: 2, 5, 7, 8, 16, 22, 24, 26, ...
Exemple de seqüència incorrecta: 2, 3, 5, 6, 7, 6, ...

ATENCIÓ: encara que és improbable, és possible que el programa no pugui acabar en el cas que un dels 
primers elements trobats sigui un valor molt alt (per exemple, si el segon element que introduïm és el 9.999, ja no serà possible acabar d'emplenar el vector.
Se t'acut algun mètode perquè sigui sempre possible emplenar el vector complint la condició inicial?
*/
public class JordiRoca0507 {
    public static void main(String[] args) {
        int max = 10000;
        int min = 1;
        int valorAleatori;
        int[] vector = new int[10];

        System.out.println("Generant nombres aleatoris entre 1 i 10 per al vector...");
        for (int i = 0; i < 10; ++i){ // Omplim el vector amb nombres aleatoris
            valorAleatori = 0;
            max = 9991 + i; // Per assegurar que sempre es podrà omplir el vector de manera relativament aleatoria
            while (valorAleatori <= min) {
                valorAleatori = (int) (Math.random() * max + 1); // Generem un nombre aleatori 
            }
            vector[i] = valorAleatori; //Guardam el valor en el vector
            min = valorAleatori; // Ens asseguram de que tots els valors estan ordenats en ordre ascendent
        }
        System.out.println("Imprimint vector: ");
        for (int i = 0; i < 10; i++) { // Imprimim el vector
            System.out.print(vector[i] + " ");
        }
 
    }
}
