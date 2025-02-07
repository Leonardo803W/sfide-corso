package epicode.pizzeria.pizze;

import epicode.pizzeria.aggiunte.Topping;
import epicode.pizzeria.menu.ElementoMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza extends ElementoMenu {

    private String name;
    private int calorie;
    private double price;

}
