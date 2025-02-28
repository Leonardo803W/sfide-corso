package esercizio2;

public class Main {
    public static void main(String[] args) {

        DipendentePartTime d1 = new DipendentePartTime(1, 8);
        DipendenteFullTime d2 = new DipendenteFullTime(2, 2000);
        Dirigente d3 = new Dirigente(3000,  Dipartimento.VENDITE);
        Dirigente d4 = new Dirigente(3000,  Dipartimento.AMMINISTRAZIONE);
        Dirigente d5 = new Dirigente(3000,  Dipartimento.PRODUZIONE);

        d1.aggiungiOre(20);
        //System.out.println("Ore lavorate: " + d1.getOreLavorate());

        //anche se nella classe Dipendente non vi e alcun array, nel main posso creare degli array, ma per poter accedere ai campi di Dipendente quel array deve essere di tipo Dipendente

        Dipendente[] listaDipendenti = {d1, d2, d3, d4, d5};

        for (int i = 0; i < listaDipendenti.length; i++)
        {
            Dipendente dipendente = listaDipendenti[i];

            if (dipendente instanceof DipendentePartTime)
            {
                DipendentePartTime partTime = (DipendentePartTime) dipendente;

                System.out.println("Dipendente Part Time " + (i + 1) + ", stipendio: " + partTime.calculateSalary());
            }
            else if (dipendente instanceof DipendenteFullTime)
            {
                DipendenteFullTime fullTime = (DipendenteFullTime) dipendente;

                System.out.println("Dipendente Full Time " + (i + 1) + ", stipendio: " + fullTime.calculateSalary());
            }
            else if (dipendente instanceof Dirigente)
            {
                Dirigente dirigente = (Dirigente) dipendente;

                System.out.println("Dirigente " + dirigente.getDipartimento() + " " + (i + 1) + ", stipendio: " + dirigente.calculateSalary());
            }
        }
    }
}