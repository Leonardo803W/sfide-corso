package epicode.pizzeria.bevande;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuration contiene informazioni per configurare un ogetto e indico che se lo gestisce automaticamente il framework
//bean e una classe che crea direttamente le istanze per poter ritornare un nuovo ogetto e necessita della notazione @configuration

@Configuration
public class ConfigDrink {

    @Bean
    public Drink aranciata() {
        Drink d = new Drink();
        d.setName("Aranciata");
        d.setCalories(20);
        d.setPrice(3.99);
        return d;
    }

    @Bean
    public Drink cocacola() {
        Drink d = new Drink();
        d.setName("Coca cola");
        d.setCalories(100);
        d.setPrice(4.99);
        return d;
    }
}
