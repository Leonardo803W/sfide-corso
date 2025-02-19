package epicode.pizzeria.runner;

import epicode.pizzeria.tavoli.StatoTavolo;
import epicode.pizzeria.tavoli.Tavolo;
import epicode.pizzeria.menu.Menu;
import epicode.pizzeria.ordini.Ordine;
import epicode.pizzeria.ordini.StatoOrdine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//senza l'annotazione spring non riconoscerebbe la classe e quindi non la manderebbe in esecuzione
//in questa classe faccio la stampa effettiva del menu

//per farla funzionare inoltre devo sempre implementare l'interfaccia di CommandLineRunner e implementare il suo metodo.

@Component
public class ApplicationRunner implements CommandLineRunner {

    //questo e il bean che mi serve per accedere al menu
    //inoltre con @Autowired faccio l'injection (ovvero se la va a caricare nel configuration appositamente creato

    @Autowired
    private Menu menuPranzo;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(menuPranzo);

        Tavolo tavolo = new Tavolo();
        tavolo.setNumber(1);
        tavolo.setMaxCapacity(5);
        tavolo.setStatoTavolo(StatoTavolo.OCCUPATO);

        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(1);
        ordine.setTavolo(tavolo);
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setNumeroCoperti(2);
        ordine.setElementiOrdine(List.of(
                menuPranzo.getElemntiMenu().get(1),
                menuPranzo.getElemntiMenu().get(2),
                menuPranzo.getElemntiMenu().get(3))
        );
        ordine.stampaOrdine();
    }
}
