package epicode.blog.blog;

import epicode.blog.CreateGeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    //metodo per trovare tutti gli post
    public List<Post> findAll() {

        return postRepository.findAll();
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

    //metodo per cancellare un post
    public void delete(Long id) {

        Post post = findById(id);
        postRepository.deleteById(id);
    }
}
