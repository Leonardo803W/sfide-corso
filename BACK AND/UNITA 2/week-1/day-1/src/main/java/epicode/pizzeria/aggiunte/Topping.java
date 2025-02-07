package epicode.pizzeria.aggiunte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topping {

    private String nome;
    private int calorie;
    private double price;
}
