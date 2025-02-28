package esercizio3;

public class DipendenteFullTime extends Dipendente {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get
    //posso ottenre il valore delle variabili o cambiarli basta che ci sia un metoo che lo permette senza che siano i soliti get e set
    //nel momento che utilizzo extends devo utilizzare il costruttore della superclasse, ovvero un costruttore normale con gli stessi parametri della classe estesa, volendo si puo aggiungere altri parametri,
    //ma nel momento in cui metto il valore nelle variabili passate come parametro, le prime che devo mettere sempre sono quelle non con this ma con super rispettando l'ordine del costruttore della classe estesa

    private int oreLavorate;

    //il costruttore permette di creare le istanze della classe, ricevendo i valori o tramite parametri o che vengano settati dentro al costruttore senza che siano passati come parametri

    public DipendenteFullTime(int matricola, double stipendio) {

        super(matricola, stipendio);
        this.oreLavorate = 40;
    }

    //se voglio che le classi che estendono la classe astratta abbiano un metodo uguale, devo mettere prima quel metodo nella classe astrsatta
    //per poi sia che lascio il metodo cosi come oppure cambiarlo a seconda della classe concreta devo fare un @Override per indicare che questo metodo viene sovrascritto

    @Override
    public double calculateSalary() {

        return super.getStipendio();
    }

    public int getOreLavorate() {

        return oreLavorate;
    }
}
