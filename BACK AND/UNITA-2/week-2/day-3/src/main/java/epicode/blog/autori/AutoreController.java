package epicode.blog.autori;

import epicode.blog.CreateGeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController: Questa annotazione indica che la classe che la contiene è un controller REST. Questo significa che la classe è responsabile di gestire le richieste HTTP e di restituire risposte in formato JSON.
//@RequestMapping("/api/autore"): Questa annotazione indica che tutte le richieste HTTP che iniziano con /api/autore saranno gestite da questa classe
//@RequiredArgsConstructor: Questa annotazione, fornita da Lombok, genera un costruttore che accetta come parametri tutti i campi finali e i campi non finali annotati con @NonNull

@RestController
@RequestMapping("/api/autore")
@RequiredArgsConstructor
public class AutoreController {

    private final AutoreService autoreservice;

    //i vari metodi seguiti dal Mapping si indica che il metodo che la contiene gestisce le richieste HTTP del metodo che viene prima di Mapping
    //inoltre si puo richiedere che un metodo venga seguito da un id come il caso di PutMapping che ha un ID nella URL.
    //@ResponseStatus(HttpStatus.OK): Questa annotazione indica che il metodo restituirà uno status HTTP 200 OK se l'operazione è stata completata con successo, inoltre si puo personalizzare la risposta

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Autore> findAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(defaultValue = "id") String sortBy) {

        //@RequestParam: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.
        //autoreservice.findAll(page, size, sortBy);: Questa riga chiama un'altra funzione chiamata findAll presente in un servizio chiamato autoreservice
        //passando alla funzione i valori di default per page (pagina iniziale 0), size (dimensione per pagina con il valore di default a 10) e sortBy (il valore di id che verra usato l'ordinamento dei dati)

        return autoreservice.findAll(page, size, sortBy);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore findById(@PathVariable Long id) {
        return autoreservice.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreateGeneralResponse save(@RequestBody AutoreRequest request) {
        return autoreservice.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore modify(@PathVariable Long id, @RequestBody AutoreRequest request) {
        return autoreservice.modify(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        autoreservice.delete(id);
    }
}
