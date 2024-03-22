public class Main {
    public static void main(String[] args) {
        //Creació d'objectes
        Objecte cimitarra = new Objecte("Cimitarra", "Espasa musulmana de fusta i ferro", 3);
        Objecte escut = new Objecte("Escut", "Escut de ferro rovellat", 2);
        Objecte corona = new Objecte("Corona", "Corona d'or feta per esclaus", 1);

        //Creació de personatges
        Personatge rei = new Personatge("Jordi Roca", 100, 10);
        Personatge guerrer = new Personatge("Esclau", 80, 8);

        //Afegir objectes als personatges
        rei.afegirObjecte(cimitarra);
        rei.afegirObjecte(corona);
        guerrer.afegirObjecte(cimitarra);
        guerrer.afegirObjecte(escut);

        //Mostrar estat i composició d'un objecte
        System.out.println(cimitarra);

        //Mostrar estat i composició d'un personatge
        System.out.println(rei);
    }
}
