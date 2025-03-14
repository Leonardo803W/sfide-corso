package esercizio1;

public class Main {
    public static void main(String[] args) {

        Dipendente d1 = new Dipendente(1, 1000, Dipartimento.PRODUZIONE);
        Dipendente d2 = new Dipendente(2, 2000, Dipartimento.AMMINISTRAZIONE);
        Dipendente d3 = new Dipendente(3, 3000, Dipartimento.VENDITE);

        //anche se nella classe Dipendente non vi e alcun array, nel main posso creare degli array, ma per poter accedere ai campi di Dipendente quel array deve essere di tipo Dipendente

        Dipendente[] listaDipendenti = new Dipendente[3];
        listaDipendenti[0] = d1;
        listaDipendenti[1] = d2;
        listaDipendenti[2] = d3;

        for (int i = 0; i < listaDipendenti.length; i++) {

            System.out.println("Dipendente " + (i + 1) + " Matricola: " + listaDipendenti[i].getMatricola());
        }
    }
}