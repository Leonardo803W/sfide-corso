package esercizio3;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Volontario extends Dipendente {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get
    //posso ottenre il valore delle variabili o cambiarli basta che ci sia un metoo che lo permette senza che siano i soliti get e set
    //nel momento che utilizzo extends devo utilizzare il costruttore della superclasse, ovvero un costruttore normale con gli stessi parametri della classe estesa, volendo si puo aggiungere altri parametri,
    //ma nel momento in cui metto il valore nelle variabili passate come parametro, le prime che devo mettere sempre sono quelle non con this ma con super rispettando l'ordine del costruttore della classe estesa

    private String nome;
    private int eta;
    private String cv;

    //il costruttore permette di creare le istanze della classe, ricevendo i valori o tramite parametri o che vengano settati dentro al costruttore senza che siano passati come parametri
    //in questo caso dato che voglio solo il metodo comune alle classi concrete che estendono quella astratta, nel super metto 0 poiche cio che ha volontario e comune solo per il metodo e non per le variabili nella classe astratta
    public Volontario(String nome, int eta, String cv) {

        super(0, 0);
        this.nome = nome;
        this.eta = eta;
        this.cv = cv;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {

        this.eta = eta;
    }

    public String getCv() {

        return cv;
    }

    public void setCv(String cv) {

        this.cv = cv;
    }

}
