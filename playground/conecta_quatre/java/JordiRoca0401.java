import java.util.Scanner;
public class JordiRoca0401 {
    public static void main(String[] args) {
        int a, b, i, j;
        Scanner entrada = new Scanner(System.in);

        a = entrada.nextInt();
        b = entrada.nextInt();

        i = a;
        j = 1;

        while(i <= b) {
            System.out.println(i + j);
            j *= 2;
            i += 1;
        }
        System.out.println(j);

        //He descomentat el while i he borrat l'asterisc i la barra que estaven pel mig,
        // ara aquest codi, ja és funcional
    }
}
