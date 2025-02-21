package org.example.Dao;

import org.example.eventi.Evento;
import org.example.partecipazioni.Partecipazione;

public interface PartecipazioneDao {

    //metodo per il salvataggio
    void save (Partecipazione partecipazione);

    //metodo per recuperare un evento by id
    Partecipazione getById(Long id);

    //metodo per cancellare un entità Evento
    void deleteById(Long id);

}
