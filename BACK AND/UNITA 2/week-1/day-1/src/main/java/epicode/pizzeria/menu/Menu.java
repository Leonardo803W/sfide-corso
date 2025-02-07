package epicode.pizzeria.menu;

import epicode.pizzeria.aggiunte.Topping;
import epicode.pizzeria.bevande.Drink;
import epicode.pizzeria.pizze.Pizza;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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


}
