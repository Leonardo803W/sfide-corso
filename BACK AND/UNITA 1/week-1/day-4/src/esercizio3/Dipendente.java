package esercizio3;

import java.time.LocalDateTime;

public abstract class Dipendente {

    //private indico la sicurezza di questa variabile, essendo private la si puo utilizzare unicamente nella sua classe per poterla avere o cambiare devo creare metodi pubblici con i vari set e get
    //se fosse stata con public non servirebbero i set e i get poiche potrei cambiare i valori d'ovunque io mi trovi
    //con protected potrei cambiare i valori senza i get e i set solo nel puckege al di fuori di quello ho bisogno dei set e get
    //posso ottenre il valore delle variabili o cambiarli basta che ci sia un metoo che lo permette senza che siano i soliti get e set
    //abstract e sempre una classe ma a differenza delle classi concrete non posso istanziarla nel main, ma permette di assicurare metodi, costruttori e variabili alle classi che estendono con extend la classe astratte

    private int matricola;
    private double stipendio;

    public Dipendente(int matricola, double stipendio) {

        this.matricola = matricola;
        this.stipendio = stipendio;
    }

    public int getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public double calculateSalary() {

        return 0;
    }

    //questo metodo anche se non sovrascritto nelle classi concrete potra essere utilizzato da quest'ultime affinche estendino la classe astratta
    public void checkin() {

        System.out.println("Inizio turno: " + LocalDateTime.now());
    }
}
