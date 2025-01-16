package Esercizio1;

import java.util.Random;
import java.util.Scanner;

public class NumeriCasuali {
    public static void main(String[] args) {

        int[] array = new int[5];
        int posizione;
        Random mYrandom = new Random();

        // Riempio l'array con valori casuali tra 1 e 10
        for (int i = 0; i < array.length; i++)
        {
            array[i] = mYrandom.nextInt(10) + 1; // Genera un numero tra 1 e 10
        }

        Scanner mYscanner = new Scanner(System.in);

        System.out.println("Array iniziale: ");
        stampaArray(array);

        do
        {
            System.out.println("Inserire la posizione (1-5) e il nuovo valore (0 per uscire): ");
            posizione = mYscanner.nextInt();

            System.out.println("Inserire il nuovo numero: ");
            int nuovoValore = mYscanner.nextInt();

            // Modifica solo se la posizione è valida

                if (posizione >= 1 && posizione <= 5)
                {
                    array[posizione - 1] = nuovoValore; // -1 per adattare alla base 0
                    System.out.println("Nuovo stato dell'array: ");
                    stampaArray(array);

                }
            System.out.println("Posizione non valida. Scegli un numero tra 1 e 5.");
        }while (posizione != 0);

        mYscanner.close();
    }

    // Metodo per stampare l'array
    private static void stampaArray(int[] array)
    {
        for (int num : array)
        {
            System.out.print(num + " ");
        }
    }
}
