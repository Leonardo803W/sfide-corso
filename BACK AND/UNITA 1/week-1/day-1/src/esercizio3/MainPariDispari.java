package esercizio3;

import java.util.Scanner;

public class MainPariDispari {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        //posso scegliere il numero personalmente facendo come nel commenti sotto di num1 e num2
        //se vogli invece che sia l'utente a scegliere il numero posso usare Scanner ricordando di ciuderlo, non e essenziare farlo ma e di buona pratica farlo

        //int num1 = 5;

        System.out.println("Scegliere un numero intero: ");
        int num1 = myScanner.nextInt();

        pariDispari(num1);
    }

    //il metodo essendo in un main devo metterlo come static che abbia ritorno oppure no
    //i motivi per cui il metodo e il main sono statici sono i seguenti:
    //Punto di ingresso: Il metodo main è il punto di ingresso del tuo programma Java. Quando esegui il tuo programma, la Java Virtual Machine (JVM) cerca il metodo main e inizia l'esecuzione da lì.
    //Esecuzione senza istanza: La JVM non crea un'istanza della classe contenente il metodo main prima di eseguire il programma. Invece, esegue il metodo main direttamente.
    //Metodi statici: I metodi statici appartengono alla classe stessa, non a un'istanza specifica. Questo significa che possono essere chiamati senza creare un oggetto della classe.

    //il nome che metto nei parametri puo essere diverso dal nome della variabile che do nel momento in cui chiamo il metodo, questo perche anche se nome differenti il valore e sempre della variabile che gli passo, ma devono combaciare il tipo delle variabili sia in chiamata sia nel parametro

    public static void pariDispari(int n){

        if(n % 2 == 0)
        {
            System.out.println("il numero inserito e pari!");
        }
        else
        {
            System.out.println("il numero inserito non e pari!");
        }
    }
}
