//import java.util.Scanner;
//import java.util.ArrayList;
import java.util.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Read jugador1 from the binary file
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("jugador.bin"))) {
            Jugador jugador1Read = (Jugador) inputStream.readObject();
            System.out.println("Jugador1 read from jugador.bin: " + jugador1Read);
            System.out.println("Nickname: " + jugador1Read.nickname);
            System.out.println("Nombre del Jugador: " + jugador1Read.nomJugador);
            System.out.println("Edat: " + jugador1Read.edat);
            System.out.println("Rol: " + jugador1Read.rol);
            System.out.println("Habilitats: " + jugador1Read.habilitats);
            System.out.println("Punts ELO: " + jugador1Read.puntsElo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading jugador1 from jugador.bin: " + e.getMessage());
        }
        
    }
}
