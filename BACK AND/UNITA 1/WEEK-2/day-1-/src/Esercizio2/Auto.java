package Esercizio2;

import java.util.Scanner;

public class Auto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Inserire i kilometri percorsi: ");
            int km = scanner.nextInt();

            System.out.println("Inserire i litri di benzina consumati: ");
            double litri = scanner.nextInt();

            double kmLiter = km / litri;

            if (litri == 0)
            {
                throw new ArithmeticException("Non si può dividere per zero!");
            }

            System.out.println("L'auto percorre " + kmLiter + " km al litro");


        }
        catch (ArithmeticException e)
        {
            System.out.println("Impossibile che la tua macchina non consumi carburante, controlla i litri inseriti");

            e.printStackTrace();
        }
        finally
        {
            scanner.close();
        }
    }
}
