package epicode.pizzeria.menu;

import epicode.pizzeria.aggiunte.Topping;
import epicode.pizzeria.bevande.Drink;
import epicode.pizzeria.pizze.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//configuration contiene informazioni per configurare un ogetto e indico che se lo gestisce automaticamente il framework
//RequiredArgsConstructor data dalla dipendenza di Lombok genera automaticamente un costruttore che accetta come parametri tutte le variabili di istanza final e quelle che sono non nulle (annotate con @NonNull).

@Configuration
@RequiredArgsConstructor
public class ConfigMenu {

    //configuration contiene informazioni per configurare un ogetto e indico che se lo gestisce automaticamente il framework
    //bean e una classe che crea direttamente le istanze per poter ritornare un nuovo ogetto e necessita della notazione @configuration
    //non vi e piu @Autowired per il fatto che con final sto dicendo che una volta configurate non potranno essere piu modificate
    //cio non vuol dire essere obbligati a utilizzare uno o l'altro

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
