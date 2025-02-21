package org.example.Dao;

import jakarta.persistence.EntityManager;
import org.example.manager_util.EntityManagerUtil;
import org.example.partecipazioni.Partecipazione;

public class ParteDaoImpl implements PartecipazioneDao{
    @Override
    public void save(Partecipazione partecipazione) {

        //chiamo l entity manager

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            //devo fare la transizion e per avviarla utilizzo begin
            em.getTransaction().begin();

           // controllo che vi sia un id per poterlo salvare
            if(partecipazione.getId() == null)
            {

                // em.persist(partecipazione) e per mandarlo in persistenza;
                em.persist(partecipazione);
            }

            else //se la partecipazione ha già un id, significa che è stata già salvata nel db, update
            {
                //in questo caso faccio un refresh, quindi un update per aggioranre il metodo e lo posso fare con il marge
                em.merge(partecipazione);
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
    public Partecipazione getById(Long id) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            //devo fare la transizion e per avviarla utilizzo begin
            em.getTransaction().begin();

            //creo una variabile di tipo partecipazione per recuperare la partecipazione trovato
            Partecipazione partecipazioneTrovata = em.find(Partecipazione.class,id);

            //committa le modifiche
            em.getTransaction().commit();

            //mi ritorna la partecipazione
            return partecipazioneTrovata;
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

            //creo una variabile di tipo partecipazione per recuperare la partecipazione trovato
            Partecipazione partecipazione = em.find(Partecipazione.class,id);

            //controlla che la partecipazione non sia null e quindi abbia l'id cercato
            if(partecipazione!=null)
            {
                em.remove(partecipazione);
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
