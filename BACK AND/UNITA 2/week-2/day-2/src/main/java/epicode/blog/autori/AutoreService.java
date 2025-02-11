package epicode.blog.autori;

import epicode.blog.general_responses.CreateResponse;
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
        //autore.setNome(autoreRequest.getNome());
        //autore.setCognome(autoreRequest.getCognome());
        //autore.setEmail(autoreRequest.getEmail());
        //autore.setDataNascita(autoreRequest.getDataNascita());
        BeanUtils.copyProperties(autoreRequest, autore);
        autoreRepository.save(autore);
        return autore;
    }

    //metodo per inserire un dipendente
    public CreateResponse save(AutoreRequest autoreRequest) {

        Autore autore = new Autore();
        BeanUtils.copyProperties(autoreRequest, autore);
        autoreRepository.save(autore);

        CreateResponse response = new CreateResponse();
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
