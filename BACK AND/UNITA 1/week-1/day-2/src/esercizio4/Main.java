package esercizio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.print("Inserisci un numero per il conto alla rovescia: ");
        int num = myScanner.nextInt();

        for(int i = num; i >= 0; i--)
        {
            System.out.println(i);
        }

        myScanner.close();

        System.out.println("Programma terminato");
    }
}