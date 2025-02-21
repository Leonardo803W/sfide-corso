package org.example;

import org.example.Dao.*;
import org.example.eventi.Evento;
import org.example.eventi.TipoEvento;
import org.example.locations.Location;
import org.example.partecipazioni.Partecipazione;
import org.example.partecipazioni.TipoPartecipazione;
import org.example.persone.Persona;
import org.example.persone.TipoSesso;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate data1 = LocalDate.of(2023, 8, 31);
        LocalDate data2 = LocalDate.of(2023, 9, 1);

        Evento evento1 = new Evento("Notte da leoni", "Preparati alla fine del mondo", data1, TipoEvento.PUBBLICO, 1000);
        Evento evento2 = new Evento("Una notte in museo", "Hai paura dei fantasmi?", today, TipoEvento.PRIVATO, 20);
        Evento evento3 = new Evento("casino", "ti piace scommetter?", today, TipoEvento.PUBBLICO, 500);

        Location location1 = new Location("piazza del popolo", "lecco");

        Persona persona1 = new Persona("bob", "rossi", "bobRossi@gmail.com", TipoSesso.M, data2);

        Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, TipoPartecipazione.CONFERMATO);

        EventoDao eventoDao = new EventoDaoImpl();
        LocationDao locationDao = new LocationDaoImpl();
        PersonaDao personaDao = new PersonaDaoImpl();
        PartecipazioneDao partecipazioneDao = new ParteDaoImpl();

        //eventoDao.save(evento1);
        //eventoDao.save(evento2);
        //eventoDao.save(evento3);

        locationDao.save(location1);
        //personaDao.save(persona1);
        PartecipazioneDao.

        //System.out.println("Persona salvata! ID: " + persona1.getId());
        System.out.println("Location salvata! ID: " + location1.getId());
        //System.out.println("Eventi salvati! ID: " + evento1.getId() + " " + evento2.getId() + " " + evento3.getId());



        //eventoDao.deleteById(evento3.getId());
        //.out.println("Evento eliminato: ");

        //eventoDao.getById(evento1.getId());
        //System.out.println("Evento trovato: ");
    }
}