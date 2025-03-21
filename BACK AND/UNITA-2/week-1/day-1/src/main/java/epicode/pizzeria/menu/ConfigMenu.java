package epicode.pizzeria.menu;

import epicode.pizzeria.aggiunte.Topping;
import epicode.pizzeria.bevande.Drink;
import epicode.pizzeria.pizze.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

//configuration contiene informazioni per configurare un ogetto e indico che se lo gestisce automaticamente il framework
//bean e una classe che crea direttamente le istanze per poter ritornare un nuovo ogetto e necessita della notazione @configuration
//inoltre con @Autowired faccio l'injection (ovvero se la va a caricare nel configuration appositamente creato

@Configuration
public class ConfigMenu {

    @Autowired
    private Drink aranciata;
    @Autowired
    private Drink cocacola;

    @Autowired
    private Pizza pizzaMargherita;
    @Autowired
    private Pizza pizzaFunghi;
    @Autowired
    private Pizza pizzaSalame;

    @Autowired
    private Topping formaggio;
    @Autowired
    private Topping salame;

    @Bean
    public Menu menu() {

        //primo modo per aggiungere i bean nelle altre config
        //si prende l'ogetto e fare add per via che e una array List

        Menu m = new Menu ();
        m.setNome("Menu pranzo");
        m.getBevande().add(aranciata);
        m.getBevande().add(cocacola);

        m.getPizze().add(pizzaMargherita);
        m.getPizze().add(pizzaFunghi);
        m.getPizze().add(pizzaSalame);

        //secondo modo per aggiungere i bean nelle altre config
        //si associa direttamente tutta la lista, ma se lo utilizzo e inutile inizializzare una array List nell'ogetto stesso.

        m.setAggiunte(List.of(formaggio, salame));

        return m;
    }
}
