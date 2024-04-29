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
    
        boolean run = true;
        while (run) {
            System.out.println("\nSelecciona una opció: \n\n 1.Opcions d'Equips \n 2.Opcions de Jugadors\n 3.Opcions d'Estratègies\n 4.Llegeix tots els fitxers\n 0.Per sortir");
            opcio = inputConsole.nextInt();
            switch (opcio) {
                case 1:
                    ArrayList<Equip> equips = new ArrayList<>();
                    boolean runSubmenu = true;
                    while (runSubmenu) {
                        System.out.println("\n----Opcions d'Equips----\n\n|Selecciona una opció:| \n|---------------------|\n| 1.Afegir equip      |\n| 2.Eliminar equip    |\n| 3.Modificar Equip   |\n| 4.Mostrar Equip     |\n| 0. Sortir           |");
                        int subOpcio = inputConsole.nextInt();
                        switch (subOpcio) {
                            //Afegir equip
                            case 1:
                                //Crear nou equip
                                ArrayList<Jugador> membres = new ArrayList<>();
                                
                                ArrayList<String> habilitat1 = new ArrayList<>();
                                habilitat1.add("Precisió exepcional");
                                habilitat1.add("Domini de diversos herois de DPS");
                                ArrayList<String> habilitat2 = new ArrayList<>();
                                habilitat2.add("Gran capacitat d'absorció de dany");
                                habilitat2.add("Lideratge al camp de batalla");
                                ArrayList<String> habilitat3 = new ArrayList<>();
                                habilitat3.add("Excel·lent habilitat de curació");
                                habilitat3.add("Presa de decisions ràpida en situacions");
                                
                                
                                membres.add(new Jugador("ProGamer1", "John Smith", 22, "DPS", habilitat1, 3200));
                                membres.add(new Jugador("TankMaster", "Emily Jones", 21, "Tanc", habilitat2, 3100));
                                membres.add(new Jugador("HealBot", "Michael Chen", 20, "Suport", habilitat3, 3000));
                            
                                ArrayList<Estrategia> estrategies = new ArrayList<>();
                                
                                estrategies.add(new Estrategia("Suïcidi Prematur", "Es mata a si mateix dins el ventre de la mare"));
                                estrategies.add(new Estrategia("Cum", "CUm"));

                                ArrayList<String> estrategiesStrings = new ArrayList<>();
                                for (int i = 0; i < estrategies.size(); i++) {
                                    estrategiesStrings.add(estrategies.get(i).nomEstrategia);
                                }
                                ArrayList<String> jugadorsStrings = new ArrayList<>();
                                for (int i = 0; i < membres.size(); i++) {
                                    jugadorsStrings.add(membres.get(i).nomJugador);
                                }
                                equips.add(new Equip("Alpha", estrategiesStrings, jugadorsStrings));

                                System.out.println(equips.get(0));


                                //Emmegatzment les dades inserides als fitxers
                                //Escriu al fitxer equips
                                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomFitxers.get(0)))) {
                                    for (Equip equip : equips) {
                                        outputStream.writeObject(equip);
                                    }
                                    System.out.println("Equips serialitzats amb èxit.");
                                } catch (IOException e) {
                                    System.err.println("Error en escriure els equips al fitxer: " + e.getMessage());
                                }

                                //Llegeix el fitxer equips
                                System.out.println("Llegint el fitxer equips.bin");
                                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(0)))) {
                                    System.out.println("Llegint equips del fitxer:");
                                    while (true) {
                                        Equip equip = (Equip) inputStream.readObject();
                                        //System.out.println(equip);
                                    }
                                } catch (EOFException e) {
                                    System.out.println("Fi del fitxer.");
                                } catch (IOException | ClassNotFoundException e) {
                                    System.err.println("Error en llegir els equips del fitxer: " + e.getMessage());
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

                                //Llegeix el fitxer jugadors
                                System.out.println("Llegint el fitxer jugadors.bin");
                                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(1)))) {
                                    System.out.println("Llegint jugadors del fitxer:");
                                    while (true) {
                                        Jugador jugadorAux = (Jugador) inputStream.readObject();
                                        //System.out.println(jugadorAux);
                                    }
                                } catch (EOFException e) {
                                    System.out.println("Fi del fitxer.");
                                } catch (IOException | ClassNotFoundException e) {
                                    System.err.println("Error en llegir els jugadors del fitxer: " + e.getMessage());
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

                                //Llegeix el fitxer estrategies
                                System.out.println("Llegint el fitxer estrategies.bin");
                                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(2)))) {
                                    System.out.println("Llegint estrategies del fitxer:");
                                    while (true) {
                                        Estrategia estrategiaAux = (Estrategia) inputStream.readObject();
                                        System.out.println(estrategiaAux);
                                    }
                                } catch (EOFException e) {
                                    System.out.println("Fi del fitxer.");
                                } catch (IOException | ClassNotFoundException e) {
                                    System.err.println("Error en llegir les estrategies del fitxer: " + e.getMessage());
                                }
                                esperarEnter(inputConsole);
                                break;
                            //Eliminar equip
                            case 2:
                                esperarEnter(inputConsole);                                
                                break;
                            //Modificar equip
                            case 3:
                                esperarEnter(inputConsole);                               
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
                                esperarEnter(inputConsole);
                                break;
                            
                            case 0: 
                                runSubmenu = false;
                                esperarEnter(inputConsole);
                            default:
                                System.out.println("Opció " + subOpcio + " no existeix");
                                esperarEnter(inputConsole);
                                break;
                        }
                    }
                    esperarEnter(inputConsole);
                    break;
                    
                case 2:
                    runSubmenu= true;
                    while (runSubmenu) {
                        System.out.println("\n----Opcions De Jugadors----\n\n|Selecciona una opció:| \n|---------------------|\n| 1.Afegir Jugador    |\n| 2.Eliminar Jugador  |\n| 3.Modificar Jugador |\n| 4.Mostrar Jugador   |\n| 0. Sortir           |");
                            int subOpcio = inputConsole.nextInt();
                            switch (subOpcio) {
                                case 1:
                                    // afegir jugador
                                    esperarEnter(inputConsole);
                                    break;
                                    
                                case 2:
                                    //eliminar jugador
                                    esperarEnter(inputConsole);
                                    break;
                                case 3:
                                    //Modificar jugador
                                    esperarEnter(inputConsole);
                                    break;
                                case 4:
                                    //Mostrar Jugador
                                    //System.out.println(jugador.toString());
                                    esperarEnter(inputConsole);
                                    break;
                                case 0:
                                    runSubmenu = false;
                                    esperarEnter(inputConsole);
                                    break;
                                
                                default:
                                    System.out.println("Opció " + subOpcio + "no existeix");
                                    esperarEnter(inputConsole);
                                    break;
                            }
                            
                    }
                        esperarEnter(inputConsole);
                    break;
                case 3:
                    runSubmenu= true;
                    while (runSubmenu) {
                        System.out.println("\n----Opcions De Estrategia----\n\n|Selecciona una opció:| \n|---------------------|\n| 1.Afegir Estrategia      |\n| 2.Eliminar Estrategia    |\n| 3.Modificar Estrategia   |\n| 4.Mostrar Estrategia     |\n| 0. Sortir           |");
                        int subOpcio = inputConsole.nextInt();
                        switch (subOpcio) {
                            case 1:
                                // afegir estrategia
                                esperarEnter(inputConsole);
                                break;
                            case 2:
                                //eliminar Estrategia
                                esperarEnter(inputConsole);
                                break;
                            case 3:
                                //Modificar Estrategia
                                esperarEnter(inputConsole);
                                break;
                            case 4:
                                //Mostrar Estrategia
                                esperarEnter(inputConsole);
                                break;
                            case 0:
                                runSubmenu = false;
                                esperarEnter(inputConsole);
                            default:
                                System.out.println("Opció " + subOpcio + "no existeix");
                                esperarEnter(inputConsole);
                                break;
                        }
                    }
                    esperarEnter(inputConsole);
                    break;
                case 4:
                    //Llegeix el fitxer equips
                    System.out.println("Llegint el fitxer "+ nomFitxers.get(0));
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomFitxers.get(0)))) {
                        System.out.println("Llegint equips del fitxer:");
                    
                        while (true) {
                            Equip equip = (Equip) inputStream.readObject();
                            System.out.println(equip);
                            ArrayList<String> membresAux = equip.nomMembres;
                            ArrayList<String> estrategiesAux = equip.nomEstrategies;
                            System.err.println("\n\n\n\n\n\n\nPUTA\n\n\n\n\n\n\n");

                            
                            System.out.println("Llegint el fitxer jugadors.bin");
                            try (ObjectInputStream inputStreamJug = new ObjectInputStream(new FileInputStream(nomFitxers.get(1)))) {
                                System.out.println("Llegint jugadors del fitxer:");
                                System.err.println("\n\n\n\n\n\n\nPUTA2\n\n\n\n\n\n\n");

                                while (true) {
                                    Jugador jugadorAux = (Jugador) inputStreamJug.readObject();
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
                            try (ObjectInputStream inputStreamEst = new ObjectInputStream(new FileInputStream(nomFitxers.get(2)))) {
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
                    
                    esperarEnter(inputConsole);
                    break;
                case 0: 
                    run = false;
                    esperarEnter(inputConsole);
                    break;
                default:
                    System.out.println("Opció no existeix");
                    esperarEnter(inputConsole);
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

    public void llegirDadesFitxers() {
        
    }
    
    public void MenuFicheros(String[] nomFixers[],ArrayList<Equip> equips,ArrayList<Jugador> membres,ArrayList<Estrategia> estrategies){
        Scanner sc = new Scanner(System.in);
        Boolean runner = true; 
        while (runner){ 
        System.out.println("\n----Opcions De Fixers----\n\n|Selecciona una opció:| \n|---------------------|\n| 1.Desar les modificacions    |\n| 2.Separar   |\n|  3.Fusionar   |\n| 0. Sortir           |");
        int option = sc.nextInt();
        switch (option){
            case 1: 
                try {
                    System.out.println("Esteu segur de desar les modificacions? \n1.Sí \n 2.No \nEcull una opció: ");
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
                esperarEnter(new Scanner(System.in));
                break;          
            default: System.out.println("Opcio no vàlida"); 
        }
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
        
        esperarEnter(inputConsole);
    }
    
    public static String crearFitxer() {
        Scanner inputConsole = new Scanner(System.in);
        System.out.print("Insereix el nom de fitxer (sense l'extensió .bin): ");
        String filename = inputConsole.nextLine() + ".bin";
        return filename;
    }

    public static void esperarEnter(Scanner inputConsole) {
        System.out.println("Prem Enter per continuar...");
        inputConsole.nextLine();
        //scanner.close();
    }

    
}



