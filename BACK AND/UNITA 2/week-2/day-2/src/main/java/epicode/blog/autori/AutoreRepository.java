package epicode.blog.autori;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository <Autore, Long> {

    public Autore findByEmail(String email);
    public Autore findByNomeAndCognome(String nome, String cognome);

    public Boolean existsByEmail(String email);
    public Boolean existsByNomeAndCognome(String nome, String cognome);
}
