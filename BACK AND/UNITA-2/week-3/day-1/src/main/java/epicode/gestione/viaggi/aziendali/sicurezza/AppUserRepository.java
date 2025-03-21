package epicode.gestione.viaggi.aziendali.sicurezza;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//utilizzo extends anziche implements poiche la seconda mi obbligerebbe di portare tutti i metodi di JpaRepository dentro alla classe,
//invece extends mi permette tramite questa classe di utilizzare tutti i metodi che voglio di JpaRepository e aggiungere metodi personali piu personalizzati
//invece <Dipendente, Long> specifico con che tipo di entita dovranno essere legati i metodi e anche con che chiave primaria

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    //con questi metodi aggiuntivi posso verificare o cercare un singolo dipendente

    Optional<AppUser> findByUsername(String username);
    boolean existsByUsername(String username);
}