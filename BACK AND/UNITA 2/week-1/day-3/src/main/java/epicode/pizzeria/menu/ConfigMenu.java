package epicode.pizzeria.menu;

import epicode.pizzeria.aggiunte.Topping;
import epicode.pizzeria.bevande.Drink;
import epicode.pizzeria.pizze.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ConfigMenu {

    private final Drink aranciata;
    private final Drink cocacola;
    private final Pizza pizzaMargherita;
    private final Pizza pizzaFunghi;
    private final Pizza pizzaSalame;
    private final Topping formaggio;
    private final Topping salame;

    @Bean
    public Menu creaMenu() {

        //a differenza della versione precedente, tolgo i vari add o set poiche metto tutto in un unico
        // metodo i vari bean (ovvero le varie istanza)

        Menu m = new Menu();
        m.setNomeMenu("Menu pranzo");
        m.setElemntiMenu(List.of(aranciata, cocacola, pizzaMargherita, pizzaFunghi, pizzaSalame, formaggio, salame));
        return m;
    }
}
