package esercizio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //inizializzo una stringa vuota che poi verra dato il valore dall'input dell'utente

        String input = "";

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Inserire una stringa seguita dal tasto Invio, per uscire q");
            input = scanner.nextLine();

            //trasformo la stringa in un array utilizzando un'altra variabile che e un array e utilizzo split per dividere la stringa
            //("") tra parentesi gli dico in questo modo di dividere il valore in singoli caratteri
            String[] caratteri = input.split("");

            //stampo l'array dicendogli di unire con join il singolo carattere seguito dalla virgola
            System.out.println(String.join(",", caratteri));

        } while (!input.equals("q"));

        scanner.close();

        System.out.println("Exit");
    }
}
