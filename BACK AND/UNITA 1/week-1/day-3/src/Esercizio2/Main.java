package Esercizio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("inserire il suo numero telefonico con il + del suo paese: ");

        String numberPhon = myScanner.nextLine();

        Sim sim1 = new Sim(numberPhon);

        Chiamata[] listaChiamate = new Chiamata[6];

        listaChiamate[0] = new Chiamata("+39 031 542 6794", 5);
        listaChiamate[1] = new Chiamata("+39 978 649 1432", 10);
        listaChiamate[2] = new Chiamata("+39 794 013 4615", 20);
        listaChiamate[3] = new Chiamata("+39 645 187 0346", 35);
        listaChiamate[4] = new Chiamata("+39 987 461 03485", 50);

        sim1.stampaCredito();
        sim1.usareCredito(10);
        sim1.aggiungiCredito(50.50);
        sim1.usareCredito(30);
        sim1.setListaChiamate(listaChiamate);
        sim1.stampaDati();
    }
}
