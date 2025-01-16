package Esercizio1;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int contatore = 0;

        Set<String> words = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Inserire il numero di elementi seguito dal tasto Invio. Inserisci 0 per uscire");
        int numElementi = Integer.parseInt(myScanner.nextLine());

        if (numElementi > 0) {

            for (int i = 0; i < numElementi; i++)
            {
                System.out.println("Inserire nome: ");
                String word = myScanner.nextLine();

                boolean added = words.add(word);

                if (!added)
                {
                    System.out.println(word + " è già nell'elenco");
                    duplicates.add(word);
                }
            }

            System.out.println("Numero di parole distinte: " + words.size());
            System.out.println("Elenco delle parole distinte: " + words);
            System.out.println("Elenco delle parole duplicate: " + duplicates);

        }
        else
        {
            System.err.println("Non va bene un numero minore uguale a zero");
        }

        myScanner.close();
    }
}