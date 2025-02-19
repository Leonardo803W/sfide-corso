package epicode.pizzeria.ordineTest;

import epicode.pizzeria.aggiunte.Topping;
import epicode.pizzeria.bevande.Drink;
import epicode.pizzeria.menu.ElementoMenu;
import epicode.pizzeria.ordini.Ordine;
import epicode.pizzeria.ordini.StatoOrdine;
import epicode.pizzeria.pizze.Pizza;
import epicode.pizzeria.tavoli.Tavolo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@SpringBootTest è un'annotazione di JUnit che indica a Spring di avviare un contesto di test completo

@SpringBootTest
public class OrdineTest {

    //@Autowired utilizzata per l'iniezione delle dipendenze nei bean

    @Autowired
    private Pizza pizzaMargherita;
    @Autowired
    private Drink aranciata;
    @Autowired
    private Topping salame;

    //@Test è l'annotazione di JUnit che indica che il metodo annotato è un test.
    //@DisplayName("Test di creazione bean topping") è un'annotazione di JUnit che fornisce un nome descrittivo al test. Questo nome verrà visualizzato nei report dei test.

    @Test
    @DisplayName("Test di creazione ordine")
    public void testOrdine() {

        int numeroOrdine = 1;
        Tavolo tavolo = new Tavolo();
        StatoOrdine statoOrdine = StatoOrdine.IN_CORSO;
        int numeroCoperti = 2;
        LocalDateTime oraAcquisizione = LocalDateTime.now();
        List<ElementoMenu> elementiOrdine = List.of(pizzaMargherita, aranciata, salame);

        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(numeroOrdine);
        ordine.setTavolo(tavolo);
        ordine.setStatoOrdine(statoOrdine);
        ordine.setNumeroCoperti(numeroCoperti);
        ordine.setOraAcquisizione(oraAcquisizione);
        ordine.setElementiOrdine(elementiOrdine);

        ordine.stampaOrdine();

        assertNotNull(ordine);
        assertEquals(3, ordine.getElementiOrdine().size());
    }
}
