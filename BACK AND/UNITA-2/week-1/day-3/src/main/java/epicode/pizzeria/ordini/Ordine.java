package epicode.pizzeria.ordini;

import epicode.pizzeria.tavoli.Tavolo;
import epicode.pizzeria.menu.ElementoMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//utilizzo l'annotazione NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordine {

    private int numeroOrdine;
    private Tavolo tavolo;
    private StatoOrdine statoOrdine;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione = LocalDateTime.now();
    private List<ElementoMenu> elementiOrdine = new ArrayList<>();

    // L'annotazione @Value in Spring è utilizzata per iniettare valori da file di configurazione, come application.properties o application.yml, direttamente nelle variabili di una classe
    // posso anche mettere quella variabile da un'altra parte, ma metterla nelle properties mi assicura che sia sempre aggiornata e non perderla in caso cambio la classe dove viene utilizzata

    @Value("${costo.coperto}")
    private double costoCoperto;

    public double calcolaCostoCoperto() {

        double totaleCoperto = numeroCoperti * costoCoperto;
        double SommaPrezzi = elementiOrdine.stream().mapToDouble(ElementoMenu::getPrice).sum();
        return totaleCoperto + SommaPrezzi;
    }

    public void stampaOrdine() {

        System.out.println("Numero ordine: " + numeroOrdine);
        System.out.println("Numero tavolo: " + tavolo);
        System.out.println("Stato ordine: " + statoOrdine);
        System.out.println("Numero coperti: " + numeroCoperti);
        System.out.println("Ora acquisizione: " + oraAcquisizione);
        System.out.println("Elementi dell'ordine: ");
        for (ElementoMenu e : elementiOrdine) {
            System.out.println(e);
        }
        System.out.println("Costo coperto: " + costoCoperto);
        System.out.println("Costo totale: " + calcolaCostoCoperto());
    }
}
