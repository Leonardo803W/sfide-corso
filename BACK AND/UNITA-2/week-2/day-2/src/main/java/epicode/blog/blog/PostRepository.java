package epicode.blog.blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {

    public Post findByTitolo(String titolo);
    public Post findByCategoria(String categoria);

}
