package epicode.pizzeria.aggiunte;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigTopping {

    @Bean
    public Topping formaggio() {
        Topping t = new Topping();
        t.setNome("Abbondante formaggio");
        t.setCalorie(40);
        t.setPrice(1.99);
        return t;
    }

    @Bean
    public Topping salame() {
        Topping t = new Topping();
        t.setNome("Abbondante salame");
        t.setCalorie(20);
        t.setPrice(2.99);
        return t;
    }
}
