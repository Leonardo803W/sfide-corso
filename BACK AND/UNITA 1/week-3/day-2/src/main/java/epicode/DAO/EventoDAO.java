package epicode.DAO;

import epicode.entitys.Evento;

public interface EventoDAO {

    void save(Evento evento);

    Evento getById(Long id);

    void delete(Evento evento);
}
