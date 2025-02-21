package org.example.Dao;

import org.example.eventi.Evento;
import org.example.persone.Persona;

public interface PersonaDao {

    //metodo per il salvataggio
    void save (Persona persona);

    //metodo per recuperare un evento by id
    Persona getById(Long id);

    //metodo per cancellare un entità Evento
    void deleteById(Long id);

}
