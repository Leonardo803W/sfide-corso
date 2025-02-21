package org.example.Dao;

import org.example.eventi.Evento;
import org.example.locations.Location;

public interface LocationDao {

    //metodo per il salvataggio
    void save (Location location);

    //metodo per recuperare un evento by id
    Location getById(Long id);

    //metodo per cancellare un entità Evento
    void deleteById(Long id);

}
