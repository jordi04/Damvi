//Declara i inicialitza un vector de 100 elements de manera que els components d’índex parell valguin 0 i els d’índex senar valguin 1.
public class JordiRoca0508 {
    public static void main(String[] args) {
        int[] vector = new int[100];

        for (int i = 0; i < 100; ++i){
            if (i%2 == 0) { //Comprova si és parell
                vector[i] = 0;
            }
            else vector[i] = 1; //Si no és parell, és senar
        }
        System.out.println("Imprimint vector: ");
        for (int i = 0; i < 100; i++) {
            System.out.print(vector[i] + " ");
        }
        
        
    }
}