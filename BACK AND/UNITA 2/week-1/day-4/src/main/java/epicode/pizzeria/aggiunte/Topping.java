package epicode.pizzeria.aggiunte;

import epicode.pizzeria.menu.ElementoMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topping extends ElementoMenu {

    private String name;
    private int calorie;
    private double price;

}
