package esercizio3;

public class Carrello {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get
    //in questa classe i tipi sono di altre classi, che di conseguenza nel momento metto un oggetto come parametro del costruttore se non corrisponde al tipo delle variabili (quindi se le istanze dell'ogetto passato non corrispondono ai tipi delle vareiabili) mi da errore

    private Cliente client;
    private Articolo[] articoli;

    //il costruttore permette di creare le istanze della classe, ricevendo i valori o tramite parametri o che vengano settati dentro al costruttore senza che siano passati come parametri

    public Carrello(Articolo[] articoli, Cliente client) {
        this.articoli = articoli;
        this.client = client;
    }

    public void totale() {

        double total = 0;

        for (int i = 0; i < articoli.length; i++) {

            int disponibilita = articoli[i].getQuantity();

            if (disponibilita != 0) {
                total += articoli[i].getPrice();
            }
            else
            {
                System.out.println("Abbiamo terminato la disponibilità di: "+ articoli[i].getDescriptions() + ", codice: "+ articoli[i].getCode());
            }
        }

        System.out.println("Totale: " + total);
    }
}
