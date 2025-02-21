package org.example.Dao;

import jakarta.persistence.EntityManager;
import org.example.eventi.Evento;
import org.example.manager_util.EntityManagerUtil;
import org.example.persone.Persona;

public class PersonaDaoImpl implements PersonaDao{
    @Override
    public void save(Persona persona) {

        //chiamo l entity manager

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            //devo fare la transizion e per avviarla utilizzo begin
            em.getTransaction().begin();

            if(persona.getId() == null)
            {

                // em.persist(persona) e per mandarlo in persistenza;
                em.persist(persona);
            }

            else //se la persona ha già un id, significa che è stata già salvata nel db, update
            {
                //in questo caso faccio un refresh, quindi un update per aggioranre il metodo e lo posso fare con il marge
                em.merge(persona);
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
    public Persona getById(Long id) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            //devo fare la transizion e per avviarla utilizzo begin
            em.getTransaction().begin();

            //creo una variabile di tipo persona per recuperare la persona trovata
            Persona personaTrovata = em.find(Persona.class,id);

            //committa le modifiche
            em.getTransaction().commit();

            //mi ritorna la persona
            return personaTrovata;
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

            //creo una variabile di tipo persona per recuperare la persona trovato
            Persona persona = em.find(Persona.class,id);

            //controlla che la persona non sia null e quindi abbia l'id cercato
            if(persona!=null)
            {
                em.remove(persona);
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
