package epicode.blog.autori;

import epicode.blog.general_responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autore")
@RequiredArgsConstructor
public class AutoreController {

    private final AutoreService autoreservice;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Autore> findAll() {
        return autoreservice.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore findById(@PathVariable Long id) {
        return autoreservice.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody AutoreRequest request) {
        return autoreservice.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore modify(@PathVariable Long id, @RequestBody AutoreRequest request) {
        return autoreservice.modify(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        autoreservice.delete(id);
    }
}
