package epicode.pizzeria.pizze;

import epicode.pizzeria.aggiunte.Topping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    private String nome;
    private int calorie;
    private double price;

    private List <Topping> toppingList = new ArrayList<>();
}
