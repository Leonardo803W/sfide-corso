package epicode.pizzeria.pizze;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuration contiene informazioni per configurare un ogetto e indico che se lo gestisce automaticamente il framework
//bean e una classe che crea direttamente le istanze per poter ritornare un nuovo ogetto e necessita della notazione @configuration

@Configuration
public class ConfigPizze {

    @Bean
    public Pizza pizzaMargherita() {
        Pizza p = new Pizza();
        p.setName("Margherita");
        p.setCalories(300);
        p.setPrice(8.99);
        p.toString();
        return p;
    }

    @Bean
    public Pizza pizzaSalame() {
        Pizza p = new Pizza();
        p.setName("Salame");
        p.setCalories(250);
        p.setPrice(9.99);
        return p;
    }

    @Bean
    public Pizza pizzaFunghi() {
        Pizza p = new Pizza();
        p.setName("Funghi");
        p.setCalories(350);
        p.setPrice(10.99);
        return p;
    }
}
