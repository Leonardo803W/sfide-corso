package epicode.pizzeria.confTest;

import epicode.pizzeria.bevande.Drink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@SpringBootTest è un'annotazione di JUnit che indica a Spring di avviare un contesto di test completo

@SpringBootTest
public class ConfigDrinkTest {

    //@Test è l'annotazione di JUnit che indica che il metodo annotato è un test.
    //@DisplayName("Test di creazione bean topping") è un'annotazione di JUnit che fornisce un nome descrittivo al test. Questo nome verrà visualizzato nei report dei test.

    @Test
    @DisplayName("Test di creazione bean topping")
    public void testDrink(){
        Drink d1 = aranciata();
        Drink d2 = cocacola();

        //assert: Questa parola chiave in Java indica un'asserzione. Un'asserzione è una dichiarazione che il programmatore considera vera. Se l'asserzione è falsa, il programma termina con un'eccezione.

        assert d1.getName().equals("Aranciata");
        assert d1.getCalories() == 20;
        assert d1.getPrice() == 3.99;

        assert d2.getName().equals("Coca cola");
        assert d2.getCalories() == 100;
        assert d2.getPrice() == 4.99;
    }
        public Drink aranciata() {
            Drink d = new Drink();
            d.setName("Aranciata");
            d.setCalories(20);
            d.setPrice(3.99);
            return d;
        }

        public Drink cocacola() {
            Drink d = new Drink();
            d.setName("Coca cola");
            d.setCalories(100);
            d.setPrice(4.99);
            return d;
        }
    }


