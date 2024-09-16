package repository.implementsRepositories;

import repository.helper.EntityManagerHelper;
import repository.interfaceRepository.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class BaseJPARepository<Entity,ID extends Serializable> implements Repository<Entity, ID> {
    private EntityManager em;
    private Class<Entity>entityClass;
    //private Class<ID>idClass;

    public BaseJPARepository(Class<Entity>entityClass, Class<ID> idClass){
        this.entityClass=entityClass;
        //this.idClass=idClass;
    }

    @Override
    public Entity findById(ID id) {
         em = EntityManagerHelper.getEntityManager();
         em.getTransaction().begin();
         Entity entity = em.find(entityClass,id);
         em.getTransaction().commit();
         em.close();
         return entity;
    }

    @Override
    public void persist(Entity entity) {
        em=EntityManagerHelper.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        em.close();
    }

    @Override
    public void delete(Entity entity) {
        em=EntityManagerHelper.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(entity)) {
            entity = em.merge(entity);  // Reanexar la entidad si está detach
        }
        try{

            em.remove(entity);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public abstract List<Entity> findAll();

}
