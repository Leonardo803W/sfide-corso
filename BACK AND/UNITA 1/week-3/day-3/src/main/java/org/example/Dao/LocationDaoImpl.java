package org.example.Dao;

import jakarta.persistence.EntityManager;
import org.example.eventi.Evento;
import org.example.locations.Location;
import org.example.manager_util.EntityManagerUtil;

public class LocationDaoImpl implements LocationDao{
    @Override
    public void save(Location location) {

        //chiamo l entity manager

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            //devo fare la transizion e per avviarla utilizzo begin
            em.getTransaction().begin();

            // Controllo se esiste già una location con lo stesso nome
            Location existingLocation = em.createQuery("SELECT e FROM Evento e WHERE e.nome = :nome", Location.class)
                    .setParameter("nome", location.getNome())
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            // Se esiste una location con lo stesso nome e ha un ID diverso, gestisci l'errore
            if (existingLocation != null && !existingLocation.getId().equals(location.getId()))
            {
                throw new IllegalArgumentException("Una location con lo stesso titolo esiste già.");
            }

            // controllo che vi sia un id per poterlo salvare
            if(location.getId() == null)
            {

                // em.persist(location) e per mandarlo in persistenza;
                em.persist(location);
            }

            else //se location ha già un id, significa che è stata già salvata nel db, update
            {
                //in questo caso faccio un refresh, quindi un update per aggioranre il metodo e lo posso fare con il marge
                em.merge(location);
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
    public Location getById(Long id) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            //devo fare la transizion e per avviarla utilizzo begin
            em.getTransaction().begin();

            //creo una variabile di tipo evento per recuperare la locationtrovato
            Location locationTrovata = em.find(Location.class,id);

            //committa le modifiche
            em.getTransaction().commit();

            //mi ritorna la location
            return locationTrovata;
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

            //creo una variabile di tipo location per recuperare la location trovato
            Location location = em.find(Location.class,id);

            //controlla che l'evento non sia null e quindi abbia l'id cercato
            if(location!=null)
            {
                em.remove(location);
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
