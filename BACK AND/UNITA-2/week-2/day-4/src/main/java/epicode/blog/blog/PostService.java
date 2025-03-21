package epicode.blog.blog;

import epicode.blog.CreateGeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    //final poiche le classi non devono essere cambiate in questa classe, inoltre la classe repository serve per avere i campi della classe Dipendente mentre faker per avere dati fitizzi riguardanti l'area geografica specificata nella classe

    private final PostRepository postRepository;

    //Value tramite questa annotazione prendo i valori che stanno nelle properties

    @Value("${messages.new.autore.subject}")
    private String newAutoreSubject;

    @Value("${messages.new.autore.body}")
    private String newAutoreBody;

    //metodo per inserire un post
    public CreateGeneralResponse save(PostRequest postRequest) {

        Post post = new Post();

        //come si vede sotto ci sono due modi, o scrivo una ad una le proprieta che mi servono
        //oppure utilizzo BeanUtils.copyProperties(postRequest, p);
        //il quale mi permette di copiare tutte le proprieta che voglio modificare

        //p.setCategoria(postRequest.getCategoria());
        //p.setTitolo(postRequest.getTitolo());
        //p.setCover(postRequest.getCover());
        //p.setContenuto(postRequest.getContenuto());
        //p.setTempoDiLetturaMinuti(postRequest.getTempoDiLetturaMinuti());

        BeanUtils.copyProperties(postRequest, post);
        postRepository.save(post);

        CreateGeneralResponse response = new CreateGeneralResponse();
        BeanUtils.copyProperties(post, response);

        return response;
    }

    //metodo per trovare un post per id
    public Post findById(Long id) {

        return postRepository.findById(id).get();
    }

    //metodo per modificare un post
        public Post modify(Long id, PostRequest postRequest) {

        Post p = postRepository.findById(id).orElse(null);

        //come si vede sotto ci sono due modi, o scrivo una ad una le proprieta che mi servono
        //oppure utilizzo BeanUtils.copyProperties(postRequest, p);
        //il quale mi permette di copiare tutte le proprieta che voglio modificare

        //p.setCategoria(postRequest.getCategoria());
        //p.setTitolo(postRequest.getTitolo());
        //p.setCover(postRequest.getCover());
        //p.setContenuto(postRequest.getContenuto());
        //p.setTempoDiLetturaMinuti(postRequest.getTempoDiLetturaMinuti());

        BeanUtils.copyProperties(postRequest, p);
        postRepository.save(p);
        return p;
    }

    //metodo per cancellare un post
    public void delete(Long id) {

        Post post = findById(id);
        postRepository.deleteById(id);
    }

    //metodo per trovare tutti gli post
    public Page<Post> findAll(int page, int size, String sort) {

        //Page<Autore>: indica che la funzione restituirà un oggetto Page contenente una lista di oggetti Autore.
        //page: l'indice della pagina da recuperare (a partire da 0).
        //size: il numero di elementi per pagina.
        //sort: il campo da usare per ordinare i risultati (ad esempio, "nome" o "dataDiNascita").

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        //Pageable pageable = PageRequest.of(page, size, Sort.by(sort));: Questa riga crea un oggetto Pageable che contiene le informazioni su come recuperare i dati dalla pagina.
        //PageRequest.of(page, size, Sort.by(sort)): crea un nuovo oggetto PageRequest che specifica la pagina, la dimensione e l'ordinamento dei dati.

        return postRepository.findAll(pageable);
    }
}
