package Esercizio3;

import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {

        String input = "";

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Inserire una stringa seguita dal tasto Invio, per uscire: :q");

            input = scanner.nextLine();

            String[] caratteri = input.split("");

            System.out.println(String.join(",", caratteri));

        } while (!input.equals(":q"));

        scanner.close();

        System.out.println("Exit");
    }
}
