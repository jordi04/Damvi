import java.util.Scanner;

public class Rectangle {
    private double amplada;
    private double alçada;

    public Rectangle() {
        this.amplada = 1;
        this.alçada = 1;
    }

    public Rectangle(double amplada, double alçada) {
        this.amplada = amplada;
        this.alçada = alçada;
    }

    public double getAmplada() {
        return amplada;
    }

    public void setAmplada(double amplada) {
        this.amplada = amplada;
    }

    public double getAlçada() {
        return alçada;
    }

    public void setAlçada(double alçada) {
        this.alçada = alçada;
    }

    public double getArea() {
        return amplada * alçada;
    }

    public double getPerimetre() {
        return 2 * (amplada + alçada);
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        System.out.println("Rectangle 1:");
        System.out.println("Amplada: " + rectangle1.getAmplada());
        System.out.println("Alçada: " + rectangle1.getAlçada());
        System.out.println("Àrea: " + rectangle1.getArea());
        System.out.println("Perímetre: " + rectangle1.getPerimetre());

        System.out.println("\nRectangle 2:");
        System.out.println("Amplada: " + rectangle2.getAmplada());
        System.out.println("Alçada: " + rectangle2.getAlçada());
        System.out.println("Àrea: " + rectangle2.getArea());
        System.out.println("Perímetre: " + rectangle2.getPerimetre());
    }
}
