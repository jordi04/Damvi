public class NumeroAleatorio {
  public static void main(String[] args) {
    int numeroAleatorio = (int) (Math.random()*10+0);
    System.out.println("El número aleatorio entre 0 y 10 es: " + numeroAleatorio);
    //int n = 2;
    long ms = System.currentTimeMillis();
    System.out.println(ms);
    switch (numeroAleatorio){
      case 4: 
        System.out.println("yes 4");
        break;
      case 5: 
        System.out.println("yes 5");
        break;
      case 3: 
        System.out.println("yes 3");
        break;
      case 2: 
        System.out.println("yes 2");
        break;
      default:
       System.out.println("noo");
       break;
    }
    
    System.out.println(ms);
  }
}
