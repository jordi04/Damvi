import java.util.Scanner;

public class JordiRocaJocRestarV1 {
    /*
        Escriure un programa en Java que ajudi a aprendre a restar dos valors enters.
        Feu servir l'estratègia 
        Identificar les sentències (o grups de sentències) que s'han de repetir
        Incloure aquestes sentències en un bucle
        Afegir les instruccions de control del bucle.
        El programa haurà de generar dos valors aleatoris en l'interval [1 - 10] i preguntar a l'usuari quin és el resultat de restar els dos valors

        Atenció:

        Haurem de fer que el resultat de la resta proposada sigui sempre major que zero; per tant, haurem de presentar sempre (valor major - valor menor), 
        i hem d'estar segurs que els dos valors són diferents entre si. Això vol dir que possiblement la generació dels valors aleatoris haurà d'estar també en un bucle. 
        (Es recomana fer primer un programa que generi valors aleatoris que compleixin aquesta condició).

        Es donarà un màxim de 5 intents a l'usuari per resoldre la resta.

        Es calcularà el temps que triga l'usuari en resoldre la resta. Per fer-ho, podem fer servir el mètode 

        System.currentTimeMillis();

        que permet emmagatzemar en una variable (preferiblement de tipus "long") l'hora actual en un format de milisegons. Quan l'usuari hagi resolt la resta 
        (o hagi consumit els 5 intents) se li mostrarà el nombre de segons que ha trigat i el nombre d'intents que li ha calgut.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int valor1, valor2, resultat, intents = 0;
        long tempsInici, tempsFinal;

        System.out.println("Benvingut a aprendre a restar!");

        do {
            // Generar dos valors aleatoris diferents entre 1 i 10
            valor1 = (int) (Math.random()*10+1);
            valor2 = (int) (Math.random()*10+1);
            while (valor1 == valor2) {
                valor2 = (int) (Math.random()*10+1);
            }

            // Assegurar-se que valor1 sempre sigui major que valor2
            if (valor1 < valor2) {
                int temp = valor1;
                valor1 = valor2;
                valor2 = temp;
            }

            resultat = valor1 - valor2;

            // Mostrar l'operació a l'usuari
            System.out.println("Va, quin és el resultat: " + valor1 + " - " + valor2);

            // Medir el temps a l'inici de l'intent
            tempsInici = System.currentTimeMillis();

            // Demanar la resposta de l'usuari
            System.out.print("Introdueix el resultat: ");
            int resposta = scanner.nextInt();
            intents++;

            // Medir el temps al final de l'intent
            tempsFinal = System.currentTimeMillis();

            if (resposta == resultat) {
                System.out.println("Molt bé! Has trigat " + (tempsFinal - tempsInici) / 1000 + " segons. Nombre d'intents: " + intents);
                break;
            } else {
                System.out.println("Ooh. Torna-ho a intentar. El resulat era: " + resultat);
            }
        } while (intents < 5);

        if (intents >= 5) {
            System.out.println("Has esgotat els 5 intents. El resultat era: " + resultat);
        }

    }
}

