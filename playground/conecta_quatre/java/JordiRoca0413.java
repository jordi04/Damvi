import java.util.Scanner;

public class JordiRoca0413 {
    /*
    Escriu un programa que presenti el següent menú d’opcions relacionades amb les propietats dels triangles i que permeti resoldre les operacions indicades.
    Introduir longituds d’un triangle: demana tres valors positius i comprova que puguin correspondre als costats d’un triangle, tornant-los a demanar tantes vegades como 
    sigui necessari fins que puguin ser els d'un triangle.
    Comprovar si és triangle rectangle: comprova si les longituds vàlides introduïdes es corresponen amb els costats d’un triangle rectangle i, en aquest cas, mostra  la seva hipotenusa i els seus catets.
    Un triangle serà rectangle si per a alguna combinació dels seus costat es dona que h² = a² + b²
    Classificar d’acord als seus costats: classifica l’últim triangle vàlid segons sigui equilàter, isòsceles o escalè.
    Calcular perímetre i àrea: sent el perímetre la suma dels costats i l’àrea calculable a partir de la fórmula
    A=sqrt(s(s-a)(s-b)(s-c)),
    on a, b i c són els costats i s=1/2(a+b+c) és el semiperímetre.
    Sortir: mostra un missatge de comiat i acaba el programa.
 */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = 0, b = 0, c = 0;
        int opcio;
        boolean run = true;
        while (run) { //Bucle del menú d'opcions
            System.out.println("Menú d'opcions:");
            System.out.println("1- Introduir longituds del triangle");
            System.out.println("2- Comprovar si el triangle és rectangle");
            System.out.println("3- Classificar segons els seus costats");
            System.out.println("4- Calcular el perímetre i àrea");
            System.out.println("5- Sortir");
            System.out.print("Selecciona una opció: ");

            opcio = input.nextInt();
            System.out.println("");
            switch (opcio) { //Switch per executar la opcio escollida
                case 1: //Longituds triangle
                    do {
                        System.out.print("Introdueix la longitud a: ");
                        a = input.nextDouble();
                        System.out.print("Introdueix la longitud b: ");
                        b = input.nextDouble();
                        System.out.print("Introdueix la longitud c: ");
                        c = input.nextDouble();
                        System.out.println("");
                        if (!(a + b > c && a + c > b && b + c > a)) {
                            System.out.println("El triangle introduït no és un triangle real!!!");
                        }
                        else {
                            System.out.println("Molt bé, el triangle introduït és real\n");
                        }
                    } while (!(a + b > c && a + c > b && b + c > a));
                    break;

                case 2: //Comprova si el triangle es rectangle segons el teorema de pitàgores
                    if (a + b > c && a + c > b && b + c > a) {
                        if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                            System.out.println("\nÉs un triangle rectangle\n");
                            double hipotenusa = Math.sqrt(a * a + b * b);
                            System.out.println("\nHipotenusa: " + hipotenusa);
                            System.out.println("Catet a: " + a);
                            System.out.println("Catet b: " + b + "\n");
                        } else {
                            System.out.println("\nNo és un triangle rectangle\n");
                        }
                    } else {
                        System.out.println("Primer cal introduir les longituds del triangle.");
                    }
                    break;

                case 3: //Classifica el triangle depenent dels costats iguals que tengui
                    if (a + b > c && a + c > b && b + c > a) {
                        if (a == b && b == c) {
                            System.out.println("\nTriangle equilàter\n");
                        } else if (a == b || b == c || a == c) {
                            System.out.println("\nTriangle isòsceles\n");
                        } else {
                            System.out.println("\nTriangle escalè\n");
                        }

                    } else {
                        System.out.println("Primer cal introduir les longituds del triangle.");
                    }
                    break;

                case 4: //Calcula el perímetre i l'area del triangle donat
                    if (a + b > c && a + c > b && b + c > a) {
                        double perimetre = a + b + c;
                        double s = perimetre / 2;
                        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                        System.out.println("\nPerímetre: " + perimetre);
                        System.out.println("\nÀrea: " + area + "\n");

                    } else {
                        System.out.println("Primer cal introduir les longituds del triangle.");
                    }
                    break;

                case 5:
                    System.out.println("\nAdéu, fins aviat! \n");
                    run = false;
                    break;

                default:
                    System.out.println("Opció no vàlida. Torna a intentar.");
            }
        }
    }
}

