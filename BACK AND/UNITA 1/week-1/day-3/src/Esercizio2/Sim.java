package esercizio2;

import java.util.Arrays;

public class Sim {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get

    private String numberPhon;
    private double credit;
    private Chiamata[] contacts;

    //il costruttore permette di creare le istanze della classe, ricevendo i valori o tramite parametri o che vengano settati dentro al costruttore senza che siano passati come parametri

    public Sim(String number) {

        this.numberPhon = number;
        this.credit = 0;
        this.contacts = new Chiamata[5];
    }

    public String getNumberPhon() {
        return numberPhon;
    }

    public void setNumberPhon(String numberPhon) {
        this.numberPhon = numberPhon;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Chiamata[] getContacts() {
        return contacts;
    }

    public void setContacts(Chiamata[] contacts) {
        this.contacts = contacts;
    }

    public void stampaDati() {
        System.out.println("Numero telefonico: " + numberPhon);
        System.out.println("Crediti: " + credit);
        //System.out.println("Contatti: " + Arrays.toString(contacts));
        if (contacts[0] != null) {
            System.out.println("- Chiamata 1: " + contacts[0].getNumberPhon() + " - Durata minuti: "
                    + contacts[0].getDuration());
        }
        if (contacts[1] != null) {
            System.out.println("- Chiamata 2: " + contacts[1].getNumberPhon() + " - Durata minuti: "
                    + contacts[1].getDuration());
        }
        if (contacts[2] != null) {
            System.out.println("- Chiamata 3: " + contacts[2].getNumberPhon() + " - Durata minuti: "
                    + contacts[2].getDuration());
        }
        if (contacts[3] != null) {
            System.out.println("- Chiamata 4: " + contacts[3].getNumberPhon() + " - Durata minuti: "
                    + contacts[3].getDuration());
        }
        if (contacts[4] != null) {
            System.out.println("- Chiamata 5: " + contacts[4].getNumberPhon() + " - Durata minuti: "
                    + contacts[4].getDuration());
        }
    }
}
