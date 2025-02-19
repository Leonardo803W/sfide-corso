package epicode.pizzeria.aggiunte;

import epicode.pizzeria.menu.ElementoMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//utilizzo l'annotazione NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok
//implements ElementoMenu serve a dire che la classe implementa l'interfaccia ElementoMenu e serve nel momento in cui in ConfigMneu gli passo la lista dei vari oggetti creati con i bean
//perche poi quella lista essendo di tipo ElementoMenu non contiene variabili ma metodi che venendo implementati rispettano cio che la lista si aspetta

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topping implements ElementoMenu {

    private String name;
    private int calories;
    private double price;

    @Override
    public String toString() {
        return "Topping{" +
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
