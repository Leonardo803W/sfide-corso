package epicode.blog.autori;


import epicode.blog.CreateGeneralResponse;
import epicode.blog.email.EmailService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AutoreService {

    //final poiche le classi non devono essere cambiate in questa classe
    //AutoreRepository: è il tipo di dato della variabile, presumibilmente un'interfaccia o una classe che definisce i metodi per l'accesso ai dati della tabella Autore in un database.
    //EmailService: è il tipo di dato della variabile, presumibilmente un'interfaccia o una classe che definisce i metodi per l'invio di email.

    private final EmailService emailService;
    private final AutoreRepository autoreRepository;

    //Value tramite questa annotazione prendo i valori che stanno nelle properties

    @Value("${messages.new.autore.subject}")
    private String newAutoreSubject;

    @Value("${messages.new.autore.body}")
    private String newAutoreBody;

    //metodo per inserire un autore
    public CreateGeneralResponse save(AutoreRequest autoreRequest) {

        //i due if sono per verificare se l'utente esiste o tramite email o tramite il cognome e nome, metodi personalizzti di AutoreRepository

        /*
        if(autoreRepository.existsByEmail(autoreRequest.getEmail())){
            throw new EntityExistsException("Dipendente già esistente");
        }

        if (autoreRepository.existsByNomeAndCognome(autoreRequest.getNome(), autoreRequest.getCognome())) {
            throw new EntityExistsException("Autore già esistente");
        }
        */

        Autore autore = new Autore();

        //come si vede sotto ci sono due modi, o scrivo una ad una le proprieta che mi servono
        //oppure utilizzo BeanUtils.copyProperties(postRequest, p);
        //il quale mi permette di copiare tutte le proprieta che voglio modificare

        //autore.setNome(autoreRequest.getNome());
        //autore.setCognome(autoreRequest.getCognome());
        //autore.setEmail(autoreRequest.getEmail());
        //autore.setDataNascita(autoreRequest.getDataNascita());

        BeanUtils.copyProperties(autoreRequest, autore);
        autoreRepository.save(autore);

        //CreateGeneralResponse: permette di aggiungere gli id numerici che si vedono nelle chiamate delle api

        CreateGeneralResponse response = new CreateGeneralResponse();
        BeanUtils.copyProperties(autore, response);

        //metodo per inviare email, siccome che il metodo sendEmail prevede eccezioni devo utilizzare try catch
        //inoltre il metodo sendEmail prevede come parametri l'indirizzo email, il subject e il body e posso utilizzarli siccome sono metodi personalizzati della classe EmailService

        try {
            emailService.sendEmail(autore.getEmail(),newAutoreSubject);
            emailService.sendEmail(
                    autore.getEmail(),newAutoreSubject, "<h1>"+newAutoreBody+"</h1><img src='https://res.cloudinary.com/dmc1dmdyo/image/upload/v1739439825/FS0824/paris.jpg.jpg'>"
                            +autore.getEmail()) ;
        } catch (Exception e) {

            System.out.println("Errore invio email");
        }

        return response;
    }

    //metodo per modificare un autore
    public Autore modify(Long id, AutoreRequest autoreRequest) {

        Autore autore = autoreRepository.findById(id).orElse(null);

        //come si vede sotto ci sono due modi, o scrivo una ad una le proprieta che mi servono
        //oppure utilizzo BeanUtils.copyProperties(postRequest, p);
        //il quale mi permette di copiare tutte le proprieta che voglio modificare

        //autore.setNome(autoreRequest.getNome());
        //autore.setCognome(autoreRequest.getCognome());
        //autore.setEmail(autoreRequest.getEmail());
        //autore.setDataNascita(autoreRequest.getDataNascita());

        BeanUtils.copyProperties(autoreRequest, autore);
        autoreRepository.save(autore);
        return autore;
    }

    //metodo per trovare un autore per id
    public Autore findById(Long id) {

        return autoreRepository.findById(id).get();
    }

    //metodo per cancellare un autore
    public void delete(Long id) {

        Autore autore = findById(id);
        autoreRepository.deleteById(id);
    }

    //metodo per trovare tutti gli autori
    public Page<Autore> findAll(int page, int size, String sort) {

        //Page<Autore>: indica che la funzione restituirà un oggetto Page contenente una lista di oggetti Autore.
        //page: l'indice della pagina da recuperare (a partire da 0).
        //size: il numero di elementi per pagina.
        //sort: il campo da usare per ordinare i risultati (ad esempio, "nome" o "dataDiNascita").

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        //Pageable pageable = PageRequest.of(page, size, Sort.by(sort));: Questa riga crea un oggetto Pageable che contiene le informazioni su come recuperare i dati dalla pagina.
        //PageRequest.of(page, size, Sort.by(sort)): crea un nuovo oggetto PageRequest che specifica la pagina, la dimensione e l'ordinamento dei dati.

        return autoreRepository.findAll(pageable);
    }
}
