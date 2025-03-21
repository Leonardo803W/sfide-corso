package epicode.pizzeria.aggiunte;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuration contiene informazioni per configurare un ogetto e indico che se lo gestisce automaticamente il framework
//bean e una classe che crea direttamente le istanze per poter ritornare un nuovo ogetto e necessita della notazione @configuration

@Configuration
public class ConfigTopping {

    @Bean
    public Topping formaggio() {
        Topping t = new Topping();
        t.setName("Abbondante formaggio");
        t.setCalories(40);
        t.setPrice(1.99);
        return t;
    }

    @Bean
    public Topping salame() {
        Topping t = new Topping();
        t.setName("Abbondante salame");
        t.setCalories(20);
        t.setPrice(2.99);
        return t;
    }
}
