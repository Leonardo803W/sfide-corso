package epicode.pizzeria.aggiunte;

import epicode.pizzeria.menu.ElementoMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topping implements ElementoMenu {

    private String name;
    private int calorie;
    private double price;

    //sto facendo l'override perche implementando ElementoMenu se vi sono nomi che differiscono tra la classe effettiva e l'interfaccia
    //nel return devo mettere i nomi che differiscono della classe se non sono uguali ai nomi all'interfaccia.


    public void ToString(){

        System.out.println("Nome dell'aggiunta: " + name);
        System.out.println("Calorie: " + calorie);
        System.out.println("Prezzo: " + price);
    }
}
