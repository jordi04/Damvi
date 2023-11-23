/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pràctiques;

/**
 *
 * @author USUARIO
 */
import java.util.Scanner;
public class Pràctiques {
    public static void main(String[] args) {
        //Fes un programa en 
        //Java que vagi llegint valors fins que 
        //s’introdueixi un nombre negatiu. En aquest moment, 
        //el programa acabarà mostrant un missatge de finalització del programa. 
        //Fes-ho amb un bucle while.
        
        Scanner myObj = new Scanner(System.in);
        
        int n = myObj.nextInt();
        while(n >= 0) {
            n = myObj.nextInt();
        }
        System.out.println("Has sortit del programa");
        
    }
    
}   
