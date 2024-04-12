import java.util.Arrays;
import java.util.Random;

public class VectorInt {
    private int[] vector;

    public VectorInt() {
        this.vector = new int[5];
    }

    public VectorInt(int length) {
        this.vector = new int[length];
    }

    public void assignaValor(int valor, int posicio) {
        if (posicio >= 0 && posicio < vector.length) {
            vector[posicio] = valor;
        } else {
            System.out.println("Posicio fora dels límits del vector.");
        }
    }

    public int valorPosicio(int posicio) {
        if (posicio >= 0 && posicio < vector.length) {
            return vector[posicio];
        } else {
            System.out.println("Posicio fora dels límits del vector.");
            return -1;
        }
    }

    public void mostraVector() {
        System.out.println(Arrays.toString(vector));
    }

    public void valorsAleatoris(int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = rand.nextInt((max - min) + 1) + min;
        }
    }

    public void ordenaVector() {
        Arrays.sort(vector);
    }

    public static void main(String[] args) {
        VectorInt vec = new VectorInt(10);
        vec.valorsAleatoris(1, 100);
        System.out.println("Vector original:");
        vec.mostraVector();
        vec.ordenaVector();
        System.out.println("Vector ordenat:");
        vec.mostraVector();
    }
}
