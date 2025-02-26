package esercizio2;

public class Chiamata {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get

    private String numberPhon;
    private int duration;

    //il costruttore permette di creare le istanze della classe, ricevendo i valori o tramite parametri o che vengano settati dentro al costruttore senza che siano passati come parametri

    public Chiamata(String numberPhon, int duration) {
        this.numberPhon = numberPhon;
        this.duration = duration;
    }

    public String getNumberPhon() {
        return numberPhon;
    }

    public void setNumberPhon(String numberPhon) {
        this.numberPhon = numberPhon;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
