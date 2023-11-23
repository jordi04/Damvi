import java.util.Scanner;
public class JordiRoca0412 {
    /*
    Escriu un programa que vagi llegint valors des del teclat fins que s’introdueixi un -1.
    El programa haurà de:
    a) Sumar i comptar aquells números compresos entre 0 i 10
    b) Imprimir aquells que no suma
    c) Imprimir la mitjana dels números sumats.
    */
    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);
        double suma = 0;
        double mitjana = 0;
        double nombreEntrada = entrada.nextDouble();
        double i = 0; //quantitat nombres sumats per a fer la mitjana
        while (nombreEntrada != -1) { //El while s'executarà fins que s'introdueixi un -1
            if ((nombreEntrada >= 0) && (nombreEntrada <= 10)) {
                suma += nombreEntrada; //Afegim els nombres a la suma
                i++; //Sumam 1 a la quantitat de nombres sumats per poder fer aixi la mitjana
            }
            else {
                System.out.println("No es suma: " + nombreEntrada); //Imprimim els nombres no sumats ho he fet aixi perque supos que no podem utilitzar vectors on
                                                                    //emagatzemar els nombres per despres imprimir-los
            }
            nombreEntrada = entrada.nextDouble();
        }
        mitjana = suma/i;
        System.out.println("La suma es: " + suma + "\nLa mitjana es: " + mitjana); //IMPRIMIM EL RESULTAT
    }
}
