package epicode.pizzeria.confTest;

import epicode.pizzeria.pizze.Pizza;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@SpringBootTest è un'annotazione di JUnit che indica a Spring di avviare un contesto di test completo

@SpringBootTest
public class ConfigPizzeTest {

    @Test
    @DisplayName("Test di creazione bean pizze")
    public void testPizze() {
        Pizza p1 = pizzaMargherita();
        Pizza p2 = pizzaSalame();
        Pizza p3 = pizzaFunghi();

        //assert: Questa parola chiave in Java indica un'asserzione. Un'asserzione è una dichiarazione che il programmatore considera vera. Se l'asserzione è falsa, il programma termina con un'eccezione.

        assert p1.getName().equals("Margherita");
        assert p1.getCalories() == 300;
        assert p1.getPrice() == 8.99;

        assert p2.getName().equals("Salame");
        assert p2.getCalories() == 250;
        assert p2.getPrice() == 9.99;

        assert p3.getName().equals("Funghi");
        assert p3.getCalories() == 350;
        assert p3.getPrice() == 10.99;
    }

        public Pizza pizzaMargherita() {
            Pizza p = new Pizza();
            p.setName("Margherita");
            p.setCalories(300);
            p.setPrice(8.99);
            p.toString();
            return p;
        }


        public Pizza pizzaSalame() {
            Pizza p = new Pizza();
            p.setName("Salame");
            p.setCalories(250);
            p.setPrice(9.99);
            return p;
        }

        public Pizza pizzaFunghi() {
            Pizza p = new Pizza();
            p.setName("Funghi");
            p.setCalories(350);
            p.setPrice(10.99);
            return p;
        }
    }


