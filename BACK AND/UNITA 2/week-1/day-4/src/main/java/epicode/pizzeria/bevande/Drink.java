package epicode.pizzeria.bevande;

import epicode.pizzeria.menu.ElementoMenu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//utilizzo l'annotazione table per la tabella e NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok
//@Table questa annotazione specifica il nome della tabella se il nome e uguale al nome della tabella non serve specificare con name tra parentesi
//entity per far gestire al framwork la classe, in oltre se non specifico il nome facendo: (name = "dipendenti"), il databese non avra problemi a riconoscere quale tabella fa parte l'entita
//Entity e Table posso utilizzarle grazie alle dipendenze runtime e spring-boot-starter-data-jpa

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drinks")
public class Drink extends ElementoMenu {

    //l'id serve per specificare alla tabella quale la chiave primaria
    //@GeneratedValue: Questa annotazione specifica come gestire la generazione del valore della chiave primaria
    //strategy = GenerationType.SEQUENCE: Questa opzione specifica che il framework usi un sequenza per gestire la chiave primaria

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private int calories;
    private double price;

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }

    @Override
    public int getCalorie() {
        return calories;
    }
}
