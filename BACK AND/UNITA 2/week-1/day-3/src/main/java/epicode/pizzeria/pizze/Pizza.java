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
public class Pizza implements ElementoMenu {

    private String name;
    private int calorie;
    private double price;

    private List <Topping> toppingList = new ArrayList<>();

    //sto facendo l'override perche implementando ElementoMenu se vi sono nomi che differiscono tra la classe effettiva e l'interfaccia
    //nel return devo mettere i nomi che differiscono della classe in caso non corrispondano ai nome dell'interfaccia.

    public void ToString(){

        System.out.println("Nome della pizza: " + name);
        System.out.println("Calorie: " + calorie);
        System.out.println("Prezzo: " + price);
    }
}
