package Esercizio4;

import java.util.Scanner;

public class Esercizio4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("scegliere il numero per il countdown e premere invio: ");

        int numberChoose = scanner.nextInt();

        for (int i = numberChoose; i >= 0; i--) {
            System.out.println(i + " secondi");
        }

        scanner.close();
    }
}
