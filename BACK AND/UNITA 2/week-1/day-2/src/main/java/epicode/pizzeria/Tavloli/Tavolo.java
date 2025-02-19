package epicode.pizzeria.Tavloli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//utilizzo l'annotazione NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tavolo {

    private int number;
    private int maxCapacity;
    private StatoTavolo statoTavolo;

    public void ToString(){

        System.out.println("Numero tavolo: " + number);
        System.out.println("Posti disponibile del tavolo: " + maxCapacity);
        System.out.println("Stato del tavolo: " + statoTavolo);
    }
}
