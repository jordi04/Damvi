import java.util.Scanner;

public class JordiRocaMatrius6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[] solucions = {'D','C','B','E','A','C','E','B','A','D'};

        char[][] respostes = new char[8][10];

        int[] notes = new int[8];


        //Generació de respostes d'alumne aleatories
        System.out.println(respostes.length);
        int random;
        for (int i = 0; i < respostes.length; ++i){
            for (int j = 0; j < 10; ++j) {
                random = (int) (Math.random() * 5);
                //System.out.println(random);
                switch (random) {
                    case 0:
                        respostes[i][j] = 'A';
                        break;
                    case 1:
                        respostes[i][j] = 'B';
                        break;
                    case 2:
                        respostes[i][j] = 'C';
                        break;
                    case 3:
                        respostes[i][j] = 'D';
                        break;
                    case 4:
                        respostes[i][j] = 'E';
                        break;
                }
            }
        }
        //Calculam i imprimim la nota de cada alumne
        int count;
        for (int i = 0; i < respostes.length; ++i) {
            count = 0;
            for (int j = 0; j < 10; ++j) {
                if (respostes[i][j] == solucions[j])count++;
            }
            notes[i] = count;
            System.out.println("Nota almune " + i + ": " + notes[i]);
        }
    }
}
