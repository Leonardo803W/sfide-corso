package org.example.Dao;

import jakarta.persistence.EntityManager;
import org.example.eventi.Evento;
import org.example.manager_util.EntityManagerUtil;

import java.util.List;

public class EventoDaoImpl implements EventoDao{
    @Override
    public void save(Evento evento) {

        //chiamo l entity manager

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            //devo fare la transizion e per avviarla utilizzo begin
            em.getTransaction().begin();

            // Controllo se esiste già un evento con lo stesso titolo
            Evento existingEvento = em.createQuery("SELECT e FROM Evento e WHERE e.titolo = :titolo", Evento.class)
                    .setParameter("titolo", evento.getTitolo())
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            // Se esiste un evento con lo stesso titolo e ha un ID diverso, gestisci l'errore
            if (existingEvento != null && !existingEvento.getId().equals(evento.getId()))
            {
                throw new IllegalArgumentException("Un evento con lo stesso titolo esiste già.");
            }

            // controllo che vi sia un id per poterlo salvare
            if(evento.getId() == null)
            {

                // em.persist(evento) e per mandarlo in persistenza;
                em.persist(evento);
            }

            else //se l'evento ha già un id, significa che è stata già salvata nel db, update
            {
                //in questo caso faccio un refresh, quindi un update per aggioranre il metodo e lo posso fare con il marge
                em.merge(evento);
            }

            //committa le modifiche o il salvataggio
            em.getTransaction().commit();

        } catch (Exception e) {

            //in caso di errore controlla se la transizione e attiva e manda un messaggio di errore
            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {

            //che vada bene o male chiudo sempre per liberare risorse
            em.close();
        }
    }

    @Override
    public Evento getById(Long id) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            //devo fare la transizion e per avviarla utilizzo begin
            em.getTransaction().begin();

            //creo una variabile di tipo evento per recuperare l'evento trovato
            Evento eventoTrovato = em.find(Evento.class,id);

            //committa le modifiche
            em.getTransaction().commit();

            //mi ritorna l'evento
            return eventoTrovato;
        } catch (Exception e) {

            //in caso di errore controlla se la transizione e attiva e manda un messaggio di errore
            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            e.printStackTrace();

            //essendo errore non ritorna nulla solo il messaggio di errore
            return null;
        }
        finally {

            //che vada bene o male chiudo sempre per liberare risorse
            em.close();
        }
    }

    @Override
    public void deleteById(Long id) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            //devo fare la transizion e per avviarla utilizzo begin
            em.getTransaction().begin();

            //creo una variabile di tipo evento per recuperare l'evento trovato
            Evento evento = em.find(Evento.class,id);

            //controlla che l'evento non sia null e quindi abbia l'id cercato
            if(evento!=null)
            {
                em.remove(evento);
            }

            //committa le modifiche
            em.getTransaction().commit();

        } catch (Exception e) {

            //in caso di errore controlla se la transizione e attiva e manda un messaggio di errore
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {

            //che vada bene o male chiudo sempre per liberare risorse
            em.close();
        }
    }
}
