package esercizio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.print("Inserisci un numero: ");
        int num1 = myScanner.nextInt();

        //utilizzo il do while per far in modo che entri nel ciclo almeno una volta
        //differenza delo while che posso non entrare mai

        do {

            switch (num1) {

                case 0:
                    System.out.println("A");
                    break;
                case 1:
                    System.out.println("E");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("C");
                    break;
                default:
                    System.out.println("Errore, scegliere un numero tra 0 e 3");
            }

            System.out.print("Inserisci un numero, per uscire 4: ");
            num1 = myScanner.nextInt();

        }while (num1 != 4);

        myScanner.close();

        System.out.println("Programma terminato");
    }
}