package epicode.pizzeria.menu;

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
//@Inheritance: Questa annotazione specifica che la classe ElementoMenu è una classe padre che può essere ereditata da altre classi.
//strategy = InheritanceType.TABLE_PER_CLASS: Questa opzione specifica che ogni sottoclasse di ElementoMenu avrà la propria tabella separata nel database.

@Entity
@Table(name = "elementi_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ElementoMenu {

    //l'id serve per specificare alla tabella quale la chiave primaria
    //@GeneratedValue: Questa annotazione specifica come gestire la generazione del valore della chiave primaria
    //strategy = GenerationType.SEQUENCE: Questa opzione specifica che il framework usi un sequenza per gestire la chiave primaria

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    public String name;
    public double price;
    public int calorie;
}
