package epicode.blog.autori;

import epicode.blog.CreateGeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoreService {

    private final AutoreRepository autoreRepository;

    //metodo per trovare tutti gli autori
    public List<Autore> findAll() {

        return autoreRepository.findAll();
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
