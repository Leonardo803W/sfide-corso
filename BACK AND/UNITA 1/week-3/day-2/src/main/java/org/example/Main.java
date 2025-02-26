package org.example;

import org.example.Dao.EventoDao;
import org.example.Dao.EventoDaoImpl;
import org.example.eventi.Evento;
import org.example.eventi.TipoEvento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate data1 = LocalDate.of(2023, 8, 31);

        Evento evento1 = new Evento("Notte da leoni", "Preparati alla fine del mondo", data1, TipoEvento.PUBBLICO, 1000);
        Evento evento2 = new Evento("Una notte in museo", "Hai paura dei fantasmi?", today, TipoEvento.PRIVATO, 20);
        Evento evento3 = new Evento("Una notte in museo", "Hai paura dei fantasmi?", today, TipoEvento.PRIVATO, 20);

        EventoDao eventoDao = new EventoDaoImpl();

        eventoDao.save(evento1);
        //eventoDao.save(evento2);
        //eventoDao.save(evento3);

        //System.out.println("Eventi salvati! ID: " + evento1.getId() + " " + evento2.getId() + " " + evento3.getId());

        //eventoDao.deleteById(evento3.getId());
        //.out.println("Evento eliminato: ");

        //eventoDao.getById(evento1.getId());
        //System.out.println("Evento trovato: ");
    }
}