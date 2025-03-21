package epicode.gestione.viaggi.aziendali.dipendenti;

import epicode.gestione.viaggi.aziendali.CreateGeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController: Questa annotazione indica che la classe che la contiene è un controller REST. Questo significa che la classe è responsabile di gestire le richieste HTTP e di restituire risposte in formato JSON.
//@RequestMapping("/api/dipendenti"): Questa annotazione indica che tutte le richieste HTTP che iniziano con /api/dipendenti saranno gestite da questa classe
//@RequiredArgsConstructor: Questa annotazione, fornita da Lombok, genera un costruttore che accetta come parametri tutti i campi finali e i campi non finali annotati con @NonNull

@RestController
@RequestMapping("/api/dipendenti")
@RequiredArgsConstructor
public class DipendenteController {

    //final poiche le classi non devono essere cambiate in questa classe, inoltre la classe repository serve per avere i campi della classe Dipendente mentre faker per avere dati fitizzi riguardanti l'area geografica specificata nella classe

    private final DipendenteService dipendenteService;

    //tutti i metodi avranno alla base dell'url questo: http://localhost:8080/api/dipendenti
    //tutte le annotazione di questa classe prima di Mapping specificano il metodo che verra utilizzato
    //ResponseStatus con questa annotazione posso personalizzare i messaggi di risposta delle api, anziche avere i numeri standard


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreateGeneralResponse save(@RequestBody @Validated DipendenteRequest body) {

        //@RequestBody: Questa annotazione indica che il corpo della richiesta HTTP deve essere letto come un oggetto AutoreRequest.
        //@Validated: Questa annotazione indica che il corpo della richiesta HTTP deve essere validato.

        return dipendenteService.save(body);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente findById(@PathVariable Long id) {

        //@PathVariable: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.

        return dipendenteService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente modifyById(@PathVariable Long id, @RequestBody DipendenteRequest request) {

        //@RequestBody: Questa annotazione indica che il corpo della richiesta HTTP deve essere letto come un oggetto AutoreRequest.
        //@PathVariable: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.

        return dipendenteService.modifyById(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {

        //@PathVariable: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.

        dipendenteService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Dipendente> findAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sortBy) {

        //@RequestParam: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.
        //autoreservice.findAll(page, size, sortBy);: Questa riga chiama un'altra funzione chiamata findAll presente in un servizio chiamato autoreservice
        //passando alla funzione i valori di default per page (pagina iniziale 0), size (dimensione per pagina con il valore di default a 10) e sortBy (il valore di id che verra usato l'ordinamento dei dati)

        return dipendenteService.findAll(page, size, sortBy);
    }
}