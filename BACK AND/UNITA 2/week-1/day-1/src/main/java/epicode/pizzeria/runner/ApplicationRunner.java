package epicode.pizzeria.runner;

import epicode.pizzeria.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//senza l'annotazione spring non riconoscerebbe la classe e quindi non la manderebbe in esecuzione
//in questa classe faccio la stampa effettiva del menu

//per farla funzionare inoltre devo sempre implementare l'interfaccia di CommandLineRunner e implementare il suo metodo.

@Component
public class ApplicationRunner implements CommandLineRunner {

    //questo e il bean che mi serve per accedere al menu
    //inoltre con @Autowired faccio l'injection (ovvero se la va a caricare nel configuration appositamente creato

    @Autowired
    private Menu menu;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(menu);
    }
}
