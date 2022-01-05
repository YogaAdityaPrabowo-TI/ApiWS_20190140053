/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectAkhir.IkanChanna;

import ProjectAkhir.IkanChanna.exceptions.NonexistentEntityException;
import ProjectAkhir.IkanChanna.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author HP
 */
public class ChannaJpaController implements Serializable {

    public ChannaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectAkhir_IkanChanna_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ChannaJpaController() {
    }
    
    

    public void create(Channa channa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(channa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findChanna(channa.getIdIkan()) != null) {
                throw new PreexistingEntityException("Channa " + channa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Channa channa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            channa = em.merge(channa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = channa.getIdIkan();
                if (findChanna(id) == null) {
                    throw new NonexistentEntityException("The channa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Channa channa;
            try {
                channa = em.getReference(Channa.class, id);
                channa.getIdIkan();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The channa with id " + id + " no longer exists.", enfe);
            }
            em.remove(channa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Channa> findChannaEntities() {
        return findChannaEntities(true, -1, -1);
    }

    public List<Channa> findChannaEntities(int maxResults, int firstResult) {
        return findChannaEntities(false, maxResults, firstResult);
    }

    private List<Channa> findChannaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Channa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Channa findChanna(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Channa.class, id);
        } finally {
            em.close();
        }
    }

    public int getChannaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Channa> rt = cq.from(Channa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
