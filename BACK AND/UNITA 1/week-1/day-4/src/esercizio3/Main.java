package esercizio3;

public class Main {
    public static void main(String[] args) {

        DipendentePartTime d1 = new DipendentePartTime(1, 8);
        DipendenteFullTime d2 = new DipendenteFullTime(2, 2000);
        Dirigente d3 = new Dirigente(3000,  Dipartimento.VENDITE);
        Dirigente d4 = new Dirigente(3000,  Dipartimento.AMMINISTRAZIONE);
        Dirigente d5 = new Dirigente(3000,  Dipartimento.PRODUZIONE);
        Volontario d6 = new Volontario("Leo", 25, "Consulente informatico");

        d1.aggiungiOre(20);
        //System.out.println("Ore lavorate: " + d1.getOreLavorate());

        //anche se nella classe Dipendente non vi e alcun array, nel main posso creare degli array, ma per poter accedere ai campi di Dipendente quel array deve essere di tipo Dipendente

        Dipendente[] listaDipendenti2 = {d1, d2, d3, d4, d5, d6};

        for (int i = 0; i < listaDipendenti2.length; i++)
        {
            Dipendente dipendente = listaDipendenti2[i];

            if (dipendente instanceof DipendentePartTime)
            {
                DipendentePartTime partTime = (DipendentePartTime) dipendente;

                partTime.checkin();
            }
            else if (dipendente instanceof DipendenteFullTime)
            {
                DipendenteFullTime fullTime = (DipendenteFullTime) dipendente;

                fullTime.checkin();
            }
            else if (dipendente instanceof Dirigente)
            {
                Dirigente dirigente = (Dirigente) dipendente;

                dirigente.checkin();
            }
            else if (dipendente instanceof Volontario)
            {
                Volontario volontario = (Volontario) dipendente;

                volontario.checkin();
            }
        }
    }
}