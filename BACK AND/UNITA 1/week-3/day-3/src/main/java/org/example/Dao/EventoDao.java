package org.example.Dao;

import org.example.eventi.Evento;

import java.util.List;

public interface EventoDao {

    //metodo per il salvataggio
    void save (Evento evento);

    //metodo per recuperare un evento by id
    Evento getById(Long id);

    //metodo per cancellare un entità Evento
    void deleteById(Long id);

}
