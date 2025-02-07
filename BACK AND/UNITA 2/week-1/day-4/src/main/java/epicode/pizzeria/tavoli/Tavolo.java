package epicode.pizzeria.tavoli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
