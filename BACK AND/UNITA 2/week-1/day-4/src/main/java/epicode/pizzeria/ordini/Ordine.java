package epicode.pizzeria.ordini;

import epicode.pizzeria.tavoli.Tavolo;
import epicode.pizzeria.menu.ElementoMenu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionIdMutability;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ordini")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    private Tavolo tavolo;
    private StatoOrdine statoOrdine;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione = LocalDateTime.now();

    @ManyToMany
    private List<ElementoMenu> elementiOrdine = new ArrayList<>();

    @Value("$[costo.coperto]")
    private double costoCoperto;

    public double calcolaCostoCoperto() {

        double totaleCoperto = numeroCoperti * costoCoperto;
        double SommaPrezzi = elementiOrdine.stream().mapToDouble(ElementoMenu::getPrice).sum();
        return totaleCoperto + SommaPrezzi;
    }

    public void stampaOrdine() {

        System.out.println("Numero ordine: " + id);
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
