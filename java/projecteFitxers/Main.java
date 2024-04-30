//import java.util.Scanner;
//import java.util.ArrayList;
import java.util.*;

import java.io.*;
/*
 ESTRATEGIES SON HABILITATS !!!!!
*/
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {


        //Al principi de l'execució llegim el fitxer que conté tots els fitxers necessaris per a l'execució

        ArrayList<String> nomFitxers = new ArrayList<>();
        String filePath = "nomFitxers.txt";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            int xd = 0;
            while (scanner.hasNextLine()) {
                nomFitxers.add(scanner.nextLine());
                System.out.println("cum 1 xd: "+ xd);
                xd++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            //Això insereix els noms dels fitxers a l'array list nomFitxers
        
        int opcio = 0;
        final Scanner inputConsole = new Scanner(System.in);
        
        Scanner sc_1 = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\nSelecciona una opció: \n\n 1.Opcions d'Equips \n 2.Opcions de Jugadors\n 3.Opcions d'Estratègies\n 4.Llegeix tots els fitxers\n 0.Per sortir");
            opcio = inputConsole.nextInt();
            switch (opcio) {
                case 1:
                    ArrayList<Equip> equips = new ArrayList<>();
                    boolean runSubmenu = true;
                    while (runSubmenu) {
                        System.out.println("\n----Opcions d'Equips----\n\n|Selecciona una opció: | \n|----------------------|\n| 1.Afegir equip       |\n| 2.Eliminar equip     |\n| 3.Modificar Nom Equip|\n| 4.Mostrar Equip      |\n| 0. Sortir            |");
                        int subOpcio = inputConsole.nextInt();
                        switch (subOpcio) {
                            //Afegir equip
                            case 1:
                                afegirEquip(nomFitxers, inputConsole);
                                break;
                            //Eliminar equip
                            case 2:
                                eliminarEquip(nomFitxers);
                                                                
                                break;
                            //Modificar equip
                            case 3:
                                
                                                              
                                break;
                            //Mostrar equip
                            case 4:
                                System.out.println("Llegint el fitxer equips.bin");
                                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(0)))) {
                                    System.out.println("Llegint equips del fitxer:");
                                    int auxIndex = 1; //restar 1 per aconseguir el num d'index de l'array list
                                    //Auxx!!!
                                    int continuarLlegint = 0;
                                    ArrayList<Equip> equipsAux = new ArrayList<>();
                                    while (continuarLlegint != -1) {
                                        System.out.println("Selecciona un equip a mostrar: ");
                                        Equip equip = (Equip) inputStream.readObject();
                                        equipsAux.add(equip);
                                        System.out.println(auxIndex + ". " + equipsAux.get(auxIndex-1).nomEquip);
                                        auxIndex++; 
                                        continuarLlegint = inputStream.read();
                                        
                                    }
                                         
                                    boolean seleccionant = true;
                                    int equipSeleccionat = 0;
                                    while (seleccionant) {
                                        try {
                                            System.out.print("Introdueix el número d'equip: ");
                                            equipSeleccionat = inputConsole.nextInt();
                                            seleccionant = false;
                                            
                                        }
                                        catch (Exception e){
                                            System.out.println("El numero que has inserit no correspon a un equip");
                                        }
                                        
                                    }
                                    
                                    
                                } catch (EOFException e) {
                                    System.out.println("Fi del fitxer.");
                                } catch (IOException | ClassNotFoundException e) {
                                    System.err.println("Error en llegir els equips del fitxer: " + e.getMessage());
                                }
                                
                                break;
                            
                            case 0: 
                                runSubmenu = false;
                                
                                break;
                            default:
                                System.out.println("Opció " + subOpcio + " no existeix");
                                
                                break;
                        }
                        esperarEnter(run, sc_1);
                    }
                                        
                    break;
                case 2:
                    runSubmenu= true;
                    while (runSubmenu) {
                        System.out.println("\n----Opcions De Jugadors----\n\n|Selecciona una opció:| \n|---------------------|\n| 1.Afegir Jugador    |\n| 2.Eliminar Jugador  |\n| 3.Modificar Jugador |\n| 4.Mostrar Jugador   |\n| 0. Sortir           |");
                            int subOpcio = inputConsole.nextInt();
                            switch (subOpcio) {
                                case 1:
                                    // afegir jugador
            
                                    break;
                                    
                                case 2:
                                    //eliminar jugador
            
                                    break;
                                case 3:
                                    //Modificar jugador
            
                                    break;
                                case 4:
                                    //Mostrar Jugador
                                    //System.out.println(jugador.toString());
            
                                    break;
                                case 0:
                                    runSubmenu = false;
            
                                    break;
                                
                                default:
                                    System.out.println("Opció " + subOpcio + "no existeix");
            
                                    break;
                            }
                            esperarEnter(run, sc_1);
                    }
                        
                    break;
                case 3:
                    runSubmenu= true;
                    while (runSubmenu) {
                        System.out.println("\n----Opcions De Estrategia----\n\n|Selecciona una opció:  | \n|-----------------------|\n| 1.Afegir Estrategia   |\n| 2.Eliminar Estrategia |\n| 3.Modificar Estrategia|\n| 4.Mostrar Estrategia  |\n| 0. Sortir             |");
                        int subOpcio = inputConsole.nextInt();
                        switch (subOpcio) {
                            case 1:
                                // afegir estrategia
        
                                break;
                            case 2:
                                //eliminar Estrategia
        
                                break;
                            case 3:
                                //Modificar Estrategia
        
                                break;
                            case 4:
                                //Mostrar Estrategia
        
                                break;
                            case 0:
                                runSubmenu = false;
                                break;
        
                            default:
                                System.out.println("Opció " + subOpcio + "no existeix");
        
                                break;
                        }
                        esperarEnter(run, sc_1);
                    }
                    break;
                case 4:
                    //Llegeix el fitxer equips
                    System.out.println("Llegint el fitxer "+ nomFitxers.get(0));
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(0)))) {
                        System.out.println("Llegint equips del fitxer:");
                    
                        while (true) {
                            Equip equip = (Equip) inputStream.readObject();
                            System.out.println("Equip " + equip.nomEquip);
                            ArrayList<String> membresAux = equip.nomMembres;
                            ArrayList<String> estrategiesAux = equip.nomEstrategies;
                            //System.out.println("Llegint el fitxer jugadors.bin");
                            try (ObjectInputStream inputStreamJug = new ObjectInputStream(new FileInputStream(nomFitxers.get(1)))) {
                                //System.out.println("Llegint jugadors del fitxer:");
                                while (true) {
                                    Jugador jugadorAux = (Jugador) inputStreamJug.readObject();
                                    if (membresAux.contains(jugadorAux.nomJugador)) {
                                        System.out.println(jugadorAux); 
                                    }
                                }
                            } catch (EOFException e) {
                               // System.out.println("Fi del fitxer.");
                            } catch (IOException | ClassNotFoundException e) {
                                System.err.println("Error en llegir els jugadors del fitxer: " + e.getMessage());
                            }

                            //System.out.println("Llegint el fitxer estrategies.bin");
                            try (ObjectInputStream inputStreamEst = new ObjectInputStream(new FileInputStream(nomFitxers.get(2)))) {
                                //System.out.println("Llegint estrategies del fitxer:");
                                while (true) {
                                    Estrategia estrategiaAux = (Estrategia) inputStreamEst.readObject();
                                    if (estrategiesAux.contains(estrategiaAux.nomEstrategia)) {
                                        System.out.println(estrategiaAux);
                                    }
                                }
                            } catch (EOFException e) {
                                //System.out.println("Fi del fitxer.");
                            } catch (IOException | ClassNotFoundException e) {
                                System.err.println("Error en llegir les estrategies del fitxer: " + e.getMessage());
                            }
                        }
                        
                    } catch (EOFException e) {
                        //System.out.println("Fi del fitxer.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Error en llegir els equips del fitxer: " + e.getMessage());
                    }
                    
                    break;
                case 0: 
                    run = false;
                    break;
                default:
                    System.out.println("Opció no existeix");
                    break;
                    

                /*
                 1 afegir un equip ECHO
                 2 afegir un jugador a un equip
                 3 afegir una estrategia a un equip
                 1.1 elimnar un equip
                 2.1 eliminar un jugador d'un equip
                 3.1 eliminar una estrategia d'un equip
                 1.2 mostrar un equip
                 2.2 mostrar jugador equip
                 3.2 mostrar estrategia equip
                 1.3 modificar equip
                 2.3 modificar jugador
                 3.3 modificar estrategia

                 */
            }
            
                
        }        
        
    }





    public static void afegirEquip(ArrayList<String> nomFitxers, Scanner inputConsole) {
        //Crear nou equip
        
        ArrayList<Equip> equips = new ArrayList<>();
        boolean inserint = true;
        String nomEquip = "";
        while (inserint) {
            System.out.println("Insereix el nom de l'equip: ");
            nomEquip = inputConsole.nextLine();
            if (nomEquip == "") {
                System.out.println("El nom no és de la llargada mínima");
            }
            else {
                inserint = false;
            }
        }
        
        ArrayList<Jugador> membres = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            membres.add(new Jugador());
            System.out.println("Insereix el nom del jugador " + i + ": ");
            membres.get(i).setNomJugador(inputConsole.nextLine());

            System.out.println("Insereix el nickname del jugador " + i + ": ");
            membres.get(i).setNickname(inputConsole.nextLine());
            
            

            System.out.println("Insereix l'edat del jugador " + i + ": ");
            membres.get(i).setEdat(inputConsole.nextInt());
            inputConsole.nextLine();
            System.out.println("Insereix el rol del jugador " + i + ": ");
            membres.get(i).setRol(inputConsole.nextLine());

            System.out.println("Insereix el nombre d'habilitats del jugador " + i + ": ");
            int numHabilitats = inputConsole.nextInt();
            inputConsole.nextLine();
            ArrayList <String> habilitats = new ArrayList<String>();
            for (int j = 0; j < numHabilitats; j++) {
                System.out.println("Insereix l'habilitat "+ j + " del jugador " + i + ": ");
                habilitats.add(inputConsole.nextLine());
            }
            membres.get(i).setHabilitats(habilitats);

            System.out.println("Insereix els punts del jugador " + i + ": ");
            membres.get(i).setPuntsElo(inputConsole.nextInt());
            inputConsole.nextLine();
            
        }

        System.out.println("Insereix el nombre d'estratègies de l'equip: ");
        int numEstrategies = inputConsole.nextInt();
        inputConsole.nextLine();
        ArrayList<Estrategia> estrategies = new ArrayList<>();
        for (int j = 0; j < numEstrategies; j++) {
            Estrategia estrategia = new Estrategia();
            System.out.println("Insereix el nom de l'estrategia " + j + ": ");
            estrategia.setNomEstrategia(inputConsole.nextLine());
            System.out.println("Insereix la descripció de l'estrategia " + j + ": ");
            estrategia.setDescr(inputConsole.nextLine());
            estrategies.add(estrategia);
        }

        ArrayList<String> estrategiesStrings = new ArrayList<>(); 
        for (int i = 0; i < numEstrategies; i ++) {
            estrategiesStrings.add(estrategies.get(i).nomEstrategia);
        }
        ArrayList<String> jugadorsStrings = new ArrayList<>();
        for (int i = 0; i < 3; i ++) {
            jugadorsStrings.add(membres.get(i).nomJugador);
        }
        equips.add(new Equip(nomEquip, estrategiesStrings, jugadorsStrings));


        //Llegim els fitxers existents per afegir guardar les dades
        ArrayList<Equip> equipsAux = new ArrayList<>(); 
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(0)))) {
            System.out.println("Llegint equips del fitxer: " + nomFitxers.get(0));
            int numEquip = 1;
            while (true) {
                Equip equipAux = (Equip) inputStream.readObject();
                System.out.println(numEquip + ". " + equipAux.nomEquip);
                equipsAux.add(equipAux);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en llegir els equips del fitxer: " + e.getMessage());
        }
        //Ajuntam les dades dels equips
        for (int i = 0; i < equipsAux.size(); i++) {
            equips.add(equipsAux.get(i));
        }
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS
        //FALTA LLEGIR ELS FITXERS DE JUGADORS I ESTRATEGIES PER MODIFICAR-LOS

        ArrayList<Jugador> jugadors = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(1)))) {
            while (true) {
                Jugador jugador = (Jugador) inputStream.readObject();
                else {
                    jugadors.add(jugador);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en llegir els jugadors del fitxer: " + e.getMessage());
        }



        //Escrivim als arxius
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomFitxers.get(0)))) {
            for (Equip equip : equips) {
                outputStream.writeObject(equip);
            }
            System.out.println("Equips serialitzats amb èxit.");
        } catch (IOException e) {
            System.err.println("Error en escriure els equips al fitxer: " + e.getMessage());
        }

        //Escriu al fitxer jugadors
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomFitxers.get(1)))) {
            for (Jugador jugador : membres) {
                outputStream.writeObject(jugador);
            }
            System.out.println("Jugadors serialitzats amb èxit.");
        } catch (IOException e) {
            System.err.println("Error en escriure els jugadors al fitxer: " + e.getMessage());
        }

        //Escriu al fitxer estrategies
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomFitxers.get(2)))) {
            for (Estrategia estrategia : estrategies) {
                outputStream.writeObject(estrategia);
            }
            System.out.println("Estrategies serialitzats amb èxit.");
        } catch (IOException e) {
            System.err.println("Error en escriure els estrategies al fitxer: " + e.getMessage());
        }
        
    }


    public static void eliminarEquip(ArrayList<String> nomFitxers) {
        ArrayList<Equip> equips = new ArrayList<>(); 
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(0)))) {
            System.out.println("Llegint equips del fitxer: " + nomFitxers.get(0));
            int numEquip = 1;
            while (true) {
                Equip equip = (Equip) inputStream.readObject();
                System.out.println(numEquip + ". " + equip.nomEquip);
                equips.add(equip);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en llegir els equips del fitxer: " + e.getMessage());
        }
        
        //Agafam input user

        Scanner inputConsole = new Scanner(System.in);
        int equipEliminar = 0;

        boolean escollint = true;
        while (escollint) {
            System.out.println("Quin equip vols eliminar?");
            equipEliminar = inputConsole.nextInt();
            if (equipEliminar <= 0 || equipEliminar > equips.size()) {
                System.out.println("L'equip seleccionat no existeix, insereix el nombre d'un equip");
            }
            else {
                escollint = false;
            }
        }
        //Eliminam l'equip seleccionat de l'array list d'equips
        Equip equipEliminat = equips.get(equipEliminar-1);
        equips.remove(equipEliminar-1);
        
        deleteFileContent(nomFitxers.get(0));
        //Escrivim els equips com toca
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomFitxers.get(0)))) {
            for (Equip equip : equips) {
                outputStream.writeObject(equip);
            }
            System.out.println("Equip eliminat amb èxit.");
        } catch (IOException e) {
            System.err.println("Error en escriure els equips al fitxer: " + e.getMessage());
        }

        //Eliminam els jugadors de l'equip  
        ArrayList<String> membresEliminar = new ArrayList<>();
        membresEliminar = equipEliminat.nomMembres;
        ArrayList<Jugador> jugadors = new ArrayList<>();

        //Llegim el fitxer jugadors
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(1)))) {
            while (true) {
                Jugador jugador = (Jugador) inputStream.readObject();
                if (membresEliminar.contains(jugador.nomJugador)) {

                    System.out.println("Eliminat un jugador més");
                }
                else {
                    jugadors.add(jugador);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en llegir els jugadors del fitxer: " + e.getMessage());
        }
        deleteFileContent(nomFitxers.get(1));
        //Escrivim tots els jugadors sense els eliminats
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomFitxers.get(1)))) {
            for (Jugador jugador : jugadors) {
                outputStream.writeObject(jugador);
            }
            System.out.println("Jugadors eliminat amb èxit.");
        } catch (IOException e) {
            System.err.println("Error en escriure els jugadors al fitxer: " + e.getMessage());
        }
        
        //Eliminam les estratègies de l'equip  
        ArrayList<String> estrategiesEliminar = new ArrayList<>();
        estrategiesEliminar = equipEliminat.nomEstrategies;
        ArrayList<Estrategia> estrategies = new ArrayList<>();

        //Llegim el fitxer estrategies
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(1)))) {
            while (true) {
                Estrategia estrategia = (Estrategia) inputStream.readObject();
                if (membresEliminar.contains(estrategia.nomEstrategia)) {

                    System.out.println("Eliminat una estrategia més");
                }
                else {
                    estrategies.add(estrategia);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en llegir els estrategeis del fitxer: " + e.getMessage());
        }

        deleteFileContent(nomFitxers.get(2));
        //Escrivim tots els estrategies sense els eliminats
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomFitxers.get(2)))) {
            for (Estrategia estrategia : estrategies) {
                outputStream.writeObject(estrategia);
            }
            System.out.println("Estrategies eliminates amb èxit.");
        } catch (IOException e) {
            System.err.println("Error en escriure les estrategies al fitxer: " + e.getMessage());
        }

    }





    public static void deleteFileContent(String path) {
        File myObj = new File(path); 
        myObj.delete();
        try {
            myObj.createNewFile();
          } catch (IOException e) {
            e.printStackTrace();
          }

        
    }




    public static void ModificarNomEquip(ArrayList<String> nomFitxers){
        ArrayList<Equip> equips = new ArrayList<>(); 
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(0)))) {
            System.out.println("Llegint equips del fitxer: " + nomFitxers.get(0));
            int numEquip = 1;
            while (true) {
                Equip equip = (Equip) inputStream.readObject();
                System.out.println(numEquip + ". " + equip.nomEquip);
                equips.add(equip);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en llegir els equips del fitxer: " + e.getMessage());
        }
        
        //Agafam input user

        Scanner inputConsole = new Scanner(System.in);
        int equipModificar = 0;

        boolean escollint = true;
        while (escollint) {
            System.out.println("Quin equip vols modificar?");
            equipModificar = inputConsole.nextInt();
            if (equipModificar <= 0 || equipModificar > equips.size()) {
                System.out.println("L'equip seleccionat no existeix, insereix el nombre d'un equip");
            }
            else {
                escollint = false;
            }
        }
        escollint = true;
        String nomEquip;

        while (escollint) {
            nomEquip = inputConsole.nextLine();
            if (nomEquip != null) {
                equips.get(equipModificar-1).nomEquip = nomEquip;
            }
        }
        

        //Escrivim els equips com toca
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomFitxers.get(0)))) {
            for (Equip equip : equips) {
                outputStream.writeObject(equip);
            }
            System.out.println("Equip eliminat amb èxit.");
        } catch (IOException e) {
            System.err.println("Error en escriure els equips al fitxer: " + e.getMessage());
        }
    }
    
    public void MenuFicheros(ArrayList<Equip> equips,ArrayList<Jugador> membres,ArrayList<Estrategia> estrategies){
        Scanner sc = new Scanner(System.in);
        Boolean runner = true; 
        
        while (runner){ 
        System.out.println("\n----Opcions De Fixers----\n\n|Selecciona una opció:| \n|---------------------|\n| 1.Desar les modificacions    |\n| 2.Separar   |\n|  3.Fusionar   |\n| 0. Sortir           |");
        int option = sc.nextInt();
        switch (option){
            case 1: 
                try {
                    System.out.println("Esteu segur de desar les modificacions? \n1.Sí \n 2.No \nEscull una opció: ");
                    int optionSave = sc.nextInt();
                    switch (optionSave){
                        case 1: 
                                //Escriu al fitxer equips 
                                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("equips.bin"))) {
                                    for (Equip equip : equips) {
                                        outputStream.writeObject(equip);
                                    }
                                    System.out.println("Equips serialitzats amb èxit.");
                                } catch (IOException e) {
                                    System.err.println("Error en escriure els equips al fitxer: " + e.getMessage());
                                }

                                 //Escriu al fitxer jugadors
                                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("jugadors.bin"))) {
                                    for (Jugador jugador : membres) {
                                        outputStream.writeObject(jugador);
                                    }
                                    System.out.println("Jugadors serialitzats amb èxit.");
                                } catch (IOException e) {
                                    System.err.println("Error en escriure els jugadors al fitxer: " + e.getMessage());
                                }
                                //Escriu al fitxer estrategies
                                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("estrategies.bin"))) {
                                    for (Estrategia estrategia : estrategies) {
                                        outputStream.writeObject(estrategia);
                                    }
                                    System.out.println("Estrategies serialitzats amb èxit.");
                                } catch (IOException e) {
                                    System.err.println("Error en escriure els estrategies al fitxer: " + e.getMessage());
                                }
                                break;
                        case 2: System.out.println("Infomarció no desada");break;

                        default: System.out.println("Opció no vàlida");
                    }
                }
                catch (Exception e){
                    System.out.println("Error al desar l'informacio");
                }
            case 2:
                try {
                    String path = crearFitxer();
                        
                } catch (Exception e) {
                    System.out.println("Error a separar l'informacio");
                }
            case 3:
                try {
                    
                } catch (Exception e) {
                    System.out.println("Error a fusionar l'informacio");
                }
            case 0:
                runner = false;
                break;    
                      
            default: 
                System.out.println("Opcio no vàlida");
                break;
        }
            
            esperarEnter(runner, sc);
            }
        }
    

    public static void modificarEquip() {
        Scanner inputConsole = new Scanner(System.in);
        System.out.println("Llegint el fitxer equips.bin");
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("equips.bin"))) {
            System.out.println("Llegint equips del fitxer:");
            while (true) {
                Equip equip = (Equip) inputStream.readObject();
                System.out.println(equip);
                ArrayList<String> membresAux = equip.nomMembres;
                ArrayList<String> estrategiesAux = equip.nomEstrategies;
                
                System.out.println("Llegint el fitxer jugadors.bin");
                try (ObjectInputStream inputStreamJug = new ObjectInputStream(new FileInputStream("jugadors.bin"))) {
                    System.out.println("Llegint jugadors del fitxer:");
                    while (true) {
                        Jugador jugadorAux = (Jugador) inputStreamJug.readObject();
                        System.out.println(jugadorAux); 
                        
                        if (membresAux.contains(jugadorAux.nomJugador)) {
                            System.out.println(jugadorAux); 
                        }
                    }
                } catch (EOFException e) {
                    System.out.println("Fi del fitxer.");
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error en llegir els jugadors del fitxer: " + e.getMessage());
                }

                System.out.println("Llegint el fitxer estrategies.bin");
                try (ObjectInputStream inputStreamEst = new ObjectInputStream(new FileInputStream("estrategies.bin"))) {
                    System.out.println("Llegint estrategies del fitxer:");
                    while (true) {
                        Estrategia estrategiaAux = (Estrategia) inputStreamEst.readObject();
                        if (estrategiesAux.contains(estrategiaAux.nomEstrategia)) {
                            System.out.println(estrategiaAux);
                        }
                    }
                } catch (EOFException e) {
                    System.out.println("Fi del fitxer.");
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error en llegir les estrategies del fitxer: " + e.getMessage());
                }
            }
            
        } catch (EOFException e) {
            System.out.println("Fi del fitxer.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en llegir els equips del fitxer: " + e.getMessage());
        }
    }
    
    public static String crearFitxer() {
        Scanner inputConsole = new Scanner(System.in);
        System.out.print("Insereix el nom de fitxer (sense l'extensió .bin): ");
        String filename = inputConsole.nextLine() + ".bin";
        return filename;
    }

    public static void esperarEnter(boolean run, Scanner inputConsole) {
            
        if (run) {
                        System.out.printf("\nPress 2 Enter to continue ");
                        if (inputConsole.hasNextLine()) {
                            inputConsole.nextLine(); // Consume the input
                        }
                        inputConsole.nextLine();}
        
        
    }

    
}



