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
public class ChannahomestayJpaController implements Serializable {

    public ChannahomestayJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectAkhir_IkanChanna_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ChannahomestayJpaController() {
    }
    
    

    public void create(Channahomestay channahomestay) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(channahomestay);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findChannahomestay(channahomestay.getIdikan()) != null) {
                throw new PreexistingEntityException("Channahomestay " + channahomestay + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Channahomestay channahomestay) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            channahomestay = em.merge(channahomestay);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = channahomestay.getIdikan();
                if (findChannahomestay(id) == null) {
                    throw new NonexistentEntityException("The channahomestay with id " + id + " no longer exists.");
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
            Channahomestay channahomestay;
            try {
                channahomestay = em.getReference(Channahomestay.class, id);
                channahomestay.getIdikan();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The channahomestay with id " + id + " no longer exists.", enfe);
            }
            em.remove(channahomestay);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Channahomestay> findChannahomestayEntities() {
        return findChannahomestayEntities(true, -1, -1);
    }

    public List<Channahomestay> findChannahomestayEntities(int maxResults, int firstResult) {
        return findChannahomestayEntities(false, maxResults, firstResult);
    }

    private List<Channahomestay> findChannahomestayEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Channahomestay.class));
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

    public Channahomestay findChannahomestay(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Channahomestay.class, id);
        } finally {
            em.close();
        }
    }

    public int getChannahomestayCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Channahomestay> rt = cq.from(Channahomestay.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
