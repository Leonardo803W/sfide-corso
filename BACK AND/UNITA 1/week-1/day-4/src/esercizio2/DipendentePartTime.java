package esercizio2;

public class DipendentePartTime extends Dipendente {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get
    //posso ottenre il valore delle variabili o cambiarli basta che ci sia un metoo che lo permette senza che siano i soliti get e set
    //nel momento che utilizzo extends devo utilizzare il costruttore della superclasse, ovvero un costruttore normale con gli stessi parametri della classe estesa, volendo si puo aggiungere altri parametri,
    //ma nel momento in cui metto il valore nelle variabili passate come parametro, le prime che devo mettere sempre sono quelle non con this ma con super rispettando l'ordine del costruttore della classe estesa

    private int oreLavorate;
    private int pagaOraria;

    //il costruttore permette di creare le istanze della classe, ricevendo i valori o tramite parametri o che vengano settati dentro al costruttore senza che siano passati come parametri

    public DipendentePartTime(int matricola, int pagaOraria) {

        super(matricola, 0);
        this.oreLavorate = 0;
        this.pagaOraria = pagaOraria;
    }

    public int getOreLavorate() {

        return oreLavorate;
    }

    public void aggiungiOre(int ore) {

        if ( this.oreLavorate >= 20) {

            System.out.println("Ore di lavoro massime raggiunte: " +  this.oreLavorate);
        }
        else
        {
            this.oreLavorate += ore;
        }
    }

    public void diminuisciOre(int ore) {

        if ( this.oreLavorate <= 0) {

            System.out.println("Non si puo scendere sotto lo 0 di ore lavorative!");
        }
        else
        {
            this.oreLavorate -= ore;
        }
    }

    //se voglio che le classi che estendono la classe astratta abbiano un metodo uguale, devo mettere prima quel metodo nella classe astrsatta
    //per poi sia che lascio il metodo cosi come oppure cambiarlo a seconda della classe concreta devo fare un @Override per indicare che questo metodo viene sovrascritto

    @Override
    public double calculateSalary() {

        double total = 0;
        int totOre = 0;
        double totStipendio = 0;

        for (int i = 0; i < 4; i++) {

            totOre += this.oreLavorate;
            //System.out.println(totOre);

            totStipendio = this.pagaOraria * totOre;
            //System.out.println(totStipendio);
        }

        return total = totStipendio;
    }
}
