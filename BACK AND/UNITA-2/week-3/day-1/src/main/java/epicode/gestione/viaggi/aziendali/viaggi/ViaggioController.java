package epicode.gestione.viaggi.aziendali.viaggi;

import epicode.gestione.viaggi.aziendali.CreateGeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController: Questa annotazione indica che la classe che la contiene è un controller REST. Questo significa che la classe è responsabile di gestire le richieste HTTP e di restituire risposte in formato JSON.
//@RequestMapping("/api/Viaggi"): Questa annotazione indica che tutte le richieste HTTP che iniziano con /api/Viaggi saranno gestite da questa classe
//@RequiredArgsConstructor: Questa annotazione, fornita da Lombok, genera un costruttore che accetta come parametri tutti i campi finali e i campi non finali annotati con @NonNull

@RestController
@RequestMapping("/api/viaggi")
@RequiredArgsConstructor
public class ViaggioController {

    private final ViaggioService viaggioService;

    //i vari metodi seguiti dal Mapping si indica che il metodo che la contiene gestisce le richieste HTTP del metodo che viene prima di Mapping
    //inoltre si puo richiedere che un metodo venga seguito da un id come il caso di PutMapping che ha un ID nella URL.
    //@ResponseStatus(HttpStatus.OK): Questa annotazione indica che il metodo restituirà uno status HTTP 200 OK se l'operazione è stata completata con successo, inoltre si puo personalizzare la risposta

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreateGeneralResponse save(@RequestBody @Validated ViaggioRequest body) {

        //@RequestBody: Questa annotazione indica che il corpo della richiesta HTTP deve essere letto come un oggetto AutoreRequest.
        //@Validated: Questa annotazione indica che il corpo della richiesta HTTP deve essere validato.

        return viaggioService.save(body);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Viaggio findById(@PathVariable Long id) {

        //@PathVariable: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.

        return viaggioService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Viaggio modifyById(@PathVariable Long id, @RequestBody ViaggioRequest request) {

        //@RequestBody: Questa annotazione indica che il corpo della richiesta HTTP deve essere letto come un oggetto AutoreRequest.
        //@PathVariable: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.

        return viaggioService.modifyById(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {

        //@PathVariable: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.

        viaggioService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Viaggio> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String sortBy) {

        //@RequestParam: Questa annotazione indica che il parametro verrà preso da un valore presente nella richiesta HTTP.
        //autoreservice.findAll(page, size, sortBy);: Questa riga chiama un'altra funzione chiamata findAll presente in un servizio chiamato autoreservice
        //passando alla funzione i valori di default per page (pagina iniziale 0), size (dimensione per pagina con il valore di default a 10) e sortBy (il valore di id che verra usato l'ordinamento dei dati)

        return viaggioService.findAll(page, size, sortBy);
    }
}