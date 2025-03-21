package epicode.blog.blog;


import epicode.blog.CreateGeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController: Questa annotazione indica che la classe che la contiene è un controller REST. Questo significa che la classe è responsabile di gestire le richieste HTTP e di restituire risposte in formato JSON.
//@RequestMapping("/api/autore"): Questa annotazione indica che tutte le richieste HTTP che iniziano con /api/autore saranno gestite da questa classe
//@RequiredArgsConstructor: Questa annotazione, fornita da Lombok, genera un costruttore che accetta come parametri tutti i campi finali e i campi non finali annotati con @NonNull

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //i vari metodi seguiti dal Mapping si indica che il metodo che la contiene gestisce le richieste HTTP del metodo che viene prima di Mapping
    //inoltre si puo richiedere che un metodo venga seguito da un id come il caso di PutMapping che ha un ID nella URL.
    //@ResponseStatus(HttpStatus.OK): Questa annotazione indica che il metodo restituirà uno status HTTP 200 OK se l'operazione è stata completata con successo, inoltre si puo personalizzare la risposta

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreateGeneralResponse save(@RequestBody PostRequest request) {
        return postService.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post modify(@PathVariable Long id, @RequestBody PostRequest request) {
        return postService.modify(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
