package epicode.pizzeria.menu;

import epicode.pizzeria.aggiunte.Topping;
import epicode.pizzeria.bevande.Drink;
import epicode.pizzeria.pizze.Pizza;
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
public class Menu {

    private String nome;
    List <Pizza> pizze = new ArrayList<>();
    List <Drink> bevande = new ArrayList<>();

    //List <Topping> aggiunte = new ArrayList<>();

    // quello sopra va bene se utilizzo il primo metodo nel config di menu
    // quello sotto posso farlo perche sto utilizzando il secondo metodo nel config di menu

    List <Topping> aggiunte;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu:").append(System.lineSeparator());
        for (Pizza pizza : pizze) {
            sb.append("- ").append(pizza.getName()).append(" (").append(pizza.getPrice()).append("€)").append(System.lineSeparator());
        }
        // Aggiungi bevande se necessario
        if (!bevande.isEmpty()) {
            sb.append(System.lineSeparator()).append("Bevande:").append(System.lineSeparator());
            for (Drink drink : bevande) {
                sb.append("- ").append(drink.getName()).append(" (").append(drink.getPrice()).append("€)").append(System.lineSeparator());
            }
        }
        // Aggiungi toppings se necessario
        if (aggiunte != null && !aggiunte.isEmpty()) {
            sb.append(System.lineSeparator()).append("Aggiunte:").append(System.lineSeparator());
            for (Topping topping : aggiunte) {
                sb.append("- ").append(topping.getName()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
