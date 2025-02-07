package epicode.pizzeria.pizze;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigPizze {

    @Bean
    public Pizza pizzaMargherita() {
        Pizza p = new Pizza();
        p.setName("Margherita");
        p.setCalorie(300);
        p.setPrice(8.99);
        return p;
    }

    @Bean
    public Pizza pizzaSalame() {
        Pizza p = new Pizza();
        p.setName("Salame");
        p.setCalorie(250);
        p.setPrice(9.99);
        return p;
    }

    @Bean
    public Pizza pizzaFunghi() {
        Pizza p = new Pizza();
        p.setName("Funghi");
        p.setCalorie(350);
        p.setPrice(10.99);
        return p;
    }
}
