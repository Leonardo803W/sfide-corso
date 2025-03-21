package epicode.gestione.viaggi.aziendali.viaggi;

import com.github.javafaker.Faker;
import epicode.gestione.viaggi.aziendali.dipendenti.Dipendente;
import epicode.gestione.viaggi.aziendali.dipendenti.DipendenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
//component specifica che tale classe la gestira automaticamente e soltanto il fremwork, ovvero spring
//RequiredArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe. In questo caso, inizializza aziendaRepository e faker
//Questa interfaccia indica che la classe verrà eseguita quando l'applicazione Spring viene avviata. Il metodo run() verrà chiamato automaticamente

@Component
@RequiredArgsConstructor
public class ViaggioRunner implements CommandLineRunner {


    //final poiche le classi non devono essere cambiate in questa classe,
    //]inoltre la classe repository serve per avere i campi della classe Dipendente mentre faker per avere dati fitizzi riguardanti l'area geografica specificata nella classe

    private final DipendenteRepository dipendenteRepository;
    private final ViaggioRepository viaggioRepository;
    private final Faker faker;

    //in questo modo non solo gestisco eventuiali errori ma genero in automatico tuti i dipendenti che voglio

    @Override
    public void run(String... args) throws Exception {

        List<Dipendente> dipendenti = dipendenteRepository.findAll();

        if (dipendenti.isEmpty()) {
            System.out.println("Nessun dipendente trovato nel database.");
            return;
        }

        for (int i = 0; i < 15; i++) {
            Viaggio viaggio = new Viaggio();
            viaggio.setDestinazione(faker.address().city());
            viaggio.setDataViaggio(faker.date().future(10, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            viaggio.setStatoViaggio(StatoViaggio.COMPLETATO);
            Dipendente dipendente = dipendenti.get(new Random().nextInt(dipendenti.size()));
            viaggio.setDipendente(dipendente); // Imposta il dipendente
            viaggioRepository.save(viaggio);
        }
    }
}

 */