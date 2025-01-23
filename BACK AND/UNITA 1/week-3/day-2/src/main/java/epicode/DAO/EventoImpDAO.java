package epicode.DAO;

import epicode.entitys.EntityManagerUtil;
import epicode.entitys.Evento;
import jakarta.persistence.EntityManager;

public class EventoImpDAO implements EventoDAO
{
    @Override
    public void save(Evento evento)
    {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            if (evento.getId() == null)
            {
                em.persist(evento);
            }
            else
            {
                em.merge(evento);

                em.getTransaction().commit();
            }
        } catch (Exception e) {

            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {

            em.close();
        }
    }

    @Override
    public Evento getById(Long id)
    {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Evento eventoTrovato = em.find(Evento.class, id);
            em.getTransaction().commit();
            return eventoTrovato;

        } catch (Exception e) {

            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        }
        finally {

            em.close();
        }
    }

    @Override
    public void delete(Evento evento)
    {
        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Evento eventoDaCancellare = em.find(Evento.class, getById(evento.getId()));

            if(eventoDaCancellare!=null)
            {
                em.remove(evento);
            }
            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {

            em.close();
        }
    }
}
