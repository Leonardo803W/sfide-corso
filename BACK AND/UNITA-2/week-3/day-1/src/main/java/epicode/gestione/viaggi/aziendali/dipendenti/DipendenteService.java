package epicode.gestione.viaggi.aziendali.dipendenti;

import epicode.gestione.viaggi.aziendali.CreateGeneralResponse;
import epicode.gestione.viaggi.aziendali.mail.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
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
public class DipendenteService {

    //final poiche le classi non devono essere cambiate in questa classe
    //AutoreRepository: è il tipo di dato della variabile, presumibilmente un'interfaccia o una classe che definisce i metodi per l'accesso ai dati della tabella Autore in un database.
    //EmailService: è il tipo di dato della variabile, presumibilmente un'interfaccia o una classe che definisce i metodi per l'invio di email.

    private final DipendenteRepository dipendenteRepository;
    private final EmailService emailService;

    //Value tramite questa annotazione prendo i valori che stanno nelle properties

    @Value("${messages.new.dipendente.subject}")
    private String newDipendenteSubject;

    @Value("${messages.new.dipendente.body}")
    private String newDipendenteBody;


    //metodo per inserire un dipendente
    public CreateGeneralResponse save(DipendenteRequest dipendenteRequest) {

        //i due if sono per verificare se l'utente esiste o tramite email o tramite il cognome e nome, metodi personalizzti di AutoreRepository

        /*
        if(autoreRepository.existsByEmail(dipendenteRequest.getEmail())){
            throw new EntityExistsException("Dipendente già esistente");
        }

        if (autoreRepository.existsByNomeAndCognome(dipendenteRequest.getNome(), dipendenteRequest.getCognome())) {
            throw new EntityExistsException("Autore già esistente");
        }
        */

        Dipendente dipendente = new Dipendente();

        //come si vede sotto ci sono due modi, o scrivo una ad una le proprieta che mi servono
        //oppure utilizzo BeanUtils.copyProperties(postRequest, p);
        //il quale mi permette di copiare tutte le proprieta che voglio modificare

        //dipendente.setNome(dipendenteRequest.getNome());
        //dipendente.setCognome(dipendenteRequest.getCognome());
        //dipendente.setEmail(dipendenteRequest.getEmail());
        //dipendente.setDataNascita(dipendenteRequest.getDataNascita());

        BeanUtils.copyProperties(dipendenteRequest, dipendente);
        dipendenteRepository.save(dipendente);

        //CreateGeneralResponse: permette di aggiungere gli id numerici che si vedono nelle chiamate delle api

        CreateGeneralResponse response = new CreateGeneralResponse();
        BeanUtils.copyProperties(dipendente, response);

        //metodo per inviare email, siccome che il metodo sendEmail prevede eccezioni devo utilizzare try catch
        //inoltre il metodo sendEmail prevede come parametri l'indirizzo email, il subject e il body e posso utilizzarli siccome sono metodi personalizzati della classe EmailService

        try {
            emailService.sendEmail(dipendente.getEmail(),newDipendenteSubject);
            emailService.sendEmail(
                    dipendente.getEmail(),newDipendenteSubject, "<h1>"+newDipendenteBody+"</h1><img src='https://res.cloudinary.com/dmc1dmdyo/image/upload/v1739439825/FS0824/paris.jpg.jpg'>"
                            + dipendente.getEmail()) ;
        } catch (Exception e) {

            System.out.println("Errore invio email");
        }

        return response;
    }

    //metodo per modificare un dipendente
    public Dipendente modifyById(Long id, DipendenteRequest dipendenteRequest) {

        Dipendente dipendente = dipendenteRepository.findById(id).orElse(null);

        //come si vede sotto ci sono due modi, o scrivo una ad una le proprieta che mi servono
        //oppure utilizzo BeanUtils.copyProperties(postRequest, p);
        //il quale mi permette di copiare tutte le proprieta che voglio modificare

        //dipendente.setNome(DipendenteRequest.getNome());
        //dipendente.setCognome(DipendenteRequest.getCognome());
        //dipendente.setEmail(DipendenteRequest.getEmail());
        //dipendente.setDataNascita(DipendenteRequest.getDataNascita());

        BeanUtils.copyProperties(dipendenteRequest, dipendente);
        dipendenteRepository.save(dipendente);
        return dipendente;
    }

    //metodo per trovare un dipendente per id
    public Dipendente findById(Long id) {

        return dipendenteRepository.findById(id).get();
    }

    //metodo per cancellare un dipendente
    public void deleteById(Long id) {

        Dipendente dipendente = findById(id);
        dipendenteRepository.deleteById(id);
    }

    //metodo per trovare tutti gli autori
    public Page<Dipendente> findAll(int page, int size, String sort) {

        //Page<Autore>: indica che la funzione restituirà un oggetto Page contenente una lista di oggetti Autore.
        //page: l'indice della pagina da recuperare (a partire da 0).
        //size: il numero di elementi per pagina.
        //sort: il campo da usare per ordinare i risultati (ad esempio, "nome" o "dataDiNascita").

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        //Pageable pageable = PageRequest.of(page, size, Sort.by(sort));: Questa riga crea un oggetto Pageable che contiene le informazioni su come recuperare i dati dalla pagina.
        //PageRequest.of(page, size, Sort.by(sort)): crea un nuovo oggetto PageRequest che specifica la pagina, la dimensione e l'ordinamento dei dati.

        return dipendenteRepository.findAll(pageable);
    }
}
