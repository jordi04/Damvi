import java.util.Scanner;

public class JordiRocaMatrius3 {
    public static void main(String[] args) {
        // Definir la mida de la matriu
        int files = 7;
        int columnes = 24;

        // Inicialitzar la matriu
        int[][] matriu = new int[files][columnes];

        // Generar les temperatures aleatòriament en l'interval de [15ºC .. 35ºC]
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                matriu[i][j] = (int) (Math.random() * 21) + 15;
            }
        }

        // Calcular la temperatura màxima i mínima de la setmana
        int temperaturaMaximaSetmana = matriu[0][0];
        int temperaturaMinimaSetmana = matriu[0][0];

        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                if (matriu[i][j] > temperaturaMaximaSetmana) {
                    temperaturaMaximaSetmana = matriu[i][j];
                }
                if (matriu[i][j] < temperaturaMinimaSetmana) {
                    temperaturaMinimaSetmana = matriu[i][j];
                }
            }
        }

        // Calcular la temperatura màxima i mínima de cada dia
        int[] temperaturaMaximaDia = new int[files];
        int[] temperaturaMinimaDia = new int[files];

        for (int i = 0; i < files; i++) {
            temperaturaMaximaDia[i] = matriu[i][0];
            temperaturaMinimaDia[i] = matriu[i][0];
            for (int j = 0; j < columnes; j++) {
                if (matriu[i][j] > temperaturaMaximaDia[i]) {
                    temperaturaMaximaDia[i] = matriu[i][j];
                }
                if (matriu[i][j] < temperaturaMinimaDia[i]) {
                    temperaturaMinimaDia[i] = matriu[i][j];
                }
            }
        }

        // Calcular la temperatura mitjana de la setmana
        int sumaTemperaturesSetmana = 0;

        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                sumaTemperaturesSetmana += matriu[i][j];
            }
        }

        double mitjanaTemperaturesSetmana = (double) sumaTemperaturesSetmana / (files * columnes);

        // Calcular la temperatura mitjana de cada dia
        double[] mitjanaTemperaturesDia = new double[files];

        for (int i = 0; i < files; i++) {
            int sumaTemperaturesDia = 0;

            for (int j = 0; j < columnes; j++) {
                sumaTemperaturesDia += matriu[i][j];
            }

            mitjanaTemperaturesDia[i] = (double) sumaTemperaturesDia / columnes;
        }

        // Comptar el nombre de dies amb temperatura mitjana superior a 30 graus
        int contadorDiesAltaTemperatura = 0;

        for (int i = 0; i < files; i++) {
            if (mitjanaTemperaturesDia[i] > 30) {
                contadorDiesAltaTemperatura++;
            }
        }

        // Mostrar els resultats
        System.out.println("Temperatura màxima de la setmana: " + temperaturaMaximaSetmana + " graus centígrads");
        System.out.println("Temperatura mínima de la setmana: " + temperaturaMinimaSetmana + " graus centígrads");

        System.out.println("Temperatures màximes i mínimes de cada dia:");

        for (int i = 0; i < files; i++) {
            System.out.println("Dia " + i + ": Màxima: " + temperaturaMaximaDia[i] + " graus centígrads, Mínima: " + temperaturaMinimaDia[i] + " graus centígrads");
        }

        System.out.println("Mitjana de temperatura de la setmana: " + mitjanaTemperaturesSetmana + " graus centígrads");

        System.out.println("Mitjana de temperatura de cada dia:");

        for (int i = 0; i < files; i++) {
            System.out.println("Dia " + i + ": " + mitjanaTemperaturesDia[i] + " graus centígrads");
        }

        System.out.println("Nombre de dies amb mitjana de temperatura superior a 30 graus: " + contadorDiesAltaTemperatura);
    }
}
