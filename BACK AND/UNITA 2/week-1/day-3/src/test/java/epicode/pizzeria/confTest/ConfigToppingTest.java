package epicode.pizzeria.confTest;

import epicode.pizzeria.aggiunte.Topping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest è un'annotazione di JUnit che indica a Spring di avviare un contesto di test completo

@SpringBootTest
public class ConfigToppingTest {

    //@Test è l'annotazione di JUnit che indica che il metodo annotato è un test.
    //@DisplayName("Test di creazione bean topping") è un'annotazione di JUnit che fornisce un nome descrittivo al test. Questo nome verrà visualizzato nei report dei test.

    @Test
    @DisplayName("Test di creazione bean topping")
    public void testTopping() {
        Topping t1 = formaggio();
        Topping t2 = salame();

        //assert: Questa parola chiave in Java indica un'asserzione. Un'asserzione è una dichiarazione che il programmatore considera vera. Se l'asserzione è falsa, il programma termina con un'eccezione.

        assert t1.getName().equals("Abbondante formaggio");
        assert t1.getCalories() == 40;
        assert t1.getPrice() == 1.99;

        assert t2.getName().equals("Abbondante salame");
        assert t2.getCalories() == 20;
        assert t2.getPrice() == 2.99;
    }

    public Topping formaggio() {
        Topping t = new Topping();
        t.setName("Abbondante formaggio");
        t.setCalories(40);
        t.setPrice(1.99);
        return t;
    }

    public Topping salame() {
        Topping t = new Topping();
        t.setName("Abbondante salame");
        t.setCalories(20);
        t.setPrice(2.99);
        return t;
    }
}