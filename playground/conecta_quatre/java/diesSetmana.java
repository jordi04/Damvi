import java.util.Scanner;
class Main {
  public static void main(String[] args) {
      Scanner myObj = new Scanner(System.in);
        System.out.println("Introdueix el dia inicial");
        int dia = myObj.nextInt();

        // Comprova si el parell és el doble que el senar
        if (dia == 1) {
          System.out.println("Has introduït dilluns");
        }
        else if(dia == 2) {
          System.out.println("Has introduït dimarts");
        }
        else if(dia == 3) {
          System.out.println("Has introduït dimecres");
        }
        else if(dia == 4) {
          System.out.println("Has introduït dijous");
        }
        else if(dia == 5) {
          System.out.println("Has introduït divendres");
        }
        else if(dia == 6) {
          System.out.println("Has introduït dissabte");
        }
        else if(dia == 7) {
          System.out.println("Has introduït diumenge");
        }
        else {
          System.out.println("Has introduït un dia no vàlid");
        }
        System.out.println("Introdueix els dies que vols afegir");
        
        int diesAfegits = myObj.nextInt();
        int diaFinal = dia + diesAfegits % 7;

        if (diaFinal == 0) {
          System.out.println("Si passen " + diesAfegits + " dies, serà dilluns");
        }
        else if(diaFinal == 1) {
          System.out.println("Si passen " + diesAfegits + " dies, serà dimarts");
        }
        else if(diaFinal == 2) {
          System.out.println("Si passen " + diesAfegits + " dies, serà dimecres");
        }
        else if(diaFinal == 3) {
          System.out.println("Si passen " + diesAfegits + " dies, serà dijous");
        }
        else if(diaFinal == 4) {
          System.out.println("Si passen " + diesAfegits + " dies, serà divendres");
        }
        else if(diaFinal == 5) {
          System.out.println("Si passen " + diesAfegits + " dies, serà dissabte");
        }
        else {
          System.out.println("Si passen " + diesAfegits + " dies, serà diumenge");
        }
        
        
    
        
  }
}