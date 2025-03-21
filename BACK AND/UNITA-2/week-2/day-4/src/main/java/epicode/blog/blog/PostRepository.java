package epicode.blog.blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {

    //possibile aggiungere metodi personalizzati, mentre con JpaRepository sono gia presenti metodi come il save, delete ed altri

}
