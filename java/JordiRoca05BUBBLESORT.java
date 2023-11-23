
public class JordiRoca05BUBBLESORT {
    public static void main(String[] args) {
        int[] vector1 = new int[100];
        int[] vector2 = new int[100];
        int[] vector3 = new int[100];

        int aux = 0;

        int[] comparisons1 = new int[100];
        int[] comparisons2 = new int[100];
        int[] comparisons3 = new int[100];

        int sumaComp1 = 0;
        int sumaComp2 = 0;
        int sumaComp3 = 0;

        long temps1 = 0;
        long temps2 = 0;
        long temps3 = 0;
        for (int i = 0; i < 100; i++) {
            aux = ((int) (Math.random() * 1000));
            vector1[i] = aux;
            vector2[i] = aux;
            vector3[i] = aux;
        }

        //PRIMERA VERSIÓ
        temps1 = System.currentTimeMillis();
        for (int i = 0; i < vector1.length; i++) {

            for (int j = 0; j < vector1.length - 1 ; j++) {
                comparisons1[i]++;
                if (vector1[j] > vector1[j+1]) {
                    aux = vector1[j];
                    vector1[j] = vector1[j + 1];
                    vector1[j+1] = aux;
                }
            }
        }
        temps1 = (System.currentTimeMillis() - temps1);
        
        //SEGONA VERSIÓ
        temps2 = System.currentTimeMillis();
        for (int i = 0; i < vector2.length; i++) {
            boolean swapped = false;

            for (int j = 0; j < vector2.length - i - 1; j++) {
                comparisons2[i]++;
                if (vector2[j] > vector2[j + 1]) {
                    aux = vector2[j];
                    vector2[j] = vector2[j + 1];
                    vector2[j + 1] = aux;
                    swapped = true;
                }
            }

            if (!swapped) {
                // Si no s'ha realitzat cap intercanvi en aquesta passada, 
                //significa que el vector ja està ordenat.
                i = vector2.length;
            }
        }
        temps2 = (System.currentTimeMillis() - temps2);

        //TERCERA VERSIÓ
        temps3 = System.currentTimeMillis();
        boolean swapped;
        int j = 0;
        do { 
            swapped = false;
            for (int i = 0; i < vector3.length - 1; i++) {
                comparisons3[j]++;
                if (vector3[i] > vector3[i+1]) {
                    aux = vector3[i];
                    vector3[i] = vector3[i + 1];
                    vector3[i + 1] = aux;
                    swapped = true;
                }
            }
            j++;
        } while (swapped);
        temps3 = (System.currentTimeMillis() - temps3);
        for (int i = 0; i < comparisons1.length; i++) {
            sumaComp1 += comparisons1[i];
            sumaComp2 += comparisons2[i];
            sumaComp3 += comparisons3[i];
        }
        sumaComp1 = sumaComp1/100;
        sumaComp2 = sumaComp2/100;
        sumaComp3 = sumaComp3/100;

        System.out.println("Nombre de comaracions versió 1: " + sumaComp1 + " Temps execució: " +  temps1);
        System.out.println("Nombre de comaracions versió 2: " + sumaComp2 + " Temps execució: " +  temps2);
        System.out.println("Nombre de comaracions versió 3: " + sumaComp3 + " Temps execució: " +  temps3);

        //Potser ho he interpretat malament, perque la versió 2 i la 3 són bàsicament la mateixa de totes maneres no som capaç d'entendre la diferència en el resulat de comparacions.
        //En el meu parer la versió 2 i la 3 haurien de tenir el mateix resultat, pero no és el cas.
        //Tampoc entenc la inconsistencia en el milisegons de temps d'execució, potser és massa ràpid com per tenir una durada significativa
    }
}