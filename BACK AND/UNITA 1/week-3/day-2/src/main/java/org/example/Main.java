package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate oggi = LocalDate.now();
        LocalDate date = LocalDate.of(2023, 10, 12);

        Evento lostBar = new Evento("Il Lost Bar", date, "Vivi un evento frizzante e conosci nuove persone!!", tipoEvento.PUBBLICO, 5);
        Evento Ibizza = new Evento("Ibizza", oggi, "Vivi un evento nel divertimento piu folle che ci sia!!", tipoEvento.PRIVATO, 50);

        EventoDAO eventoPlus = new EventoDAO();

        eventoPlus.save(lostBar);
        eventoPlus.save(Ibizza);
    }
}