package epicode.blog.autori;

import epicode.blog.CreateGeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoreService {

    private final AutoreRepository autoreRepository;

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

    //metodo per inserire un dipendente
    public CreateGeneralResponse save(AutoreRequest autoreRequest) {

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

        CreateGeneralResponse response = new CreateGeneralResponse();
        BeanUtils.copyProperties(autore, response);

        return response;
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
}
