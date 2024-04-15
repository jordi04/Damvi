//import java.util.Scanner;
//import java.util.ArrayList;
import java.util.*;

import java.io.*;
/*
 ESTRATEGIES SON HABILITATS !!!!!
 */
public class Main {
    public static void main(String[] args) {
        

        int opcio = 0;
        Scanner inputConsole = new Scanner(System.in);
        
        //No sé si és necessari
        ArrayList<Equip> equips = new ArrayList<>();
        
        boolean run = true;
        while (run) {
            System.out.println("\nSelecciona una opció: \n\n 1.Opcions d'Equips \n 2.Opcions de Jugadors\n 3.Opcions d'Estratègies\n 4.Llegeix tots els fitxers\n 0.Per sortir");
            opcio = inputConsole.nextInt();
            switch (opcio) {
                case 1:
                    boolean runSubmenu = true;
                    while (runSubmenu) {
                        System.out.println("\n----Opcions d'Equips----\n\n|Selecciona una opció:| \n|---------------------|\n| 1.Afegir equip      |\n| 2.Eliminar equip    |\n| 3.Modificar Equip   |\n| 4.Mostrar Equip     |\n| 0. Sortir           |");
                        int subOpcio = inputConsole.nextInt();
                        switch (subOpcio) {
                            //Afegir equip
                            case 1:
                                
                                break;
                            //Eliminar equip
                            case 2:
                                break;
                            //Modificar equip
                            case 3:
                                break;
                                
                            //Mostrar equip
                            case 4:
                                System.out.println("Llegint el fitxer equips.bin");
                                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("equips.bin"))) {
                                    System.out.println("Llegint equips del fitxer:");
                                    while (true) {
                                        System.out.println("Selecciona un equip a mostrar");
                                        Equip equip = (Equip) inputStream.readObject();
                                        System.out.println(equip.nomEquip);
                                    }
                                } catch (EOFException e) {
                                    System.out.println("Fi del fitxer.");
                                } catch (IOException | ClassNotFoundException e) {
                                    System.err.println("Error en llegir els equips del fitxer: " + e.getMessage());
                                }
                                break;
                            case 0: 
                                runSubmenu = false;
                            default:
                                System.out.println("Opció " + subOpcio + "no existeix");
                                break;
                        }
                    }
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
    
                    equips.add(new Equip("Alpha", estrategies, membres));
    
                    System.out.println(equips.get(0));


                    //Emmegatzment les dades inserides als fitxers
                    //Escriu al fitxer equips
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("equips.bin"))) {
                        for (Equip equip : equips) {
                            outputStream.writeObject(equip);
                        }
                        System.out.println("Equips serialitzats amb èxit.");
                    } catch (IOException e) {
                        System.err.println("Error en escriure els equips al fitxer: " + e.getMessage());
                    }

                    //Llegeix el fitxer equips
                    System.out.println("Llegint el fitxer equips.bin");
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("equips.bin"))) {
                        System.out.println("Llegint equips del fitxer:");
                        while (true) {
                            Equip equip = (Equip) inputStream.readObject();
                            System.out.println(equip);
                        }
                    } catch (EOFException e) {
                        System.out.println("Fi del fitxer.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Error en llegir els equips del fitxer: " + e.getMessage());
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

                    //Llegeix el fitxer jugadors
                    System.out.println("Llegint el fitxer jugadors.bin");
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("jugadors.bin"))) {
                        System.out.println("Llegint jugadors del fitxer:");
                        while (true) {
                            Jugador jugadorAux = (Jugador) inputStream.readObject();
                            System.out.println(jugadorAux);
                        }
                    } catch (EOFException e) {
                        System.out.println("Fi del fitxer.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Error en llegir els jugadors del fitxer: " + e.getMessage());
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

                    //Llegeix el fitxer estrategies
                    System.out.println("Llegint el fitxer estrategies.bin");
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("estrategies.bin"))) {
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
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    //Llegeix el fitxer equips
                    System.out.println("Llegint el fitxer equips.bin");
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("equips.bin"))) {
                        System.out.println("Llegint equips del fitxer:");
                        while (true) {
                            Equip equip = (Equip) inputStream.readObject();
                            System.out.println(equip);
                        }
                    } catch (EOFException e) {
                        System.out.println("Fi del fitxer.");
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
                 1 afegir un equip
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
}
