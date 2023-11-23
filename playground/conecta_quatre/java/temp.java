import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        int a, b, i, j;
        Scanner entrada = new Scanner(System.in);
        a = entrada.nextInt();
        b = entrada.nextInt();

        i = a;
        j = 1;

        while (i <= b) {
            System.out.println(i + j);
            j *= 2;
            i += 1;
        }
        System.out.println(j);
    }
}


/*

S'ha tancat el bloc del bucle while amb }. S'ha eliminat 
l'asterisc i la barra addicional al final del bloc del bucle.

S'ha tancat el mètode main amb }.

S'ha eliminat un asterisc i una barra addicional a la línia 
comentada que estava dins del bucle while. 

El comentari correcte ha de ser // en lloc de /*.

S'ha mogut la línia System.out.println(j); fora del bucle, 
ja que sembla que volies imprimir el valor final de j després de sortir del bucle.

*/