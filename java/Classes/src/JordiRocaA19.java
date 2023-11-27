import java.util.Scanner;
class Persona{  // <-- Definició d'una classe amb nom persona
    String nom;
    String primerCognom;
    String segonCognom;
    int edat;
    double altura;
}
public class JordiRocaA19 {
    public static void main(String[] args) {
        /*
        Fes un programa en Java que treballa amb una classe (class) Persona que emmagatzema la informació d'una persona:
         nom, primer cognom, segon cognom, edat i alçada (en metres). El programa haurà de llegir tota la informació
         d'una persona i a continuació mostrar-la per pantalla. L'execució ha de ser tal com es veu a continuació:
        */

        Scanner input = new Scanner(System.in);
        Persona persona = new Persona();

        System.out.print("Nom de la persona: ");
        persona.nom = input.nextLine();
        System.out.print("Primer cognom: ");
        persona.primerCognom = input.nextLine();
        System.out.print("Segon cognom: ");
        persona.segonCognom = input.nextLine();
        System.out.print("Edat de la persona: ");
        persona.edat = input.nextInt();
        System.out.print("Altura de la persona en metres: ");
        persona.altura = input.nextDouble();

        System.out.printf("\n\nLa persona %s %s %s té %d anys i fa %f d'altura",persona.nom, persona.primerCognom, persona.segonCognom, persona.edat, persona.altura);

    }
}
