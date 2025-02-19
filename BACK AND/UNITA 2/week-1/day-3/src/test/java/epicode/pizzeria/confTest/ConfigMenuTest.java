package epicode.pizzeria.confTest;

import epicode.pizzeria.aggiunte.Topping;
import epicode.pizzeria.bevande.Drink;
import epicode.pizzeria.menu.Menu;
import epicode.pizzeria.pizze.Pizza;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

//@SpringBootTest è un'annotazione di JUnit che indica a Spring di avviare un contesto di test completo

@SpringBootTest
public class ConfigMenuTest {

    @Test
    @DisplayName("Test di creazione bean menu")
    public void testMenu() {
        Menu m1 = creaMenu();
        assert m1.getNameMenu().equals("Menu pranzo");
        assert m1.getElemntiMenu().size() == 4;
    }

    public Menu creaMenu() {
        Menu m = new Menu();
        m.setNameMenu("Menu pranzo");

        Pizza pizzaMargherita = new Pizza();
        Pizza pizzaPepperoni = new Pizza();
        Drink cola = new Drink();
        Topping olive = new Topping();

        m.setElemntiMenu(List.of(pizzaMargherita, pizzaPepperoni, cola, olive));

        return m;
    }
}


