import java.util.ArrayList;

public class Inventari {
    private ArrayList<Objecte> objectes;

    //Constructor
    public Inventari() {
        this.objectes = new ArrayList<>();
    }

    //Mètode per afegir un objecte a l'inventari
    public void afegirObjecte(Objecte objecte) {
        objectes.add(objecte);
    }

    //Mètode per eliminar un objecte de l'inventari
    public void eliminarObjecte(Objecte objecte) {
        objectes.remove(objecte);
    }

    //Mètode per mostrar els objectes de l'inventari
    public void mostrarObjectes() {
        //System.out.println("Objectes de l'inventari:");
        for (Objecte obj : objectes) {
            System.out.println(obj);
        }
    }
}
