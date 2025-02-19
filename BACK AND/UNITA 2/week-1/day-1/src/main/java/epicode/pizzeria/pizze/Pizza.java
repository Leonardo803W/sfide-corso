package epicode.pizzeria.pizze;

import epicode.pizzeria.aggiunte.Topping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

//utilizzo l'annotazione NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//queste annotazioni posso utilizzare grazie alla dependency lombok

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    private String name;
    private int calories;
    private double price;

    private List <Topping> toppingList = new ArrayList<>();

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", toppingList=" + toppingList +
                '}';
    }
}
