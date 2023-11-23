import java.util.Scanner;
/*
 Implementa un programa que presenti un menú amb les següents opcions:
a) Introduir sous: Demanarà els sous dels nostres 10 empleats. Aquest salari serà un valor entre 500 i 5000 euros, amb possibilitat de decimals.
b) Calcular Sou Net: Per cada empleat calcularà i emmagatzemarà el salari corresponent,
 traient del sou el percentatge que haurà de deduir en concepte de Seguretat Social que serà del 6% sempre. 
En concepte d’IRPF el percentatge a treure serà variable, segons s’indica a continuació:
salari <= 700 -> IRPF 8%
700 < salari <= 1100 -> IRPF 11%
1100 < salari <= 1500 -> IRPF 13%
1500 < salari <= 2100 -> IRPF 17%
2100 < salari <= 3000 -> IRPF 20%
salari < 3000 -> IRPF 25%
c) Modificar Sou: El programa demanarà un número d’empleat i ens mostrarà el seu sou. 
Ens donarà la possibilitat d’introduir un nou sou per aquest empleat, però solament permetrà el canvi si el sou s’incrementa.
d) Pujar Sous: El programa demanarà un percentatge i pujarà tots els sous en el percentatge corresponent.
e) Finalitzar l'execució del programa
*/
public class JordiRoca0512 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] sousBruts = new double[10]; //vector que conte el sou brut de tots els empleats
        double[] sousNets = new double[10]; //vector que conte el sou net de tots els empleats
        double nombreUsuari = 0;
        double seguretatSocial = 0.06;
        double irpf = 0.0;
        boolean run = true; //bool per finalitzar l'execució
        double pujada = 0.0;
        int option; //opcio seleccionada
        int numEmpleat = 0; //num Empleat


        while (run) {
            System.out.println("Selecciona una opció \n 1) Introduir sous\n 2) Calcular Sou Net\n 3) Modificar Sou\n 4) Pujar Sous\n 5) Finalitzar l'execució del programa"); //Menú opcions
            option = scanner.nextInt();
            switch (option) {
                //a) Introduir sous: Demanarà els sous dels nostres 10 empleats. Aquest salari serà un valor entre 500 i 5000 euros, amb possibilitat de decimals.
                case 1:
                    for (int i = 0; i < 10; i++) {
                        System.out.print("Insereix un sou (nombre decimal): ");
                        nombreUsuari = scanner.nextDouble();
                        System.out.println();
                        while (nombreUsuari < 500.0 || nombreUsuari > 5000.0) {
                            System.out.print("Insereix un sou (nombre decimal) dins l'interval [500,5000]: ");
                            nombreUsuari = scanner.nextDouble();
                            System.out.println();
                        }
                        sousBruts[i] = nombreUsuari;
                    }
                    break;
                //b) Calcular Sou Net
                case 2:
                    System.out.println("Calculant sous...");
                    for (int i = 0; i < 10; i++) {
                        if (sousBruts[i] <= 700) irpf = 0.08;
                        else if (700 < sousBruts[i] && sousBruts[i] <= 1100) irpf = 0.11;
                        else if (1100 < sousBruts[i] && sousBruts[i] <= 1500) irpf = 0.13;
                        else if (1500 < sousBruts[i] && sousBruts[i] <= 2100) irpf = 0.17;
                        else if (2100 < sousBruts[i] && sousBruts[i] <= 3000) irpf = 0.2;
                        else if (sousBruts[i] < 3000) irpf = 0.25;

                        sousNets[i] = sousBruts[i]*(1-(irpf + seguretatSocial)); //calculam el sou net corresponent
                    }
                    System.out.println("Sous calculats!");
                    break;

                //c) Modificar Sou: El programa demanarà un número d’empleat i ens mostrarà el seu sou. 
                //Ens donarà la possibilitat d’introduir un nou sou per aquest empleat, però solament permetrà el canvi si el sou s’incrementa.
                case 3:
                    System.out.print("Insereix número d'empleat: ");
                    numEmpleat = scanner.nextInt();
                    System.out.println();
                    System.out.printf("El sou de l'empleat %d és: \n Sou Net: %f \n Sou Brut: %f \n",numEmpleat, sousNets[numEmpleat], sousBruts[numEmpleat]);
                    
                    System.out.print("Si vols pujar el sou (el sou brut) insereix un numero, si no vols fer-ho introdueix 0 ");
                    pujada = scanner.nextDouble(); //sou a pujar
                    if (pujada == 0.0) break;
                    else if (pujada > sousBruts[numEmpleat]) {
                        sousBruts[numEmpleat] = pujada;
                        if (sousBruts[numEmpleat] <= 700) irpf = 0.08;
                        else if (700 < sousBruts[numEmpleat] && sousBruts[numEmpleat] <= 1100) irpf = 0.11;
                        else if (1100 < sousBruts[numEmpleat] && sousBruts[numEmpleat] <= 1500) irpf = 0.13;
                        else if (1500 < sousBruts[numEmpleat] && sousBruts[numEmpleat] <= 2100) irpf = 0.17;
                        else if (2100 < sousBruts[numEmpleat] && sousBruts[numEmpleat] <= 3000) irpf = 0.2;
                        else if (sousBruts[numEmpleat] < 3000) irpf = 0.25;

                        sousNets[numEmpleat] = sousBruts[numEmpleat]*(1-(irpf + seguretatSocial)); //calculam el sou net corresponent aixi no s'ha de tornar a calcular per separat
                    }
                    break;
                //d) Pujar Sous: El programa demanarà un percentatge i pujarà tots els sous en el percentatge corresponent.
                case 4:
                    System.out.print("Insereix el percentatge que vols pujar els sous: ");
                    pujada = scanner.nextDouble();
                    System.out.println();
                    for (int i = 0; i < 10; i++) {
                        sousBruts[i] = sousBruts[i]*(1 + pujada/100); //Pujam sou brut
                        //Ho hem de fer aixi ja que per exemple, el 10% de 100 no és el mateix que el 10% de 80
                        if (sousBruts[i] <= 700) irpf = 0.08;
                        else if (700 < sousBruts[i] && sousBruts[i] <= 1100) irpf = 0.11;
                        else if (1100 < sousBruts[i] && sousBruts[i] <= 1500) irpf = 0.13;
                        else if (1500 < sousBruts[i] && sousBruts[i] <= 2100) irpf = 0.17;
                        else if (2100 < sousBruts[i] && sousBruts[i] <= 3000) irpf = 0.2;
                        else if (sousBruts[i] < 3000) irpf = 0.25;
                        sousNets[i] = sousBruts[i]*(1-(irpf + seguretatSocial)); //Pujam sou net
                    }
                    break;
                //e) Finalitzar l'execució del programa
                case 5:
                    System.err.println("Fins aviat!");
                    run = false; //Sortim de l'execució
                    break;

                default: System.out.println("Opció no existeix");
            }
            System.out.println();
        }     
    }      
}
