package epicode.pizzeria.bevande;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drink {

    private String name;
    private int calorie;
    private double price;
}
