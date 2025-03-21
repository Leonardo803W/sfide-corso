package epicode.gestione.viaggi.aziendali.viaggi;

import epicode.gestione.viaggi.aziendali.CreateGeneralResponse;
import epicode.gestione.viaggi.aziendali.dipendenti.Dipendente;
import epicode.gestione.viaggi.aziendali.dipendenti.DipendenteRepository;
import epicode.gestione.viaggi.aziendali.dipendenti.DipendenteRequest;
import epicode.gestione.viaggi.aziendali.mail.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

//@Service: Questa annotazione indica che la classe a cui è applicata è un servizio in un'architettura Spring.
// Un servizio è un componente che fornisce funzionalità specifiche all'interno di un'applicazione.

//@RequiredArgsConstructor: Questa annotazione di Lombok è un modo conciso per generare automaticamente un costruttore che inizializza tutti i campi finali e obbligatori.
//In altre parole, questa annotazione ti aiuta a creare un costruttore senza doverlo scrivere manualmente.

//@Validated: Questa annotazione indica che la classe o il metodo a cui è applicata deve essere validata prima dell'esecuzione.
//La validazione viene eseguita utilizzando le regole di convalida definite tramite annotazioni come @NotNull, @NotBlank, @Size, ecc.

@Service
@RequiredArgsConstructor
@Validated
public class ViaggioService {

    //final poiche le classi non devono essere cambiate in questa classe
    //viaggioRepository: il tipo di dato della variabile, presumibilmente un'interfaccia o una classe che definisce i metodi per la gestione dei viaggi.
    //EmailService: è il tipo di dato della variabile, presumibilmente un'interfaccia o una classe che definisce i metodi per l'invio di email.

    private final EmailService emailService;
    private final ViaggioRepository viaggioRepository;

    //metodo per inserire un viaggio
    public CreateGeneralResponse save(ViaggioRequest viaggioRequest) {

        Viaggio viaggio = new Viaggio();

        //come si vede sotto ci sono due modi, o scrivo una ad una le proprieta che mi servono
        //oppure utilizzo BeanUtils.copyProperties(postRequest, p);
        //il quale mi permette di copiare tutte le proprieta che voglio modificare

        //viaggio.setNome(ViaggioRequest.getNome());
        //viaggio.setCognome(ViaggioRequest.getCognome());
        //viaggio.setEmail(ViaggioRequest.getEmail());
        //viaggio.setDataNascita(ViaggioRequest.getDataNascita());

        BeanUtils.copyProperties(viaggioRequest, viaggio);
        viaggioRepository.save(viaggio);

        //CreateGeneralResponse: permette di aggiungere gli id numerici che si vedono nelle chiamate delle api

        CreateGeneralResponse response = new CreateGeneralResponse();
        BeanUtils.copyProperties(viaggio, response);

        return response;
    }

    //metodo per modificare un viaggio
    public Viaggio modifyById(Long id, ViaggioRequest viaggioRequest) {

        Viaggio viaggio = viaggioRepository.findById(id).orElse(null);

        //come si vede sotto ci sono due modi, o scrivo una ad una le proprieta che mi servono
        //oppure utilizzo BeanUtils.copyProperties(postRequest, p);
        //il quale mi permette di copiare tutte le proprieta che voglio modificare

        //viaggio.setNome(ViaggioRequest.getNome());
        //viaggio.setCognome(ViaggioRequest.getCognome());
        //viaggio.setEmail(ViaggioRequest.getEmail());
        //viaggio.setDataNascita(ViaggioRequest.getDataNascita());

        BeanUtils.copyProperties(viaggioRequest, viaggio);
        viaggioRepository.save(viaggio);
        return viaggio;
    }

    //metodo per trovare un viaggio per id
    public Viaggio findById(Long id) {

        return viaggioRepository.findById(id).get();
    }

    //metodo per cancellare un viaggio
    public void deleteById(Long id) {

        Viaggio viaggio = findById(id);
        viaggioRepository.deleteById(id);
    }

    //metodo per trovare tutti i viaggio
    public Page<Viaggio> findAll(int page, int size, String sort) {

        //Page<Autore>: indica che la funzione restituirà un oggetto Page contenente una lista di oggetti Autore.
        //page: l'indice della pagina da recuperare (a partire da 0).
        //size: il numero di elementi per pagina.
        //sort: il campo da usare per ordinare i risultati (ad esempio, "nome" o "dataDiNascita").

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        //Pageable pageable = PageRequest.of(page, size, Sort.by(sort));: Questa riga crea un oggetto Pageable che contiene le informazioni su come recuperare i dati dalla pagina.
        //PageRequest.of(page, size, Sort.by(sort)): crea un nuovo oggetto PageRequest che specifica la pagina, la dimensione e l'ordinamento dei dati.

        return viaggioRepository.findAll(pageable);
    }
}