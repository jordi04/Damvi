public class SumaResta {
    public double calcularMaxim(double num1, double num2) {
        return Math.max(num1, num2);
    }

    public double calcularMinim(double num1, double num2) {
        return Math.min(num1, num2);
    }

    public double calcularDiferencia(double num1, double num2) {
        return Math.abs(num1 - num2);
    }

    public double calcularSuma(double num1, double num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        SumaResta sr = new SumaResta();

        double a = 5;
        double b = 3.5;

        System.out.println("El màxim entre " + a + " i " + b + " és: " + sr.calcularMaxim(a, b));
        System.out.println("El mínim entre " + a + " i " + b + " és: " + sr.calcularMinim(a, b));
        System.out.println("La diferència entre " + a + " i " + b + " és: " + sr.calcularDiferencia(a, b));
        System.out.println("La suma de " + a + " i " + b + " és: " + sr.calcularSuma(a, b));
    }
}
