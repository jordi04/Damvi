//Actualització de Main.java per provar la nova implementació

public class Main {
    public static void main(String[] args) {
        //Creació d'objectes
        Objecte espasa = new Objecte("Espasa", "Espasa molt pesant", 3);
        Objecte espasa1 = new Objecte("Espasa", "Espasa petita", 3);
        Objecte escut = new Objecte("Escut", "Escut rodó daurat", 2);
        Objecte corona = new Objecte("Corona", "Corona feta amb or dels natius", 1);

        //Creació de personatges amb subclasses
        Guerrer guerrer = new Guerrer("Jordi", 100, 10, "Pesada espasa");
        Magic magic = new Magic("Pau", 90, 12, "Llamp");
        Lladre lladre = new Lladre("Marga", 80, 8, true);

        //Afegir objectes als inventaris dels personatges
        guerrer.getInventari().afegirObjecte(espasa);
        guerrer.getInventari().afegirObjecte(espasa1);
        magic.getInventari().afegirObjecte(corona);
        lladre.getInventari().afegirObjecte(escut);

        //Mostrar estat dels personatges, incloent l'adreca dels seus inventaris
        System.out.println(guerrer);
        System.out.println(magic);
        System.out.println(lladre);

        //Mostrar estat dels inventaris
        System.out.println("\nObjectes dels inventaris:");
        System.out.println("\nGuerrer: \n");
        guerrer.getInventari().mostrarObjectes();
        System.out.println("\nMàgic: \n");
        magic.getInventari().mostrarObjectes();
        System.out.println("\nLladre: \n");
        lladre.getInventari().mostrarObjectes();
    }
}
