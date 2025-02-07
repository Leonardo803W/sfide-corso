package epicode.pizzeria.bevande;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDrink {

    @Bean
    public Drink aranciata() {
        Drink d = new Drink();
        d.setName("Aranciata");
        d.setCalorie(20);
        d.setPrice(3.99);
        return d;
    }

    @Bean
    public Drink cocacola() {
        Drink d = new Drink();
        d.setName("Coca cola");
        d.setCalorie(100);
        d.setPrice(4.99);
        return d;
    }
}
