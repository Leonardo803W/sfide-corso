package epicode;

import epicode.DAO.EventoDAO;
import epicode.DAO.EventoImpDAO;
import epicode.entitys.Evento;
import epicode.entitys.TipoEvento;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate data1 = LocalDate.of(2023, 10, 15);

        Evento evento1 = new Evento("lostBar", today, "vieni a cercare i drink perduti", TipoEvento.PUBBLICO, 10);
        Evento evento2 = new Evento("sorf hard", data1, "prova onde da urlo", TipoEvento.PRIVATO, 5);

        EventoDAO eventoDao = new EventoImpDAO();

        eventoDao.save(evento1);
        eventoDao.save(evento2);
        eventoDao.getById(evento1.getId());
    }
}