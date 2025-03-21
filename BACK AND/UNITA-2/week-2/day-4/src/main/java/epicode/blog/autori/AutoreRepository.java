package epicode.blog.autori;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoreRepository extends JpaRepository<Autore, Long> {

    //aggiunta di metodi personalizzati, mentre con JpaRepository sono gia presenti metodi come il save, delete ed altri

    boolean existsByEmail(String email);
    boolean existsByNomeAndCognome(String nome, String cognome);
}
