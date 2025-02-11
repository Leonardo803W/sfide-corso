package epicode.blog.blog;

import epicode.blog.general_responses.CreateResponse;
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

        Post post = postRepository.findById(id).orElse(null);
        //post.setNome(postRequest.getNome());
        //post.setCognome(postRequest.getCognome());
        //post.setEmail(postRequest.getEmail());
        //post.setDataNascita(postRequest.getDataNascita());
        BeanUtils.copyProperties(postRequest, post);
        postRepository.save(post);
        return post;
    }

    //metodo per inserire un post
    public CreateResponse save(PostRequest postRequest) {

        Post post = new Post();
        BeanUtils.copyProperties(postRequest, post);
        postRepository.save(post);

        CreateResponse response = new CreateResponse();
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
