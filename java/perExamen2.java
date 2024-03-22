import java.util.Scanner;
public class perExamen2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String a = Integer.toString(input.nextInt());
        String b = "";

        //"5,0,5"
        for (int i = a.length()-1; i >= 0; i--) {
            b = b + a.charAt(i);
        }
        System.out.println(b);
        if (a.equals(b)) {
            System.out.println("es capicua");
        }
        else System.out.println("NO es capicua");


        int num = Integer.parseInt(a);

        for (int i = num; i < 10; i++) {
            
        }
    }
}
