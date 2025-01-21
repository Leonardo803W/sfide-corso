package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EventoDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventi");

    EntityManager em = emf.createEntityManager();

    public void save(Evento evento)
    {
        EntityTransaction transaction = em.getTransaction();

        try
        {
            transaction.begin();
            em.persist(evento);
            transaction.commit();
            System.out.println("L'evento e stato salvato con sucesso");
        }
        catch (Exception e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }

            e.printStackTrace();
        }
        finally
        {
            em.close();
        }
    }

    public Evento getById(int id)
    {
        System.out.println("L'evento e stato trovato con sucesso");
        return em.find(Evento.class, id);
    }

    public void delete(int id)
    {
        EntityTransaction transaction = em.getTransaction();

        try
        {
            transaction.begin();

            Evento evento = em.find(Evento.class, id);

            if (evento != null)
            {
                System.out.println("L'evento e stato cancellato con sucesso");
                em.remove(evento);
            }

            transaction.commit();
        }
        catch (Exception e)
        {
            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }

            e.printStackTrace();
        }
        finally
        {
            em.close();
        }
    }

    public static EntityManagerFactory getEmf()
    {
        return emf;
    }

    public static void close()
    {
        emf.close();
    }
}
