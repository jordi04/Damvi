
public class Main {
    public static void main(String[] args) {
        //Creació d'objectes
        Objecte espasa = new Objecte("Espasa", "Espasa medieval de fusta i ferro", 3);
        Objecte escut = new Objecte("Escut", "Escut de ferro amb creu vermella", 2);
        Objecte corona = new Objecte("Corona", "Corona d'or decorada amb pedres precioses", 1);

        //Creació de personatges amb subclasses
        Guerrer guerrer = new Guerrer("Conan", 100, 10, "Gran Espasa");
        Magic magic = new Magic("Gandalf", 90, 12, "Bola de Foc");
        Lladre lladre = new Lladre("Robin Hood", 80, 8, true);

        //Afegir objectes als personatges
        guerrer.afegirObjecte(espasa);
        magic.afegirObjecte(corona);
        lladre.afegirObjecte(escut);

        //Mostrar estat i composició d'un personatge
        System.out.println(guerrer);
        System.out.println(magic);
        System.out.println(lladre);
    }
}
