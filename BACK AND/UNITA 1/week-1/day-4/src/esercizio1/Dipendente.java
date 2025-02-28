package esercizio1;

public class Dipendente {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get
    //posso ottenre il valore delle variabili o cambiarli basta che ci sia un metoo che lo permette senza che siano i soliti get e set
    //il tipo delle variabili possono essere anche di tipo di una classe come Dipartimento

    private int matricola;
    private double stipendio;
    private Dipartimento dipartimento;

    //il costruttore permette di creare le istanze della classe, ricevendo i valori o tramite parametri o che vengano settati dentro al costruttore senza che siano passati come parametri

    public Dipendente(int matricola, double stipendio, Dipartimento dipartimento) {

        this.matricola = matricola;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    public int getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    public void stampaDipendente() {

        System.out.println("Matricola: " + matricola);
        System.out.println("Stipendio: " + stipendio);
        System.out.println("Dipartimento: " + dipartimento);
        System.out.println("------------------------------");
    }
}
