public class banderaEU {
    public static void main(String[] args) {

        for (int i = 0; i < 15; i++) {
            if (i < 9) {
                for (int j = 0; j < 45; ++j) {
                    if (j < 9) System.out.print("* ");
                    else System.out.print('=');
                }
            }
            else {
                for (int j = 0; j < 45+9; ++j) {
                    System.out.print('=');
                }
            }
            System.out.println();
        }
    }
}
