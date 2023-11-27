import java.util.Scanner;
class Persona{  // <-- Definició d'una classe amb nom persona
    String nom;
    String primerCognom;
    String segonCognom;
    int edat;
    double altura;
}
public class JordiRocaA20 {
    public static void main(String[] args) {
        /*
        Fes un programa en Java que llegeix les dades de 5 persones (nom, primer cognom, segon cognom, edat i alçada),
        després mostra la informació per pantalla, i a continuació demana per teclat dos valors entre 1 i 5
        (posicions del vector), i intercanvia el contingut d'aquestes dues posicions. Per comprovar que ho fa bé,
        s'ha de tornar a mostrar la informació del vector.
        */
        Scanner input = new Scanner(System.in);

        Persona[] persones = new Persona[5];

        for (int i = 0; i < persones.length; ++i) {
            System.out.println("Persona num #" + (i+1));
            persones[i] = new Persona();
            System.out.print("Nom de la persona: ");
            persones[i].nom = input.nextLine();
            System.out.print("Primer cognom: ");
            persones[i].primerCognom = input.nextLine();
            System.out.print("Segon cognom: ");
            persones[i].segonCognom = input.nextLine();
            System.out.print("Edat de la persona: ");
            persones[i].edat = input.nextInt();
            System.out.print("Altura de la persona en metres: ");
            persones[i].altura = input.nextDouble();
            input.nextLine();
        }


        for (int i = 0; i < persones.length; ++i) {
            System.out.printf("\n\n %d)La persona %s %s %s té %d anys i fa %f metres d'altura", i+1, persones[i].nom, persones[i].primerCognom, persones[i].segonCognom, persones[i].edat, persones[i].altura);
        }

    }
}

